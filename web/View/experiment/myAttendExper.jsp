<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我参与的实验助手</title>

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
            <a href="/View/user/myspace.jsp">主页</a>
        </li>
        <li class="active">
            我参与的实验助手
        </li>
    </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<!--main content-->
<div class="page-content">
    <div class="page-header">
        <h1>
            我参与的实验
        </h1>
    </div>

</div>
<div class="row">

        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="widget-box">
                <div class="widget-header widget-header-flat">
                    <h4 class="widget-title">实验列表</h4>
                </div>
                <br>
                <c:choose>
                    <c:when test="${list.size()==0}">
                        <div class="center" style="font-size: larger">还没参加？<a href="/exper/nendAssistant?page=1">去看看</a></div>
                    </c:when>
                    <c:otherwise>
                        <div class="widget-body">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>实验名</th>
                                    <th>
                                        <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                                        申请时间</th>
                                    <th class="hidden-480">状态</th>
                                    <th>评分状态</th>
                                    <th>查看分数</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="exper">
                                    <tr>
                                        <td>
                                            <a href="/exper/showExper?id=${exper.experiment.id}">${exper.experiment.name}</a>
                                        </td>
                                        <td><fmt:formatDate value="${exper.createTime}" pattern="yyyy年MM月dd日 HH:mm"/></td>

                                        <td class="hidden-480">
                                            <c:choose>
                                                <c:when test="${exper.isAgree==true}">
                                                    <span class="label label-sm label-success">已招收</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="label label-sm label-danger">未招收</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${exper.isAgree==true}">
                                                    <c:choose>
                                                        <c:when test="${exper.isEvaluate==true}">
                                                            <span class="label label-sm label-success">已评分</span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span class="label label-sm label-danger">未评分</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:when>
                                                <c:otherwise>
                                                    /
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${exper.isEvaluate==true}">
                                                    <a class="btn btn-xs btn-info" href="/score/myScore?experId=${exper.experiment.id}">查看分数</a>
                                                </c:when>
                                                <c:otherwise>
                                                    /
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="col-sm-2"></div>
    <!-- main content end-->
</div>
</body>
</html>