<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<body>
<a href="hello">点击跳转链接</a>


<br>
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

</body>
</html>
