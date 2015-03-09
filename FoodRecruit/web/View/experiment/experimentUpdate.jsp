<%--
  Created by IntelliJ IDEA.
  User: Mklaus
  Date: 15/2/3
  Time: 上午12:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>experiment_release</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-datetimepicker.css" >
  <script type="text/javascript" src="/js/experiment/experimentUpdate.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/js/moment.min.js"></script>
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
    <li class="active">实验发布</li>
  </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->

<div id="message"></div>
<div class="page-content">

  <!-- /.page-header -->
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <div class="page-header ">
        <h1 class="text-center">
          实验发布
        </h1>
      </div>
    </div>
  </div>
  <!-- /.page-header -->

  <!--表单开始-->
  <div>
    <form   class="form-horizontal">

      <div class="form-group">
        <label  class="col-sm-4 control-label">实验名称</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" name="name" id="name" value="${exper.name}">
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">实验内容</label>
        <div class="col-sm-5">
          <textarea class="form-control" name="content" rows="5" id="content" >${exper.information}</textarea>
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">实验要求</label>
        <div class="col-sm-5">
          <textarea class="form-control" rows="5" id="requirement" placeholder="requirement">${exper.requirement}</textarea>
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">实验性质</label>
        <div class="col-sm-2">
          <select class="form-control" name="type" id="type">
            <option value="院级创新项目">院级创新项目</option>
            <option value="校级创新项目">校级创新项目</option>
            <option value="省级创新项目">省级创新项目</option>
            <option value="国家级创新项目">国家级创新项目</option>
            <option value="普通项目">普通项目</option>
          </select>
        </div>
      </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">时间</label>
            <div class="col-sm-4">
                <input id="date-timepicker1" name="pretime" value="<fmt:formatDate  value="${exper.beginTime}" pattern="dd/MM/yyyy k:m a"/>" type="text" class="form-control">
                到
                <br>
                <input id="date-timepicker2" name="endtime" value="<fmt:formatDate value="${exper.endTime}" pattern="dd/MM/yyyy k:m a"/>" type="text" class="form-control">
            </div>
        </div>


      <div class="form-group">
        <label  class="col-sm-4 control-label">联系人</label>
        <div class="col-sm-2">
          <input type="text" class="form-control" value="${exper.contact}" name="linkname" id="linkman"  >
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">电话（长短号）</label>
        <div class="col-sm-2">
          <input type="text" class="form-control" name="phone" id="phoneNumber" value="${exper.phone}" >
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">QQ</label>
        <div class="col-sm-2">
          <input type="text" class="form-control" name="qq" id="QQ" value="${exper.QQ}" >
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">Email</label>
        <div class="col-sm-2">
          <input type="email" class="form-control" name="qq" id="Email" value="${exper.email}">
        </div>
      </div>

      <div class="form-group">
        <label  class="col-sm-4 control-label">需要助手人数</label>
        <div class="col-sm-2">
          <input type="text" class="form-control" name="count" id="count" value="${exper.count}" >
        </div>
      </div>
      <div class="form-group">
        <label  class="col-sm-4 control-label">备注</label>
        <div class="col-sm-5">
          <textarea class="form-control" rows="5" name="note" id="remark" >${exper.note}</textarea>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-5">
          <input class="form-control" type="hidden" id="experId" value="${id}" />
        </div>
      </div>

      <div class="form-group  ">
        <div class="col-sm-offset-6 col-sm-6">
          <input type="button" class="btn btn-default" value="确认发布" onclick="update();">
        </div>
      </div>
    </form>

  </div>
  <!--表单结束 -->
</div>
<script type="text/javascript">
    $(document).ready(
            function(){
                $('#date-timepicker1').datetimepicker().next().on(ace.click_event, function(){
                    $(this).prev().focus();
                });
                $('#date-timepicker2').datetimepicker().next().on(ace.click_event, function(){
                    $(this).prev().focus();
                });
            });
</script>
</body>
</html>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.min.js"></script>
