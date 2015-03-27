<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>已发布实验</title>

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
			成为实验助手
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
							<c:forEach items="${list}" var="exper" varStatus="num">
							<li>
								<h4 class="lighter no-margin-bottom">
                                    <span >${num.count}.</span><a href="/exper/showExper?id=${exper.id}" class="pink btn-display-help"> ${exper.name} </a>
									&nbsp;&nbsp; <small><fmt:formatDate value="${exper.beginTime}" pattern="yyyy年MM月dd日"/></small>&nbsp;&nbsp;
                                    <c:set var="now" value="<%=System.currentTimeMillis()%>"/>
                                    <c:if test="${(now-exper.createTime.time)<1209600000}">
                                        <img src="/images/new.gif" alt="">
                                    </c:if>
                                </h4>
							</li>
							</c:forEach>
						</ul>
                        <div class="dataTables_paginate paging_bootstrap">
                            <c:import url="/View/common/page.jsp"/>
                        </div>
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