<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <h3>请求参数的绑定</h3>

        <%--基本类型的参数绑定--%>
        <%--<a href="param/testParam?username=haha&password=123">基本类型的参数绑定</a>--%>


        <%--其它bean类型的参数绑定，bean类型中包含其它bean类型的引入--%>
        <form action="param/saveAccount" method="post">
            账户：<input type="text" name="username"><br/>
            密码：<input type="text" name="password"><br/>
            存储金额：<input type="text" name="money"><br/>

            账户持有人：<input type="text" name="user.uname"><br/>
            年龄:<input type="text" name="user.age"><br/>

            提交：<input type="submit" value="提交">
        </form>



        <%--集合类型的参数绑定--%>
        <%--<form action="param/saveAccountList" method="post">
            账户：<input type="text" name="username"><br/>
            密码：<input type="text" name="password"><br/>
            存储金额：<input type="text" name="money"><br/>

            list<input type="text" name="list[0].uname"><br/>
            年龄:<input type="text" name="list[0].age"><br/>

            账户持有人：<input type="text" name="map['one'].uname"><br/>
            年龄:<input type="text" name="map['one'].age"><br/>
            提交：<input type="submit" value="提交">
        </form>--%>


        <%--自定义的类型转换器--%>
        <%--<form action="param/saveUserDate" method="post">
            用户名：<input type="text" name="uname"><br/>
            年龄：<input type="text" name="age"><br/>
            日期：<input type="text" name="date"><br/>
            提交：<input type="submit" value="提交">
        </form>--%>


        <%--获取Servlet原生API--%>
        <a href="param/testServlet">Servlet原生的API</a>

</body>
</html>
