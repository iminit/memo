package com.demo.memo;

import com.demo.common.model.Memo;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;

/**
 * Memo 管理
 * 描述：
 */
public class MemoController extends Controller {

    private static final Log log = Log.getLog(MemoController.class);

    static MemoService srv = MemoService.me;

    public void index() {
        render("index.html");
    }

    /**
     * 列表
     * /demo/memo/list
     */
    public void list() {
        setAttr("page", srv.paginate(getParaToInt("p", 1), 40));
        render("memoList.html");
    }

    /**
     * 准备添加
     * /demo/memo/add
     */
    public void add() {
        render("memoAdd.html");
    }

    /**
     * 保存
     * /demo/memo/save
     */
    @Before({MemoValidator.class})
    public void save() {
        srv.save(getModel(Memo.class));
        renderJson("isOk", true);
    }

    /**
     * 准备更新
     * /demo/memo/edit
     */
    public void edit() {
        Memo memo = srv.findById(getParaToInt("id"));
        setAttr("memo", memo);
        render("memoEdit.html");
    }

    /**
     * 更新
     * /demo/memo/update
     */
    @Before(MemoValidator.class)
    public void update() {
        srv.update(getModel(Memo.class));
        renderJson("isOk", true);
    }

    /**
     * 查看
     * /demo/memo/view
     */
    public void view() {
        Memo memo = srv.findById(getParaToInt("id"));
        setAttr("memo", memo);
        render("memoView.html");
    }

    /**
     * 删除
     * /demo/memo/delete
     */
    public void delete() {
        srv.delete(getParaToInt("id"));
        renderJson("isOk", true);
    }

    /**
     * 数据请求接口
     * get/0-day,get/1-day
     */
    public void detail() {
        Memo memo = srv.findById(getParaToInt(0));
        setAttr("memo", memo);
        render("detail.html");
    }

    /**
     * 数据请求接口
     * get/0-day,get/1-day
     */
    public void get() {
        Integer day = getParaToInt(0);
        if (checkVaild(day)) {
            renderJson(srv.getData(day));
        } else {
            renderJson("isOk", false);
        }
    }

    /**
     * 检查参数是否2的倍数，0也在内
     *
     * @param day
     * @return
     */
    private boolean checkVaild(int day) {
        double temp = 0;
        int i = 0;
        while (day >= temp) {
            if (temp == day) {
                return true;
            }
            temp = Math.pow(2, i++);
        }
        return false;
    }


    /**
     * 创建新记录
     */
    public void create() {
        render("create.html");
    }
    public void docreate() {
        srv.save(getModel(Memo.class));
        redirect("/");
    }

}