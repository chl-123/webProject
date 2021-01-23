package com.chl.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestFilterLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if ("chl".equals(username)&& "123".equals(password)) {
            request.getSession().setAttribute("user",username);
            response.getWriter().write("登录成功");
        }
        else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
