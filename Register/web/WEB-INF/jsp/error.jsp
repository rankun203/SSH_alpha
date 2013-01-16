<%--
  Created by IntelliJ IDEA.
  User: rankun203
  Date: 13-1-9
  Time: 下午7:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() +":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
<h1 class="error">ERROR</h1>
<s:debug/>
</body>
</html>