<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<html>

<head>
    <title>Title</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"陈强军"，"password":"1213dasd","age":"30"}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        //data服务器端响应的json数据，进行解析
                        console.log(data);
                        console.log(data.username);
                        console.log(data.password);
                        console.log(data.age);
                    }
                })
            })
        })
    </script>
</head>

<body>
<a href="hello">点击跳转链接</a><br>

<a href="param/getServlet">获取servlet原生API</a><br>

<h2>传统文件上传</h2>
<form action="file/fileupload1" method="post" enctype="multipart/form-data">
    浏览文件<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>

<h2>springmvc文件上传</h2>
<form action="file/fileupload2" method="post" enctype="multipart/form-data">
    浏览文件<input type="file" name="upload"/><br/>
    <input type="submit" value="Springmvc文件"/>
</form>

<button id="btn">发送ajax请求</button><br>

<a href="user/testString">响应数据和结果视图testString</a><br>

<a href="user/testVoid">响应数据和结果视图testVoid</a><br>

<a href="user/testModelAndView">响应数据和结果视图testModelAndView</a><br>

<a href="user/testForwardOrRedirect">响应数据和结果视图testForwardOrRedirect</a><br>

<a href="user/testException">自定义异常处理器</a><br>

</body>
</html>
