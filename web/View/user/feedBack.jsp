<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/2/8
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
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

<!-- 主体开始-->
<div id="page" class="hfeed">
  <div id="main">
    <div class="col-md-offset-2 col-md-8">
      <div   >
        <br>
        <div class="page-header">
          <h1>写下你宝贵的意见</h1>
        </div>

        <form action="/user/addfeedback" id="feedback" class="form-horizontal" method="post" >
          <div class="form-group">
            <div class="col-md-12">
              <textarea class="form-control" rows="8" name="info" placeholder="请写下您的宝贵意见"></textarea>
            </div>
            <br>
          </div>

          <br>

          <div class="form-group">
            <div class="col-md-offset-6 col-md-6">
              <button type="submit" class="btn btn-primary">提交反馈</button>
            </div>
          </div>
        </form>


      </div><!-- #main -->
    </div><!-- #page -->
  </div><!-- #main -->
</div><!-- #page -->
<!-- 主体结束-->

</body>
</html>
