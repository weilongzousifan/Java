<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                //    发送ajax请求
                $.ajax({
                    url: "user/testAjax",
                    data:'{"username":"灰太狼","password":"1234","age":30}',
                    dataType:"json",
                    type:"post",
                    //success：请求成功后的回调函数，一般写在最后
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析，表明拿到数据
                        //将返回的Json数据封装在JavaBean中，SpringMVC默认进行，不要额外的导入jar包，
                        //特别需要注意的：Json的属性必须和JavaBean的属性一致
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }

                });
            });
        });
    </script>
</head>

<body>



       <%--<a href="user/testString">testString</a>

        <a href="user/testVoid">testVoid</a>

        <a href="user/testModelAndView">testModelAndView</a>

        <a href="user/testForwardOrRedirect" >testForwardOrRedirect</a>--%>


        <button id="btn">发送ajax请求</button>
</body>
</html>
