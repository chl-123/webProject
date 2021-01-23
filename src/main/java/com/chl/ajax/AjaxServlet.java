package com.chl.ajax;

import com.chl.Base.BaseServlet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AjaxServlet extends BaseServlet {

    public void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("JQuery");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"小明");
        map.put(2,"小红");
        Gson gson=new Gson();
        String person=gson.toJson(map);
        response.getWriter().write(person);
    }
    public void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("JQuery");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"小明");
        map.put(2,"小红");
        Gson gson=new Gson();
        String person=gson.toJson(map);
        response.getWriter().write(person);
    }
    public void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("JQueryGet");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"小明");
        map.put(2,"小红");
        Gson gson=new Gson();
        String person=gson.toJson(map);
        response.getWriter().write(person);
    }
    public void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("JQuerypost");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"小明");
        map.put(2,"小红");
        Gson gson=new Gson();
        String person=gson.toJson(map);
        response.getWriter().write(person);
    }
    public void jQueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("JQueryGetJson");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"小明");
        map.put(2,"小红");
        Gson gson=new Gson();
        String person=gson.toJson(map);
        response.getWriter().write(person);
    }
    public void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("JQueryjQuerySerialize");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"小明");
        map.put(2,"小红");
        Gson gson=new Gson();
        String person=gson.toJson(map);
        response.getWriter().write(person);
    }
}
