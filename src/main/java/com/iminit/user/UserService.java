package com.iminit.user;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.iminit.common.model.User;

import java.util.List;

/**
 * User 管理	
 * 描述：
 */
public class UserService {

	//private static final Log log = Log.getLog(UserService.class);
	
	public static final UserService me = new UserService();
	private final User dao = new User().dao();
	
	
	/**
	* 列表-分页
	*/
	public Page<User> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "SELECT * ", "FROM user");
	}
	
	/**
	* 保存
	*/
	public void save(User user) {
		user.save();
	}
	
	/**
	* 更新
	*/
	public void update(User user) {
		user.update();
	}
	
	/**
	* 查询
	*/
	public User findById(int userId) {
		return dao.findFirst("select * from user where id=?", userId);
	}
	
	/**
	* 删除
	*/
	public void delete(int userId) {
		Db.update("delete from user where id=?", userId);
	}


	public List<User> dataList() {
		return dao.find("select * from user");
	}
}