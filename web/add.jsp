<%--
  Created by IntelliJ IDEA.
  User: monako
  Date: 2019-08-19
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <style>
        tr>td:first-child,h3{
            text-align: center;
        }
    </style>
</head>
<body>
<h3>添加学生页面</h3>
<form method="post" action="StudentAddServlet">
    <table border="1" width="720" align="center">
        <tr>
            <td>姓名</td>
            <td>
                <label>
                    <input type="text" name="name" />
                </label>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <label>
                    <input type="radio" name="gender" value="男" aria-selected="true"/>男
                </label>
                <label>
                    <input type="radio" name="gender" value="女"/>女
                </label>
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td>
                <label>
                    <input type="text" name="phone" />
                </label>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <label>
                    <input type="date" name="birthday" />
                </label>
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <label>
                    <input type="checkbox" name="hobby" value="游泳"/>游泳
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="篮球"/>篮球
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="足球"/>足球
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="看书"/>看书
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="游戏"/>游戏
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="音乐"/>音乐
                </label>
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <label>
                    <textarea type="text" name="info" cols="100" rows="3"></textarea>
                </label>
            </td>
        </tr>
        <tr>
            <td aria-colspan="2">
                <input type="submit" value="添加" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
