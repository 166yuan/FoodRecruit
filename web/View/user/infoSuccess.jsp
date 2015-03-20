<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>experiment_release</title>
</head>
<body class="no-skin">
<!--导航栏开始-->
<c:import url="/View/common/header.jsp"/>
<!--导航栏结束-->
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
    <li class="active">意见反馈</li>
  </ul><!-- /.breadcrumb -->
</div>
<!-- 面包屑结束-->
<br>
<br>
<br>
<!-- 主体开始-->
<div class="col-xs-2">
</div>

<div class="col-xs-8">
<div class="widget-box">
  <div class="widget-header">
    <h5 class="widget-title">反馈成功了</h5>
  </div>

  <div class="widget-body">
    <div class="widget-main">
      <p class="alert alert-info">
       感谢您的支持，我们会尽量做的更好。
      </p>
    </div>
  </div>
  <div >
    <a  class="btn btn-primary" href="/user/home">返回</a>
  </div>
</div>
 </div>
</div>

<div class="col-xs-2">
  </div>
<!-- 主体结束-->

</body>
</html>
