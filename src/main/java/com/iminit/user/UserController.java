package com.iminit.user;

import com.iminit.common.model.User;
import com.iminit.common.utils.Format;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Page;

/**
 * User 管理	
 * 描述：
 * 
 */
public class UserController extends Controller {

	private static final Log log = Log.getLog(UserController.class);
	
	static UserService srv = UserService.me;

	public void index() {
		render("user.html");
	}

	public void data() {
		renderJson(srv.paginate(getParaToInt("p", 1), 40));
	}

	/**
	 * 列表
	 * /iminit/user/list
	 */
	public void list() {
		Integer page = getParaToInt("page", 1);
		Integer limit = getParaToInt("limit", 10);
		Page<User> paginate = srv.paginate(page, limit);
		renderJson(Format.layuiPage(paginate));
	}
	
	/**
	 * 准备添加
	 * /iminit/user/add
	 */
	public void add() {
		render("userAdd.html");
	}
	
	/**
	 * 保存
	 * /iminit/user/save
	 */
	@Before({UserValidator.class})
	public void save() {
		srv.save(getModel(User.class));
		renderJson("isOk", true);
	}

	/**
	 * 准备更新
	 * /iminit/user/edit
	 */
	public void edit() {
		User user = srv.findById(getParaToInt("id"));
		setAttr("user", user);
		render("userEdit.html");
	}

	/**
	 * 更新
	 * /iminit/user/update
	 */
	@Before(UserValidator.class)
	public void update() {
		srv.update(getModel(User.class));
		renderJson("isOk", true);
	}

	/**
	 * 查看
	 * /iminit/user/view
	 */
	public void view() {
		User user = srv.findById(getParaToInt("id"));
		setAttr("user", user);
		render("userView.html");
	}
	 
	/**
	 * 删除
	 * /iminit/user/delete
	 */
	public void delete() {
		srv.delete(getParaToInt("id"));
		renderJson("isOk", true);
	}
	
}