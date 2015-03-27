<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>竞赛管理</title>
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
            竞赛管理
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
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="widget-box">
                <div class="widget-header widget-header-flat">
                    <h4 class="widget-title">竞赛列表</h4>
                </div>

                <div class="widget-body">
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>竞赛名</th>
                            <th>
                                <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                                发布时间</th>
                            <th class="hidden-480">状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="compet">
                            <tr>
                                <td>
                                    <a href="/compet/getById?id=${compet.id}">${compet.name}</a>
                                </td>
                                <td><fmt:formatDate value="${compet.createTime}" pattern="yyyy年MM月dd日 HH:mm"/></td>
                                <td>
                                    <c:set var="nowDate" value='<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date())%>'></c:set>
                                    <c:set var="endDate" value="${compet.endTime}"/>
                                    <c:if test="${nowDate>endDate}">
                                        <span class="label label-warning">已结束</span>
                                    </c:if>
                                    <c:if test="${nowDate<=endDate}">
                                        <span class="label label-success">进行中</span>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="/compet/update?id=${compet.id}">
                                    <i class="ace-icon fa fa-pencil bigger-130"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>

            </div>
            <div class="dataTables_paginate paging_bootstrap">
                <c:import url="/View/common/page.jsp"></c:import>
            </div>
        </div>
        <div class="col-sm-2"></div>
        <br>
        <br>

    </div>
    <!-- main content end-->
</div>
</body>
</html>
