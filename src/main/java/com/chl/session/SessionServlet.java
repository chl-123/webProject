package com.chl.session;
import com.chl.Base.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class SessionServlet extends BaseServlet {
    public void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        boolean isNew=session.isNew();
        String id=session.getId();
        resp.getWriter().write("得到的sessionid"+id+"<br/>");
        resp.getWriter().write("得到的session是否为新的"+isNew);
    }
    public void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value");
    }
    public void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute=req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取key1" +attribute);
    }
    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval=req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长"+maxInactiveInterval);
    }
    public void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("session的默认超时时长"+session.getMaxInactiveInterval());
    }
    public void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        resp.getWriter().write("session已经无效");

    }



}
