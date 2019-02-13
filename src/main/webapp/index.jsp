<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
</body>
    <center>
        <form action="${pageContext.request.contextPath}/user/findByName">
            请输入学生名：<input type="text" name="name">
            <input type="submit" value="提交">
        </form>
        <form action="${pageContext.request.contextPath}/user/findById">
            请输入学生id：<input type="number" name="id">
            <input type="submit" value="提交">
        </form>
        <form action="${pageContext.request.contextPath}/classes/find">
            请输入班级名称：<input type="text" name="cname">
            <input type="submit" value="提交">
        </form>
    </center>
</html>
