<%@ page import="java.util.List" %>
<%@ page import="com.jxlg.entity.Clazz" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/web.css" rel="stylesheet">
</head>
<body>
<ul>
    <li>HTML/CSS</li>
    <li>JavaScript</li>
    <li>
        <a href="#">ASP.NET</a>
        <ul>
            <li>C#语言</li>
            <li>SQL Server数据库</li>
        </ul>
    </li>
</ul>
欢迎你，【<%=session.getAttribute("username")%>】
<br/><br/><br/><br/>
   <%--jsp 内置对象--%>
        <%--在页面里可以直接使用，不需要通过new来创建--%>
        <%--request  请求 --%>
        <%--out      将内容输出到页面--%>
    <%
        String name = (String)request.getAttribute("name");
        String password = (String)request.getAttribute("pwd");
        out.print("你输入的用户名是：" + name + ",密码是：" +
                   password + "!");
    %>
    <table>
        <tr>
            <th>序号</th>
            <th>姓名</th>
        </tr>

    <%
        List<Clazz> list = (List) request.getAttribute("list");
        for (Clazz c : list) {
      %>
       <tr>
            <th><%=c.getId()%></th>
            <th><%=c.getName()%></th>
        </tr>
    <%
        }
    %>
    </table>
  <%--jstl取servlet传递给页面的request对象中list属性的数据--%>
    <table>
        <c:forEach items="${list}" var="l">
            <tr>
                <th>${l.id}</th>
                <th>${l.name}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
