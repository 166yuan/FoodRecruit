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
      <a href="/user/home">主页</a>
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
            <c:choose>
              <c:when test="${list.size()==0}">
                  暂无竞赛发布，敬请期待！
              </c:when>
              <c:otherwise>
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>名称</th>
                    <th>
                      <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                      竞赛时间</th>
                    <th class="hidden-480">状态</th>
                    <th>报名链接</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${list}" var="compet">
                    <tr>
                     <td class="col-sm-3">
                      <a href="/compet/getById?id=${compet.id}"> ${compet.name}</a>
                     </td>
                      <td class="col-sm-5">
                       <fmt:formatDate pattern="yyyy年MM月dd日" value="${compet.beginTime}"/>  - <fmt:formatDate pattern="yyyy年MM月dd日" value="${compet.endTime}"/>
                      </td>
                      <td class="col-sm-2">
                        <c:set var="nowDate" value='<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date())%>'></c:set>
                        <c:set var="endDate" value="${compet.endTime}"/>
                        <c:if test="${nowDate>endDate}">
                          <span class="label label-warning">已结束</span>
                        </c:if>
                        <c:if test="${nowDate<=endDate}">
                          <span class="label label-success">进行中</span>
                        </c:if>
                      </td>
                      <td class="col-sm-2">
                        <a class="btn btn-info btn-xs" href="/compet/attend?id=${compet.id}">报名链接</a>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </c:otherwise>
            </c:choose>
      </div>
    </div>
    <div class="dataTables_paginate paging_bootstrap">
      <c:import url="/View/common/page.jsp"></c:import>
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>
<!-- main content end-->
</div>
</body>
</html>
