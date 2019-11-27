<%@ page import="vo.Person" %><%--
  Created by IntelliJ IDEA.
  User: yiyang
  Date: 2019/11/27
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>登陆界面</title>
</head>
<body>
<div align="center">
  <%
    Person p = new Person();
  %>
  <H1>登陆</H1>
  <form action="/" method="get" >
    姓名：<input name="username" ><br>
    密码：<input name="password" type="password"><br>
    <input type="submit" value="提交"><br>
  </form>

</div>
</body>
</html>
