<%--
  Created by IntelliJ IDEA.
  User: rankun203
  Date: 13-1-7
  Time: 下午10:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() +":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
  <head>
      <base href="<%=basePath%>"/>
    <title>Register</title>
    <link rel="stylesheet" href="../../css/style.css" />
  </head>
  <body>
	<div class="container">
    	<div class="titleBlock">
        	<h1>注册中心</h1>
        </div>
        <div class="registerBox">
        	<div class="rtitle">
            	欢迎注册
            </div>
            <div class="formBox">
                <form method="post" action="actions/UserRegister.action">
                    <input type="hidden" name="mast" value="嘿嘿" />
                    <table>
                        <tr>
                            <td colspan="2"><span class="promptColor"><s:property value="promptStr"/>&nbsp;</span></td>
                        </tr>
                        <tr>
                            <td><label for="userName">用户名：</label></td>
                            <td><input type="text" name="user.userName" id="userName" class="inputField" /></td>
                        </tr>
                        <tr>
                            <td><label for="passWord">密码：</label></td>
                            <td><input type="password" name="user.passWord" id="passWord" class="inputField"/></td>
                        </tr>
                        <tr>
                            <td><label for="rePass">重复密码：</label></td>
                            <td><input type="password" name="user.rePass" id="rePass" class="inputField"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center;"><input type="submit" value="提交"/></td>
                        </tr>
                    </table>
                </form>
                发送邮件：<a href="mailto:rankun203@gmail.com">rankun203@gmail.com</a>
            </div>
        </div>
        <s:debug/>
    </div>
  </body>
</html>