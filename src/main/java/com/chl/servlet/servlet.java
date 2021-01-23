package com.chl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet extends HttpServlet {
    /*
    * doGet()在get的请求是调用
    * 1.form标签 method=get
    * 2.a标签
    * 3.link标签引入css
    * 4.Script标签引入js文件
    * 5.img标签引入图片
    * 6.iframe引入html页面
    * 7.在浏览器地址栏中输入地址后回车
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("get");
        //获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+password);


    }
    /*
    * doPost()在执行post请求时调用
    * 1.form标签 method=post
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("get");
    }
}
