<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<div class="ui grid page" id="index-nav">
	<h3 class="page_title notifications_page_title">
	通知
	</h3>

	<div class="ui divider"></div>

	<div class="four wide column" id="notifications_filter">
		<div class="ui vertical menu">
			<a href="#">
				<li class="active item"><span class="ui label">${list.size()}</span>未读</li>
			</a>
			<li class="item">
				<span class="ui label">0</span>
				<a href="http://git.oschina.net/notifications/participating">我参与的</a>
			</li>
			<a href="/notification/allNotification">
				<li class="item">所有</li>
			</a>
		</div>

		<a href="./通知 - 代码托管 - 开源中国社区_files/通知 - 代码托管 - 开源中国社区.html" class="ui tiny button">清除</a>
		<style>
		  .ui.vertical.menu .item:hover{background-color:#f7f7f7}
		</style>

	</div>
	<div class="twelve wide column">
		<table class="ui table notifications-table">
			<thead>
				<tr>
					<th>
					  <i>共有${list.size()}未读通知</i>
					</th>
				</tr>
			</thead>

			<tbody>
				<tr>
				<td>
					<div class="notification-item unread issue-notification">
					<div class="float-right">
						<div class="">
						<a href="http://git.oschina.net/Mklaus" ><img alt="F15185c7aad3f7a73d8689b16cfb0e64?s=16&amp;d=mm" class="ui avatar image" src="./f15185c7aad3f7a73d8689b16cfb0e64" title="标记为已读"">
						</a>2分钟前
						</div>
					</div>
					<strong>
					<a href="http://git.oschina.net/Mklaus/learnGit/issues/1" id="mark_notification" noti_id="2240646" target="_blank"><i class="icon file"></i>
					fdsa
					</a></strong>
					</div>
				<style>
				  .ui.avatar{height:1.5rem !important;width:1.5rem !important}
				</style>
				<script>
				  $(document).ready(function() {
				    $("#mark_notification").click(function(){
				      var id = $(this).attr("noti_id");
				      mark_recomm(id);
				    });
				  });
				  function mark_recomm(id) {
				    $.ajax({
				      url:"/notifications/mark",
				      data: {"ids":id},
				      type: "POST"
				    });
				  }
				</script>

				</td>
				</tr>
			</tbody>
		</table>
	</div>

</div>
<!-- 主体结束-->
</body>
</html>
</html>


