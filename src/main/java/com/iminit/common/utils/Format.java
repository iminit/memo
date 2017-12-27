package com.iminit.common.utils;

import com.iminit.common.interceptor.Result;
import com.iminit.common.model.File;
import com.iminit.file.FileController;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/27 0027.
 */
public class Format {
    public static Map<String, Object> layuiPage(Page<?> page) {
        return layuiPage(page, 0, "");
    }

    /**
     * 按照layUI格式分页获取数据
     *
     * @param page
     * @param code
     * @param message
     */
    public static Map<String, Object> layuiPage(Page<?> page, int code, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", message);
        result.put("count", page.getTotalRow());
        result.put("data", page.getList());
        return result;
    }

    public static Result result(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(data);
        return result;
    }

    public static Result layuiFile(File file, FileController controller) {
        Kv set = Kv.by("src", controller.getRequest().getContextPath() + "/file/get/" + file.getId())
                .set("title", file.getName());
        return result(set);
    }

}
