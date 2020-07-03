<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Struts2 註解範例</title>
</head>
<body>
<h1>登入看看</h1>
	<s:form action="Welcome">
		<s:textfield name="username" label="用戶名" />
		<s:password name="password" label="密碼"/>
		<s:submit value="submit"/>
	</s:form>
<!-- <h1>登入看看2</h1> -->
<!-- 	<form action="userAction!TestStruts.action" method="post"> -->
<!-- 		用戶名 : <input type="text" name="user.username" id="username"/><p> -->
<!-- 		年齡 : <input type="text" name="user.age" id="age" /><p> -->
<!-- 		<input type="submit" value="提交" /> -->
<!-- 	</form> -->

</body>
</html>