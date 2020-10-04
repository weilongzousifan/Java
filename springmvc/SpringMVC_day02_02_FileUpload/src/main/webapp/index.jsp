<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <%--文件上传--%>
        <form action="/user/testFileUpload" method="post" enctype="multipart/form-data">
                选择文件：<input type="file" name="upload"><br/>
                <input type="submit" value="上传按钮">
        </form>


        <%--跨服务器上传文件--%>
       <%-- <form action="/user/testFileUpload2" method="post" enctype="multipart/form-data">
                选择文件：<input type="file" name="upload"><br/>
                <input type="submit" value="上传按钮">
        </form>--%>
</body>
</html>
