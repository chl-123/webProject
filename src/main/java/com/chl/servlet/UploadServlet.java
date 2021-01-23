package com.chl.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先判断上传的数据是否是多段数据（只有是多段的数据，才是文件上传）
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list=servletFileUpload.parseRequest(req);
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString());
                    }
                    else {
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getName());
                        fileItem.write(new File("C:\\Users\\chl\\Desktop\\1\\"+fileItem.getName()));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
