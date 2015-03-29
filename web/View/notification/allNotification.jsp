<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<head>
<meta charset="UTF-8">
<!-- 强制国内垃圾浏览器开启高速模式-->
<meta name="renderer" content="webkit">
<title>未读通知</title>

	<link rel="stylesheet" type="text/css" href="/css/notification.css" >
</head>
<html>
<body class="no-skin">
<c:import  url="/View/common/header.jsp"/>
<!-- 面包屑-->
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
	</script>

	<ul class="breadcrumb">
		<li>
			<i class="ace-icon fa fa-home home-icon"></i>
			<a href="/View/user/myspace.jsp">主页</a>
		</li>
		<li class="active">通知</li>
	</ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->

	<div class="ui grid page" id="index-nav">
	<h3 class="page_title notifications_page_title">
	通知
	</h3>

	<div class="ui divider"></div>

	<!--通知右侧-->
	<div class="four wide column" id="notifications_filter">
		<div class="ui vertical menu">
			<a href="/notification/myNotification">
				<li class="item"><span class="ui label">${unreadSize}</span>未读</li>
			</a>

			<li class="item">
				<span class="ui label">0</span>
				<a href="http://git.oschina.net/notifications/participating">我参与的</a>
			</li>
			<a href="#">
				<li class="active item">所有</li>
			</a>
		</div>

		<a href="#" class="ui tiny button">清除</a>
		<style>
		  .ui.vertical.menu .item:hover{background-color:#f7f7f7}
		</style>

	</div>

	<!--通知表-->
	<div class="twelve wide column">
		<style>
			.ui.avatar{height:1.5rem !important;width:1.5rem !important}
		</style>
		<table class="ui table notifications-table">
			<thead>
				<tr>
					<th>
					  <i>共有${list.size()}通知</i>
					</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="noti">
					<tr>
					<td>
						<div class="notification-item unread issue-notification">
						<div class="float-right">
							<div class="">
							<a href="http://git.oschina.net/Mklaus" >
							</a>2分钟前
							</div>
						</div>
						<strong>
						<a href="#" id="mark_notification" noti_id="2240646" target="_blank"><span class="glyphicon glyphicon-file" />${noti.info}</a></strong>
						</div>
					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>
<!-- 主体结束-->
</body>
</html>
</html>


