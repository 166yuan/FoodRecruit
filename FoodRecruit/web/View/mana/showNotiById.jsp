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

<div class="col-sm-12">
  <h3 class="header smaller lighter blue">反馈查看</h3>
<div class="col-sm-3">
  </div>
<div class="col-sm-6" id="noti">
  <div class="widget-box">
    <div class="widget-header">
      <h4 class="smaller">
        来自用户<span style="font-weight: 100">${name}</span> 的反馈
      </h4>
    </div>

    <div class="widget-body">
      <div class="widget-main">
        <p class="muted">
        ${notification.info}
        </p>

        <hr>

        <!-- #section:elements.tooltip -->
        <p>
          <span class="btn btn-info btn-sm tooltip-info " data-rel="tooltip" data-placement="bottom" id="toreply" data-original-title="Bottm Info">回复</span>
        </p>

        <!-- /section:elements.tooltip -->
      </div>
    </div>
  </div>
</div>
  <div class="col-sm-6" id="reply" >
  <div>
    <form>
    <label for="form-field-11">请在下面写上您的回复内容</label>

    <textarea id="form-field-11" class="autosize-transition form-control" style="overflow: hidden; word-wrap: break-word; resize: horizontal; height: 352px;"></textarea>
      <button class="btn btn-info" type="button">
        <i class="ace-icon fa fa-check bigger-110"></i>
        发送
      </button>
    </form>
  </div>
</div>

<div class="col-sm-3">
</div>



</div>
<br>
<br>
<br>
<!-- 下面这个div不是多余的，是include页面中header.jsp的另一半-->
</div>
<!-- 主体结束-->
</body>
</html>
</html>
<script type="text/javascript">
$(document).ready(
        function(){
          $('#reply').hide();
        }
);
$('#toreply').click(function(){
$('#noti').hide();
  $('#reply').show();
});
</script>

