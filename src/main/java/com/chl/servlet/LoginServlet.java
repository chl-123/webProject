package com.chl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if ("chl".equals(username)&& "123".equals(password)) {
            Cookie cookie=new Cookie("username",username);
            cookie.setMaxAge(60*60*7*24);
            response.addCookie(cookie);
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }
    }
}
