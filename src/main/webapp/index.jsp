<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: chl
  Date: 2021/1/3
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--声明式脚本

可以声明java代码--%>
<%!
    private String a;
    /*
    * 声明内部类
    * */
    public static class a{

    }
    /*
    * 声明方法
    * */
    public void a(){
        Map<String,a> b;
    }


%>
<%
    /*
    * 四大域域对象
    * */
    pageContext.setAttribute("key1","a"); //当前页面有效
    request.setAttribute("key2","b");//一次请求有效
    session.setAttribute("key3","c");//一次会话有效
    application.setAttribute("key4","d");//整个web工程有效

%>
<%=pageContext.getAttribute("key1")%>
<%=request.getAttribute("key2")%>
<%=session.getAttribute("key3")%>
<%=application.getAttribute("key4")%>
<%--EL表达式--%>
${

        12==12
 }
<%--EL获取四个特定域中的属性--%>
${applicationScope.key4}
${pageScope.key1}
<%--
request.getScheme
request.getServerName
request.getServerPort
request.getContextPath
request.getMethod
request.getRemoteHost
session.getId
--%>
<%--pageContext--%>
1.协议${pageContext.request.scheme}
2.服务器ip${pageContext.request.serverName}
3.服务器端口${pageContext.request.serverPort}
4.获取工程路径${pageContext.request.contextPath}
5.获取请求方法${pageContext.request.method}
6.获取客户端IP地址${pageContext.request.remoteHost}
7.获取回话id${pageContext.session.id}
<%--其他EL隐含对象的式例--%>
8.输出请求参数${paramValues.username[0]}<br/>
9.输出请求头${headerValues["User-Agent"][0]}
9.输出请求头${header.Connection}
<%--JSTL标签库--%>
<%--set标签往域中保存数据--%>
<c:set scope="page" var="key5" value="aaa" ></c:set>
${pageScope.key5}
<%--if标签用来条件判断--%>
<c:if test="${12==12}">
    111
</c:if>
<%-- --%>
<c:choose>
    <c:when test="${12==12}">
        ddd
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${12==12}">
                ddd
            </c:when>
        </c:choose>
    </c:otherwise>
</c:choose>
<c:forEach begin="1" end="10" var="i">
    ${i}
</c:forEach>
<%
    request.setAttribute("arr" ,new String[]{"11","22"});
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item}
</c:forEach>

<%--
文件上传
1.必须要有一个form标签method=post请求
2.form标签的encType属性必须为multipart/form-data
表示提交的数据一多段（每一个表单项表示一个数据段）的形式进行拼接，然后以二进制流的形式发给服务器

--%>
<form action="http://localhost:8080/webProject_war/uploadServlet" method="post"enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br>
    头像：<input type="file" name="photo">
    <input type="submit" value="上传">


</form>
</body>

</html>
