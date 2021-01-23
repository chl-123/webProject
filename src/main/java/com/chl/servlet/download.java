package com.chl.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class download extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要下载的文件名
        String downloadFileName = "ASCII.jpg";
        //获取要下载的文件内容（通过ServletContext对象可以获取）
        ServletContext servletContext = getServletContext();
        //获取要下载文件的类型
        String MimeType = servletContext.getMimeType("/file/" + downloadFileName);
        //在回传前通过响应告诉客户端返回的数据类型
        resp.setContentType(MimeType);
        //告诉客户端收到的数据用于下载的（使用响应头）Content-Disposition表示收到的数据怎么处理attachment
        //表示附件
        if(req.getHeader("User-Agent").contains("FireFox")){
            resp.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8"))+"?=");
        }else {
            resp.setHeader("Content-Disposition","attachment;filename="+downloadFileName);

        }
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取相应的输出流
        OutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);


    }
}
