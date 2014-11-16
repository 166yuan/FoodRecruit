<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>简单注册</title>
</head>
<body>
<form action="register" method="post">
	<table>
		<caption><h3>用户注册</h3></caption>
		<tr>
			<td>用户名：<input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;码：<input type="text" name="password"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="注册"/>
			<input type="reset" value="重填" /></td>
		</tr>
	</table>
	</form>
</body>
</html>