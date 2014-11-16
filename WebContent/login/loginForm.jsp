
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录页面</title>
</head>
<body>
	<form action="login" method="post">
	<table>
		<caption><h3>用户登录</h3></caption>
		<tr>
			<td>用户名：<input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;码：<input type="text" name="password"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="登录"/>
			<input type="reset" value="重填" /></td>
		</tr>
	</table>
	</form>
</body>
</html>