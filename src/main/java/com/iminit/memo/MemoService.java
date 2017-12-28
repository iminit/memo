package com.iminit.memo;

import com.iminit.common.model.Memo;
import com.iminit.common.utils.CS;
import com.iminit.common.utils.poi.ExcelKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.upload.UploadFile;

import java.util.List;
import java.util.Map;

/**
 * Memo 管理
 * 描述：
 */
public class MemoService {

    //private static final Log log = Log.getLog(MemoService.class);

    public static final MemoService me = new MemoService();
    private final Memo dao = new Memo().dao();


    /**
     * 列表-分页
     */
    public Page<Memo> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "SELECT * ", "FROM memo ORDER BY create_time DESC");
    }

    /**
     * 保存
     */
    public void save(Memo memo) {
        memo.save();
    }

    /**
     * 更新
     */
    public void update(Memo memo) {
        memo.update();
    }

    /**
     * 查询
     */
    public Memo findById(int memoId) {
        return dao.findFirst("select * from memo where id=?", memoId);
    }

    /**
     * 删除
     */
    public void delete(int memoId) {
        Db.update("delete from memo where id=?", memoId);
    }

    /**
     * 获取数据
     *
     * @param day 获取第key天的数据
     * @return
     */
    public List<Record> getData(int day) {
        List<Record> records = Db.find("SELECT * FROM memo m WHERE DATEDIFF(NOW(), create_time) = ? ORDER BY create_time DESC", day);
        return records;
    }

    /**
     * 获取数据
     *
     * @param day 获取几天的数据
     * @return
     */
    public List<Record> getData2(int day) {
//        StringBuilder sql = new StringBuilder();
//        String temp = "SELECT * FROM memo m WHERE DATEDIFF(NOW(), create_time) = ?";
//        sql.append(temp);
//        for (int i = 1; i < days.length; i++) {
//            sql.append(" UNION ").append(temp);
//        }
//        sql.append(" ORDER BY create_time DESC");
//        // // FIXME: 2017/12/28 0028 可变参数出现问题，提示错误：第二个参数没有赋值
//        List<Record> records = Db.find(sql.toString(), days);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM memo m WHERE DATEDIFF(NOW(), create_time) = ? \n" +
                "UNION \n" +
                "SELECT * FROM memo m WHERE DATEDIFF(NOW(), create_time) = ? \n" +
                "UNION \n" +
                "SELECT * FROM memo m WHERE DATEDIFF(NOW(), create_time) = ? \n" +
                "ORDER BY create_time DESC");
        switch (day) {
            case CS.TYPE_3:
                return Db.find(sql.toString(), 32, 64, 128);
            case CS.TYPE_2:
                return Db.find(sql.toString(), 4, 8, 16);
            default:
                return Db.find(sql.toString(), 0, 1, 2);
        }
    }

    /**
     * 获取数据缓存
     *
     * @param day
     * @return
     */
    // TODO 缓存没有配置成功
    public List<Record> getCacheData(int day) {
        List<Record> records = CacheKit.get("60time", "list/" + day + "-day");
        if (records == null) {
            records = getData(day);
            CacheKit.put("60time", "list/" + day + "-day", records);
        }
        return records;
    }

    public Map<String, Object> importData(UploadFile uplad) {
        String insertSql = "insert into memo (title,content,category,user) values(?,?,?,?)";
        String deleteSql = "delete from memo";
        return ExcelKit.importData(uplad, insertSql, true, deleteSql);
    }

}