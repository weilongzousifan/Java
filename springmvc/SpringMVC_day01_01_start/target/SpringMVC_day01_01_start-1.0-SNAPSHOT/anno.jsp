<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <%--<a href="anno/testRequestParam?name=灰太狼">RequestParam</a> <<br/>--%>


        <%--获取请求体的内容--%>
        <form action="anno/testRequestBody" method="post">
            用户姓名：<input type="text" name="username" /><br/>
            用户年龄：<input type="text" name="age" /><br/>
            <input type="submit" value="提交" />
        </form>


        <%--获取URL中的占位符  --%>
        <%--<a href="anno/testPathVariable/10">PathVarial</a>--%>

        <%--获取指定的请求头信息--%>
        <%--<a href="anno/testRequestHeader">RequestHeader</a>--%>

        <%--获取指定Cookie的值--%>
        <%--<a href="anno/testCookieValue">CookieValue</a>--%>

        <form action="anno/testModelAttribute" method="post">
            用户姓名：<input type="text" name="uname" /><br/>
            用户年龄：<input type="text" name="age" /><br/>
            <input type="submit" value="提交" />
        </form>
</body>
</html>
