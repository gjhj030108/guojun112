/*

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(request.getRequestURI().contains("goLogin")) {
            return true;
        }
        if(request.getRequestURI().contains("login")) {
            return true;
        }
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return false;
    }
}
*/

package com.guo.config;

import com.guo.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            HttpSession session = request.getSession();
            //统一拦截（查询当前session是否存在user)
            User user = (User) session.getAttribute("user");
            if (user != null) {
                return true;
            }
            //为空重新登录
            response.sendRedirect("/login");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
