package com.iminit.memo;

import com.iminit.common.model.Memo;
import com.iminit.common.utils.Format;
import com.iminit.common.utils.poi.PoiRender;
import com.iminit.file.FileService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

import java.util.List;

/**
 * Memo 管理
 * 描述：
 */
public class MemoController extends Controller {

    private static final Log log = Log.getLog(MemoController.class);

    static MemoService srv = MemoService.me;
    static FileService fileSrv = FileService.me;

    public void index() {
        render("memo.html");
    }

    /**
     * 列表
     * /iminit/memo/list
     */
    public void list() {
        Integer page = getParaToInt("page", 1);
        Integer limit = getParaToInt("limit", 10);
        Page<Memo> paginate = srv.paginate(page, limit);
        renderJson(Format.layuiPage(paginate));
    }

    /**
     * 准备添加
     * /iminit/memo/add
     */
    public void add() {
        render("memoAdd.html");
    }

    /**
     * 保存
     * /iminit/memo/save
     */
    @Before({MemoValidator.class})
    public void save() {
        Memo model = getModel(Memo.class);
        srv.save(getModel(Memo.class));
        redirect("/memo");
    }

    /**
     * 准备更新
     * /iminit/memo/edit
     */
    public void edit() {
        Memo memo = srv.findById(getParaToInt("id"));
        setAttr("memo", memo);
        render("memoEdit.html");
    }

    /**
     * 更新
     * /iminit/memo/update
     */
    @Before(MemoValidator.class)
    public void update() {
        srv.update(getModel(Memo.class));
        renderJson("isOk", true);
    }

    /**
     * 查看
     * /iminit/memo/view
     */
    public void view() {
        Memo memo = srv.findById(getParaToInt("id"));
        setAttr("memo", memo);
        render("memoView.html");
    }

    /**
     * 删除
     * /iminit/memo/delete
     */
    public void delete() {
        srv.delete(getParaToInt("id"));
        renderJson("isOk", true);
    }

    public void importExcel() {
        UploadFile uplad = getFile();
        fileSrv.saveUploadFile(uplad);
        renderJson(srv.importData(uplad));
    }

    public void exportExcel() {
        String[] header = {"节次/周", "一", "二", "三", "四", "五", "五"};
        String[] columns = {"id", "title", "content", "category", "user", "create_time", "update_time"};
        String fileName = "memo";
        List<Memo> objs = objs = Memo.dao.find("select * from memo");
        render(PoiRender.me(objs).fileName(fileName + ".xls").headers(header).columns(columns).cellWidth(5000).headerRow(1));
    }

}