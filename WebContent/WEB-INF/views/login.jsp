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
		<s:form action="loginProcess" theme="simple" namespace="/">
			<table style="text-align: center;" >
				<tr>
					<td><s:label for="sacc">Account Name:</s:label></td>
					<td><s:textfield name="studentIn.sacc" id="sacc"/></td>
				</tr>
				<tr>
					<td><s:label for="spwd">Student Password:</s:label> </td>
					<td><s:password name="studentIn.spwd" id="spwd"/></td>
				</tr>
				<tr>
					<td><a href="forgetPwd">忘記密碼</a></td>
					<td><s:submit value="submit" /></td>
				</tr>
				<tr>
					<td colspan="2"><a href="home">Home</a> </td>
				</tr>
			</table>
			<table>
				<tr>
					<td>${message}</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>