package com.chl.filer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    //doFilter方法，专门用于拦截请求可以做权限检查
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;


        HttpSession session=httpServletRequest.getSession();
        Object user=session.getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);//请求转发
            return;
        }else {
            chain.doFilter(request,response);//执行下一个Filter过滤器（如果有），直到没有Filter之后执行目标资源
        }

    }

    @Override
    public void destroy() {

    }
}
