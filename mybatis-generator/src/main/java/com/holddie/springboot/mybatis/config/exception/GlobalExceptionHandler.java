package com.holddie.springboot.mybatis.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 18:18
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = org.apache.shiro.authz.UnauthorizedException.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
//        response.sendRedirect("/500.html");
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", request.getRequestURL());
//        mav.setViewName("admin/403");
//        return mav;
//    }
}
