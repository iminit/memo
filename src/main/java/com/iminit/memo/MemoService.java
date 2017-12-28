package com.iminit.memo;

import com.iminit.common.model.Memo;
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