<%--
  Created by IntelliJ IDEA.
  User: chenqiangjun
  Date: 2020/5/28
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<button id="btn">发送ajax请求</button>
</body>
</html>
