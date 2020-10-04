<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h3>运行成功</h3>

        <%-- isELIgnored="false"   默认值为true，忽略EL表达式--%>


        <%--获取值--%>
        ${user.username}
        ${user.password}
        ${user.age}
</body>
</html>
