<%--
  Created by IntelliJ IDEA.
  User: CaihuA
  Date: 2019/2/7
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript">//引入jquery框架
</script>
<script type="text/javascript">
    $(function () {
        $(".updateUser").click(function () {
            var childs = $(this).parent().parent().children();
            var uid = childs[0].innerHTML;
            $.ajax({
                url: "${pageContext.request.contextPath}/user/update",
                type: "post",
                dataType: "JSON",
                data: {id: uid, name: "1", age: "1", gender: "1"},
                success: function (user) {
                    childs[1].innerHTML = user.name;
                    childs[2].innerHTML = user.age;
                    childs[3].innerHTML = user.gender;
                    childs[4].innerHTML = user.classes.cname;
                }
            })
        })
    })
</script>

<body>
<center>
    <table cellspacing="0" cellpadding="3px" border="3">
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>所在班级</td>
            <td>开除该学生</td>
            <td>修改学生信息</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td hidden>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.gender}</td>
                <td>${user.classes.cname}</td>
                <td><a href="${pageContext.request.contextPath}/user/del">开除</a></td>
                <td><a class="updateUser" href="#">修改信息</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
