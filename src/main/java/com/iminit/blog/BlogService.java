package com.iminit.blog;

import com.iminit.common.model.Blog;
import com.jfinal.plugin.activerecord.Page;

/**<p>
 * BlogService
 * 所有 sql 与业务逻辑写在 Service 中，不要放在 Model 中，更不
 * 要放在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
public class BlogService {

    /**
     * 所有的 dao 对象也放在 Service 中
     */
    private static final Blog dao = new Blog().dao();

    public Page<Blog> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "FROM `blog` ORDER BY create_time DESC");
    }

    public Blog findById(int id) {
        return dao.findById(id);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }


}
