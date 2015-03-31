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

  <!-- 通知左侧 -->
  <div class="four wide column" id="notifications_filter">
    <div class="ui vertical menu">
      <a href="#">
        <li class="active item"><span id="unReadSize1" class="ui label">${list.size()}</span>未读</li>
      </a>
      <li class="item">
        <span class="ui label">0</span>
        <a href="http://git.oschina.net/notifications/participating">我参与的</a>
      </li>
      <a href="/notification/allNotification">
        <li class="item">所有</li>
      </a>
    </div>

    <a href="#" class="ui tiny button">清除</a>
    <style>
      .ui.vertical.menu .item:hover{background-color:#f7f7f7}
    </style>

  </div>

  <!-- 通知列表 -->
  <div class="twelve wide column">
    <table class="ui table notifications-table">
      <thead>
      <tr>
        <th>
          <i>共有<span id="unReadSize2">${list.size()}</span>未读通知</i>
        </th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${list}" var="noti">
        <tr>
          <td>
            <div class="notification-item unread issue-notification">
              <div class="float-right">
                <a href="#" onclick="setReaded(this,${noti.id})" ><span class="glyphicon glyphicon-remove"  title="标记为已读"/>
                </a>&nbsp;2分钟前
              </div>
              <strong>
                <a href="#" id="mark_notification" noti_id="2240646" target="_blank"><span class="glyphicon glyphicon-file" />${noti.info}</a>
              </strong>
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

<script type="text/javascript" >

  function setReaded(obj,notiId){

    $.ajax({
      url: "/notification/readed",
      type: "post",
      dataType: "text",
      data: {"notiId": notiId},
      success: function (data) {
        var result = parseInt(data);

        $("#unReadSize1").html(result);
        $("#unReadSize2").html(result);

        var tr =obj.parentNode.parentNode.parentNode;
        tr.parentNode.removeChild(tr);


      }
    });
  }

</script>

</html>
</html>


