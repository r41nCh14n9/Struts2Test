<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registration Page</title>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</head>
<body>
	<s:form action="registerProcess" id="registerForm" theme="simple" namespace="/">
		<table style="text-align: center;">
			<tr>
				<td><s:label for="sacc">Account Name</s:label></td>
				<td><s:textfield name="studentIn.sacc" id="sacc" onblur="checkAcc()" /></td>
			</tr>
			<tr>
				<td><s:label for="spwd">Student Password</s:label></td>
				<td><s:password name="studentIn.spwd" id="spwd" /></td>
			</tr>
			<tr>
				<td><s:label for="sname">Student Name</s:label></td>
				<td><s:textfield name="studentIn.sname" id="sname" /></td>
			</tr>
			<tr>
				<td><s:label for="sbday">Student Birthday</s:label></td>
 				<td>
 					<s:textfield name="studentInBD" type="date" /> 
 				</td>
					
			</tr>
			<tr>
				<td><s:label for="ssex">Student Sex</s:label></td>
				<td>
					<s:radio name="studentIn.ssex" list="#{1:'男',0:'女'}" id="ssex"/> 
<%-- 					<s:radioname="studentIn.ssex" id="ssex" value="0" />女 --%>
				</td>
			</tr>
			<tr>
				<td><s:label for="smail">Student Email</s:label></td>
				<td><s:textfield name="studentIn.smail" id="smail" onchange="emailCheck()"/></td>
			</tr>
			<tr>
				<td><a href="home">Home</a></td>
				<td><s:submit id="submit" value="Sign up" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td id="msg">${message}</td>
			</tr>
		</table>
	</s:form>
	<script>
		function checkAcc() {
			var sacc = $("#sacc").val();
			console.log(sacc);
			//用ajax去資料庫匹配
			$.post({
				url:'accCheck',
				data:"sacc="+sacc,
				datatype:'json',
				success:function(data){
					console.log(data.message);
					console.log(data.message.length);
					if (data.message.length>0) {
					$("#msg").html("<font color='red'>用户名已存在</font>");
					} else {
					$("#msg").html("");
				}

				}
			})
		}

		function emailCheck() {
			var emailStr = $("#smail").val();
			//console.log(emailStr);
			//alert(emailStr);
			var reShort = /^[a-zA-Z]{1}[\w-]+@[a-z0-9]+\.[a-z]+$/;
			var reLong = /^[a-zA-Z]{1}[\w-]+@[a-z0-9]+\.[a-z]+\.[a-z]+$/;
			var matchArray = reShort.test(emailStr) || reLong.test(emailStr);
			//alert(matchArray);
			if (!matchArray) {
// 				alert("電子郵件地址必須包括 ( @ 和 . )")
				$("#msg").html("<font color='red'>電子郵件地址必須包括 ( @ 和 . )</font>");
				$("#registerForm").submit(false);
				return false;
			}else{
				$("#registerForm").submit(true);
			}
			return true;
		}
	</script>
</body>
</html>