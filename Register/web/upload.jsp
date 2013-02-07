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
    <script src="js/upload_callback.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <table class="collapseBorder">
        <tr>
            <td id="selectA">Servlet上传</td>
            <td>Struts 上传</td>
        </tr>
    </table>
    <div class="uploadBox">
        <fieldset class="fieldSetStyle">
            <legend>上传文件</legend>
            <iframe name=transparentIFrame style="width:0; height:0; display: none;"></iframe>
            <form method="post" enctype="multipart/form-data" action="servlet/uploadMng" onsubmit="return uploadBegin();" target="transparentIFrame">
                <input type="file" name="upFile" class="fileSelectField" id="fileSelectField" onchange="checkFileSelectField();" autofocus="true"/>
                <input type="submit" value="立即上传" id="submitButton" style="width:10%;"/>
                <div style="width:100%; height:15px;">
                    <div style="width:70%; height:15px; display: none;" id="progressBarController">
                        <div class="progressBar">
                            <div class="progression" id="progression"></div>
                            <div class="progressionTit" id="progressionTit">
                                <div class="uploadProgressionTitLeft">已完成 <span id="finishPercent"></span>%&nbsp;&nbsp;&nbsp;&nbsp;已用/剩余 <span id="usedTime"></span>/<span id="needMoreTime"></span></div>
                                <div class="uploadProgressionTitRight">已上传 <span id="uploaded"></span>/<span id="fileSize"></span>&nbsp;&nbsp;&nbsp;&nbsp;平均速度 <span id="avgTransRate"></span></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearBoth"></div>
                <label for="fileDescription">请输入文件描述：</label><br />
                    <textarea id="fileDescription" rows="8" cols="80" name="fileDescription" class="inputTextField"></textarea>

            </form>
        </fieldset>

    </div>
</div>
</body>
</html>