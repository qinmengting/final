package com.qin.util.interceptor;

import com.qin.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登录检查拦截器
public class LoginInterceptor implements HandlerInterceptor {
    // 登录之前检查, 返回true放行, 否则拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object auth = request.getSession().getAttribute("auth");
        // 没有登录
        //System.out.println(UserContext.getCurrentUser());
        if (UserContext.getCurrentUser() == null) {
            response.sendRedirect("/login");
            request.setAttribute("msg","无权限");
            return false;   // 阻止往后放行
        }
        request.setAttribute("auth",auth);
        return true;    // 放行, 放行给下一个拦截器或最终的处理器
    }
}
