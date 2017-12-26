package com.demo.blog;

import com.demo.common.model.Blog;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
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
        return dao.paginate(pageNumber, pageSize, "select *", "FROM `blog` where (DATE_SUB(CURDATE(), INTERVAL 2 DAY) <= date(create_time)) and (DATE_SUB(CURDATE(), INTERVAL 1 DAY) >= date(create_time))");
    }

    public Blog findById(int id) {
        return dao.findById(id);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }


}
