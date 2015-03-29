<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>实验员评分</title>

  <link rel="stylesheet" type="text/css" href="/css/all.css" >

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
      <a href="/user/home">主页</a>
    </li>
    <li class="active">
      我的分数
    </li>
  </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<!--main content-->
<div class="page-content">
  <div class="page-header">
    <h1>
      我的实验分数
    </h1>
  </div>

</div>
<div class="row">
  <div class="col-xs-12">
    <div class="center">
      <h3 class="blue">实验名：${score.experiment.name} </h3>
    </div>
    <div class="center">
        <h3 class="blue"> 总分：${score.total}</h3>
    </div>
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
      <div class="timeline-container">

        <div class="timeline-items">
          <div class="timeline-item clearfix">
            <div class="timeline-info">
              <i class="timeline-indicator ace-icon fa fa-star btn btn-info no-hover green"></i>
            </div>

            <div class="widget-box transparent">
              <div class="widget-header widget-header-small">
                <h5 class="widget-title smaller">A项得分</h5>
              </div>

              <div class="widget-body">
                <div class="widget-main">
                 得分：${score.scoreA}
                </div>
              </div>
            </div>
          </div>
          <div class="timeline-item clearfix">
            <div class="timeline-info">
              <i class="timeline-indicator ace-icon fa fa-star btn btn-warning no-hover green"></i>
            </div>

            <div class="widget-box transparent">
              <div class="widget-header widget-header-small">
                <h5 class="widget-title smaller">B项得分</h5>
              </div>

              <div class="widget-body">
                <div class="widget-main">
                  得分：${score.scoreB}
                </div>
              </div>
            </div>
          </div>
          <div class="timeline-item clearfix">
            <div class="timeline-info">
              <i class="timeline-indicator ace-icon fa fa-star btn btn-success no-hover green"></i>
            </div>

            <div class="widget-box transparent">
              <div class="widget-header widget-header-small">
                <h5 class="widget-title smaller">追加评分</h5>
              </div>

              <div class="widget-body">
                <div class="widget-main">
                 得分：${score.secscore}
                  <br>
                  附加分：${score.append}
                </div>
              </div>
            </div>
          </div>
        </div><!-- /.timeline-items -->
      </div>

  </div>
  <!-- main content end-->
    <div class="col-sm-2"></div>
</div>
  </div>
</body>
</html>
