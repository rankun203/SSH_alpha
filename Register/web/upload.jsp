<%--
  Created by IntelliJ IDEA.
  User: rankun203
  Date: 13-1-28
  Time: 下午4:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() +":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="css/style.css">
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="container">
    <table class="collapseBorder">
        <tr>
            <td>Servlet上传</td>
            <td>Struts 上传</td>
        </tr>
    </table>
    <div class="uploadBox">
        <fieldset class="fieldSetStyle">
            <legend>上传文件</legend>
            <form method="post" enctype="multipart/form-data" action="servlet/uploadMng">
                <input type="file" name="upFile" class="fileSelectField" autofocus="true"/><br /><br />
                <label for="fileDescription">请输入文件描述：</label><br />
                    <textarea id="fileDescription" rows="8" cols="80" name="fileDescription" class="inputTextField"></textarea>
                <input type="submit" value="立即上传"/>
            </form>
        </fieldset>

        <fieldset>
            <legend>图片预览</legend>
            <img width="778" height="437" src="img/img.jpg" style="border-radius:10px;"/>
        </fieldset>


    </div>
</div>
</body>
</html>