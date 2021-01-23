package com.chl.cookie;

import com.chl.Base.BaseServlet;
import com.chl.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    public void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie=new Cookie("key1","valu1");
        //通知客户端保存
        response.addCookie(cookie);
        response.getWriter().write("cookie创建成功");
    }
    public void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Cookie[] cookies=request.getCookies();
         for(Cookie cookie:cookies){
             response.getWriter().write("cookie"+cookie.getName());
         }
    }
    public void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie= CookieUtils.findCookie("key1",request.getCookies());
        if(cookie!=null){
            cookie.setValue("newValue");
            response.addCookie(cookie);
        }
        response.getWriter().write("cookie"+cookie.getValue());
    }
    public void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间默认就为-1
        response.addCookie(cookie);
    }
    public void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=CookieUtils.findCookie("key1",request.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(60*60*100);
            response.addCookie(cookie);
        }
    }
    public void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Cookie cookie=CookieUtils.findCookie("key1",request.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
    //设置path路径可以有效过滤哪些cookie可以发送给服务器
    public void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie=new Cookie("key2","valu2");
        //得到工程路径
        cookie.setPath(request.getContextPath()+"/abc");//工程路径/abc
        response.addCookie(cookie);
        response.getWriter().write("cookie创建成功,带有path");
    }



}
