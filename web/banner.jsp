
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
