<%--
  Created by IntelliJ IDEA.
  User: chenqiangjun
  Date: 2020/5/28
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="param/testParam?username=user&password=123456">请求参数绑定</a>


<body>

<h2>单个对象类型参数</h2>
<form action="param/saveParam" method="post">
    账户<input type="text" name="username"/><br/>
    密码<input type="text" name="password"/><br/>
    <%--    实体类中有引用实体类的传参--%>
    姓名<input type="text" name="user.uname"/></br>
    年龄<input type="text" name="user.age"/></br>
    <input type="submit" value="提交">
</form>

<h2>map list类型参数</h2>
<form action="param/saveParam" method="post">
    账户<input type="text" name="username"/><br/>
    密码<input type="text" name="password"/><br/>
    <%--    实体类中有集合传参--%>
    姓名<input type="text" name="list[0].uname"/></br>
    年龄<input type="text" name="list[0].age"/></br>
    姓名<input type="text" name="map['one'].uname"/></br>
    年龄<input type="text" name="map['one'].age"/></br>
    <input type="submit" value="提交">
</form>


<h2>时间类型转化测试</h2>
<form action="param/saveUser" method="post">
    账户 <input type="text" name="uname"/><br/>
    年龄 <input type="text" name="age"/><br/>
    生日 <input type="text" name="date"><br/>
    <input type="submit" value="提交">
</form>


<h2>@RequestParam()测试</h2>
<a href="anno/testRequestParam?name=haha">testRequestParam</a>


<h2>@RequestBody()测试</h2>
<form action="anno/testRequestBody" method="post">
    用户：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="提交">
</form>


<h2>@PathVariable()测试</h2>
<a href="anno/testPathVariable/10">testPathVariable</a>

<h2>@RequestHeader()测试</h2>
<a href="anno/testRequestHeader">testRequestHeader</a>


<h2>@CookieValue()测试</h2>
<a href="anno/testCookieValue">testCookieValue</a>


<h2>@ModelAttribute()测试</h2>
<form action="anno/testModelAttribute" method="post">
    用户：<input type="text" name="uname"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="提交">
</form>

<h2>@SessionAttributes()测试</h2>
<a href="anno/testSessionAttributes">testSessionAttributes</a>
<a href="anno/getSessionAttributes">getSessionAttributes</a>
<a href="anno/delSessionAttributes">delSessionAttributes</a>


</body>

</body>
</html>