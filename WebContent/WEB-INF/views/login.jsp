<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Page</title>
	</head>
	<body>	
	
	<s:form action="Welcome" namespace="/">
		<s:textfield name="bean.student.sacc" label="帳號 " />
		<s:password name="bean.student.spwd" label="密碼 "/>
		<s:submit value="submit"/>
	</s:form>


<!-- 	<table style="text-align: center;"> -->
<!-- 		<tr> -->
<!-- 			<td><a href="forgetPwd">忘記密碼</a><br></td> -->
<!-- 			<td><form:button type="submit">Sign in</form:button></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td colspan="2"><a href="/HibernatemvcTest/home">Home</a></td> -->
<!-- 		</tr> -->
<!-- 	</table> -->



</body>
</html>