package com.iminit.blog;

import com.iminit.common.model.Blog;
import com.iminit.common.utils.Format;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

    static BlogService service = new BlogService();

    public void index() {
        render("blog.html");
    }

    public void list() {
        Integer page = getParaToInt("page", 1);
        Integer limit = getParaToInt("limit", 10);
        Page<Blog> paginate = service.paginate(page, limit);
        renderJson(Format.layuiPage(paginate));
    }

    public void add() {
        render("blogAdd.html");
    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void save() {
        getModel(Blog.class).save();
        redirect("/blog/");
    }

    public void edit() {
        setAttr("blog", service.findById(getParaToInt()));
    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void update() {
        getModel(Blog.class).update();
        redirect("/blog/");
    }

    public void delete() {
        service.deleteById(getParaToInt());
        redirect("/blog");
    }

}


