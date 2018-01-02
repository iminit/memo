package com.iminit.file;

import com.iminit.common.model.File;
import com.iminit.common.utils.Format;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

/**
 * File 管理
 * 描述：
 */
public class FileController extends Controller {

    private static final Log log = Log.getLog(FileController.class);

    static FileService srv = FileService.me;

    public void get(){
        Integer fileId = getParaToInt(0);
        File file = srv.findById(fileId);
        renderFile(file.getName());
    }

    public void upload() {
        UploadFile uplad = getFile();
        File file = srv.saveUploadFile(uplad);
        renderJson(Format.layuiFile(file, this));
    }

    /**
     * 列表
     * /iminit/file/list
     */
    public void img() {
        render("img.html");
    }

    /**
     * 列表
     * /iminit/file/list
     */
    public void imglist() {
        Integer page = getParaToInt("page", 1);
        Integer limit = getParaToInt("limit", 10);
        Page<File> paginate = srv.paginateImg(page, limit);
        renderJson(Format.layuiPage(paginate));
    }


    /**
     * 列表
     * /iminit/file/list
     */
    public void index() {
        render("file.html");
    }

    /**
     * 列表
     * /iminit/file/list
     */
    public void list() {
        Integer page = getParaToInt("page", 1);
        Integer limit = getParaToInt("limit", 10);
        Page<File> paginate = srv.paginate(page, limit);
        renderJson(Format.layuiPage(paginate));
    }

    /**
     * 准备添加
     * /iminit/file/add
     */
    public void add() {
        render("fileAdd.html");
    }

    /**
     * 保存
     * /iminit/file/save
     */
    @Before({FileValidator.class})
    public void save() {
        srv.save(getModel(File.class));
        renderJson("isOk", true);
    }

    /**
     * 准备更新
     * /iminit/file/edit
     */
    public void edit() {
        File file = srv.findById(getParaToInt("id"));
        setAttr("file", file);
        render("fileEdit.html");
    }

    /**
     * 更新
     * /iminit/file/update
     */
    @Before(FileValidator.class)
    public void update() {
        srv.update(getModel(File.class));
        renderJson("isOk", true);
    }

    /**
     * 查看
     * /iminit/file/view
     */
    public void view() {
        File file = srv.findById(getParaToInt("id"));
        setAttr("file", file);
        render("fileView.html");
    }

    /**
     * 删除
     * /iminit/file/delete
     */
    public void delete() {
        srv.delete(getParaToInt("id"));
        renderJson("isOk", true);
    }

}