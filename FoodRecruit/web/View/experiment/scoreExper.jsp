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
            <a href="/View/user/myspace.jsp">主页</a>
        </li>
        <li class="active">
            实验评价
        </li>
    </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<!--main content-->
<div class="page-content">
    <div class="page-header">
        <h1>
            已发布实验
        </h1>
    </div>

</div>
<div class="row">
    <div class="col-xs-12">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="widget-box">
                <div class="widget-header widget-header-flat">
                    <h4 class="widget-title">实验列表</h4>
                </div>


                <div class="widget-body">
                    <div class="widget-main">
                        <ul class="list-unstyled spaced">
                            <c:forEach items="${list}" var="exper">
                                <li>
                                    <h4 class="lighter no-margin-bottom">
                                        <a href="/exper/showExper?id=${exper.experId}" class="pink btn-display-help"> ${exper.name} </a>
                                        &nbsp;&nbsp; <small><fmt:formatDate value="${exper.beginTime}" pattern="yyyy年MM月dd日"/></small>&nbsp;&nbsp;
                                        <c:choose>
                                            <c:when test="${exper.status==0}">
                                                <label class="label label-danger">待评价</label>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<a href="/exper/scoreList?experId=${exper.experId}"><button class="btn btn-sm btn-primary">去评分</button></a>
                                            </c:when>
                                            <c:when test="${exper.status==1}">
                                                <label class="label label-success">评价完了</label>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-sm btn-success">查看结果</button>
                                            </c:when>
                                            <c:when test="${exper.status==-1}">
                                                <label class="label label-info">评价中</label>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-sm btn-info">继续评分</button>
                                            </c:when>
                                        </c:choose>
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
