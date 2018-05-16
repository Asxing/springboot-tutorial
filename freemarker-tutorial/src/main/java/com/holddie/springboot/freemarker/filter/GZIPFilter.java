package com.holddie.springboot.freemarker.filter;

import com.holddie.springboot.freemarker.framework.SpringUtil;
import com.holddie.springboot.freemarker.framework.cache.ICache;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class GZIPFilter implements Filter {

    @Autowired
    ICache cache;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        ICache cache= (ICache) ApplicationContextRegister.getApplicationContext().getBean("cache");
//        ICache cache = (ICache) SpringUtil.getBean("cache");
        System.out.println(cache.toString());
    }

    public void init(FilterConfig filterConfig) {
//        ICache cache = (ICache) SpringUtil.getBean("cache");
        System.out.println(cache.toString());
    }

    public void destroy() {
        //
    }
}
