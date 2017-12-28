package com.iminit.index;

import com.iminit.common.model.Memo;
import com.iminit.common.utils.CS;
import com.iminit.memo.MemoService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * IndexController
 */
public class IndexController extends Controller {
    public void index() {
        Integer type = getParaToInt(0, CS.TYPE_1);
        if (type > CS.TYPE_3 || type < CS.TYPE_1) {
            type = CS.TYPE_1;
        }
        List<Record> data = srv.getData2(type);
        setAttr("memos", data);
    }

    public void admin() {
        render("admin.html");
    }

    static MemoService srv = MemoService.me;

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



