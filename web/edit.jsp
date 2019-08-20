<%--
  Created by IntelliJ IDEA.
  User: monako
  Date: 2019-08-20
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>修改学生信息</title>
    <style>
        tr>td:first-child,h3{
            text-align: center;
        }
    </style>
</head>
<body>
<h3>修改学生信息</h3>
<form method="post" action="StudentEditServelet">
    <table border="1" width="720" align="center">
        <tr>
            <td>编号</td>
            <td>
                <label>
                    <input type="text" name="id" value="${student.id}" />
                </label>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <label>
                    <input type="text" name="name" value="${student.name}" />
                </label>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <label>
                    <input type="radio" name="gender" value="男"
                            <c:if test="${student.gender=='男'}">checked</c:if>
                    />男
                </label>
                <label>
                    <input type="radio" name="gender" value="女"
                           <c:if test="${student.gender=='女'}">checked</c:if>
                    />女
                </label>
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td>
                <label>
                    <input type="text" name="phone" value="${student.phone}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <label>
                    <input type="date" name="birthday" value="${student.birthday}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <label>
                    <input type="checkbox" name="hobby" value="游泳"
                           <c:if test="${fn:contains(student.hobby, '游泳')}">checked</c:if>
                    />游泳
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="篮球"
                           <c:if test="${fn:contains(student.hobby, '篮球')}">checked</c:if>
                    />篮球
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="足球"
                           <c:if test="${fn:contains(student.hobby, '足球')}">checked</c:if>
                    />足球
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="看书"
                           <c:if test="${fn:contains(student.hobby, '看书')}">checked</c:if>
                    />看书
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="游戏"
                           <c:if test="${fn:contains(student.hobby, '游戏')}">checked</c:if>
                    />游戏
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="音乐"
                           <c:if test="${fn:contains(student.hobby, '音乐')}">checked</c:if>
                    />音乐
                </label>
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <label>
                    <textarea type="text" name="info" cols="100" rows="3">${student.info}</textarea>
                </label>
            </td>
        </tr>
        <tr>
            <td aria-colspan="2">
                <input type="submit" value="修改" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>

