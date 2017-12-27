package com.iminit.index;

import com.iminit.common.model.Memo;
import com.iminit.memo.MemoService;
import com.jfinal.core.Controller;

/**
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		render("index.html");
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



