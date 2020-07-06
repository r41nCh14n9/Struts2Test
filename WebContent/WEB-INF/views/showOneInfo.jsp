<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Student</title>
</head>
<body>

<table style="text-align: center; width: 50%;" border="1">
		<tr>
			<th>學號</th>
			<td><s:property value="studentOut.sid"/></td>
		</tr>
		<tr>
			<th>姓名</th>
			<td><s:property value="studentOut.sname"/></td>
		</tr>
		<tr>
			<th>生日</th>
			<td><s:property value="studentOut.sbday"/></td>
		</tr>
		<tr>
			<th>性別</th>
			<td> <s:if test="studentOut.ssex == 1">男</s:if> <s:else>女</s:else> </td>
		</tr>
		<tr>
			<th>帳號</th>
			<td><s:property value="studentOut.sacc"/></td>
		</tr>
		<tr>
			<th>email</th>
			<td><s:property value="studentOut.smail"/></td>
		</tr>
		<tr>
			<th>密碼</th>
			<td><s:property value="studentOut.spwd"/></td>
		</tr>
	</table><p>
	<button onclick="javascript:document.location.href='home'">回到 首頁</button>
</body>
</html>