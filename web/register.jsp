<%--
  Created by IntelliJ IDEA.
  User: stones
  Date: 2018/7/13
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页</title>
</head>
<body>
<form method="post" action="/first">
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
            <td>性别：</td>
            <td><input type="radio" name="sex" value="male"/>男
                <input type="radio" name="sex" value="female"/>女</td>
        </tr>
        <tr>
            <td>兴趣：</td>
            <td>
                <input type="checkbox" name="interster" value="1"/>足球
                <input type="checkbox" name="interster" value="2"/>游泳
                <input type="checkbox" name="interster" value="3"/>吃鸡
            </td>
        </tr>
        <tr>
            <td>籍贯：</td>
            <td>
                <select name="address">
                    <option value="nc">南昌</option>
                    <option value="jiujiang">九江</option>
                    <option value="ganzhou">赣州</option>
                    <option value="fuzhou">抚州</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
    <%=session.getAttribute("username")%>
</form>
</body>
</html>
