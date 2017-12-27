package com.iminit.memo;

import com.iminit.common.model.Memo;
import com.iminit.common.utils.Format;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Page;

/**
 * Memo 管理
 * 描述：
 */
public class MemoController extends Controller {

    private static final Log log = Log.getLog(MemoController.class);

    static MemoService srv = MemoService.me;

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

}