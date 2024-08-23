package com.example.springboot04.config;


import ch.qos.logback.classic.turbo.TurboFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser=request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            //没有登陆
            request.setAttribute("msg","没有登陆,无法进入后台！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }

}
