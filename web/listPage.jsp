<%--
  Created by IntelliJ IDEA.
  User: monako
  Date: 2019-08-19
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h3 align="center">学生列表</h3>
<form method="post" action="StudentSearchServlet">
    <table border="1" width="720" align="center">
        <tr align="center">
            <td colspan="8" align="left">
                <label>按姓名查询：
                    <input type="text" name="name" />
                </label>
                <label>按性别查询：
                    <select name="gender">
                        <option value="">请选择</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </label>
                <input type="submit" value="查询">
                <a href="add.jsp">添加</a>
            </td>
        </tr>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageBean.list }" var="stu">
            <tr>
                <td>${stu.id }</td>
                <td>${stu.name }</td>
                <td>${stu.gender }</td>
                <td>${stu.phone }</td>
                <td>${stu.birthday }</td>
                <td>${stu.hobby }</td>
                <td>${stu.info }</td>
                <td>
                    <a href="StudentUserInfoServelet?id=${stu.id}">更新</a>
                    <a href="javascript:;" onclick="doDelete(${stu.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                第${pageBean.currentPage} / ${pageBean.totalPage}页
                每页显示${pageBean.pageSize}条
                共${pageBean.totalSize}条
                <c:if test="${pageBean.currentPage != 1}">
                    <a href="StudentListPageServlet?currentPage=1">首页</a>｜
                    <a href="StudentListPageServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
                </c:if>
                <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                    <c:if test="${pageBean.currentPage != i}">
                        <a href="StudentListPageServlet?currentPage=${i}">${i}</a>
                    </c:if>
                    <c:if test="${pageBean.currentPage == i}">
                        ${i}
                    </c:if>
                </c:forEach>
                <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                    <a href="StudentListPageServlet?currentPage=${pageBean.currentPage+1}">下一页</a>｜
                    <a href="StudentListPageServlet?currentPage=${pageBean.totalPage}">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function doDelete(id){
        var flag = confirm("删除"+id+"？");
        if (flag){//删除
            window.location.href="StudentDeleteServlet?id="+id;
        }
    }
</script>
</html>

