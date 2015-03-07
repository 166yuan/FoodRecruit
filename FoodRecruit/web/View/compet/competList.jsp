<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>竞赛列表</title>
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
    <li class="active">
     竞赛列表
    </li>
  </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<div class="page-content">
  <div class="page-header">
    <h1>
      已发布竞赛
    </h1>
  </div>

</div>
<div class="row">
<div class="col-xs-12">
  <div class="col-sm-1"></div>
  <div class="col-sm-10">
    <div class="widget-box">
      <div class="widget-header widget-header-flat">
        <h4 class="widget-title">竞赛列表</h4>
      </div>

      <div class="widget-body">
        <div class="widget-main">
          <ul class="list-unstyled spaced">
            <c:forEach items="${list}" var="competition">
              <li>
                <h4 class="lighter no-margin-bottom">
                 <a href="/compet/getById?id=${competition.id}">${competition.name}</a>

                </h4>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>
<!-- main content end-->
</div>
</body>
</html>
