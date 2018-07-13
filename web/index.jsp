<%--
  Created by IntelliJ IDEA.
  User: stones
  Date: 2018/7/13
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录页</title>
  </head>
  <body>
    <form method="get" action="/first">
      <table>
        <tr>
          <td>姓名：</td>
          <td><input type="text" name="username"></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input type="password" name="userpwd"></td>
        </tr>
        <tr>
          <td>
            <a href="register.jsp">注册</a>
          </td>
          <td><input type="submit" value="登录"></td>
        </tr>
      </table>
    </form>
  </body>
</html>
