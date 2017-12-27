package com.iminit.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * Created by Administrator on 2017/12/27 0027.
 */
public class ParameterInterceptor implements Interceptor {

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        controller.setAttr("path", controller.getRequest().getContextPath());
        inv.invoke();
    }
}
