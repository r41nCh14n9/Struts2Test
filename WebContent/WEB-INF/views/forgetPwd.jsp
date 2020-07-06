<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
</head>
<body>
	<s:form action="resetPwdProcess" theme="simple" namespace="/">
			<table style="text-align: center;" >
				<tr>
					<td><s:label for="sacc">Account Name:</s:label></td>
					<td><s:textfield name="studentIn.sacc" id="sacc"/></td>
				</tr>
				<tr>
					<td><s:label for="smail">Student Email:</s:label> </td>
					<td><s:textfield name="studentIn.smail" id="smail"/></td>
				</tr>
				<tr>
					<td><input type="button" value="返回登入" onclick="location.href='login'" ></td>
					<td><s:submit value="重設密碼" /></td>
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