<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta charset="UTF-8">
  <!-- 强制国内垃圾浏览器开启高速模式-->
  <meta name="renderer" content="webkit">
  <title>个人中心</title>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >

  <link rel="stylesheet" type="text/css" href="/css/ace.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/manager.css" >

  <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/ace.min.js"></script>
</head>
<html>
<body class="no-skin">
<c:import url="header.jsp"/>
<div class="col-xs-12 col-sm-12 " >
<h3 class="header smaller lighter blue">用户反馈</h3>
  <div data-toggle="buttons" class="btn-group">


    <label class="btn btn-primary" id="unread">
     仅看未读
      <input type="radio" value="1">
      <i class="icon-only ace-icon fa fa-align-left"></i>
    </label>



    <label class="btn btn-primary" id="read">
      仅看已读
      <input type="radio" value="2">
      <i class="icon-only ace-icon fa fa-align-center"></i>
    </label>


    <label class="btn btn-primary" id="all">
     查看所有
      <input type="radio" value="3">
      <i class="icon-only ace-icon fa fa-align-right"></i>
    </label>


  </div>
<div class="widget-box widget-color-red2" style="opacity: 1; z-index: 0;">
  <!-- #section:custom/widget-box.options -->
  <div class="widget-header">
    <h5 class="widget-title bigger lighter">
      <i class="ace-icon fa fa-table"></i>
      反馈一览
    </h5>

  </div>
<input type="hidden" id="pagetype" value="${type}"/>
  <div class="widget-body">
    <div class="widget-main no-padding">
      <table class="table table-striped table-bordered table-hover">
        <thead class="thin-border-bottom">
        <tr>
          <th>
            <i class="ace-icon fa fa-user"></i>
            来自用户
          </th>

          <th>
            <i class="ace-icon fa fa-calendar"></i>
            时间
          </th>


          <th class="hidden-480">
            <i class="ace-icon fa fa-leaf"></i>状态</th>
          <th>
          </th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="noti">
        <tr>
          <td class="">${noti.name}</td>

          <td>
            ${noti.createTime}
          </td>

          <td class="hidden-480">
            <c:choose>
              <c:when test="${noti.isNew==true}">
                <span class="label label-warning">未读</span>
              </c:when>
              <c:otherwise>
                <span class="label label-success">已读</span>
              </c:otherwise>
            </c:choose>
          </td>

          <td>
            <a href="/mana/showNotiById?id=${noti.notiId}&name=${noti.name}">
            <span class="btn btn-info btn-sm popover-info" data-rel="popover" data-placement="bottom" title="" data-content="Heads up! This alert needs your attention, but it's not super important." data-original-title="Some Info">查看</span>
            </a>
          </td>
        </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>
<!-- 下面这个div不是多余的，是include页面中header.jsp的另一半-->
</div>
<!-- 主体结束-->
</body>
</html>
</html>
<script type="text/javascript">
$('#unread').click(function(){window.location.href="/mana/showfeedback?type=1";});
$('#read').click(function(){window.location.href="/mana/showfeedback?type=2";});
$('#all').click(function(){window.location.href="/mana/showfeedback?type=3";});

$(document).ready(
        function(){
            $('#feedpage').addClass("active");
            var type=document.getElementById('pagetype').value;
            if(type==1){
                $('#unread').addClass("active");
            }else if(type==2){
                $('#read').addClass("active");
            }else{
                $('#all').addClass("active");
            }
        }
);

  </script>

