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
			<a href="/View/user/myspace.jsp">主页</a>
		</li>
		<li class="active">
			已发布实验
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
									<a href="/exper/editExper?id=${exper.id}"><i class="ace-icon fa fa-pencil blue"></i></a>&nbsp;&nbsp;
									<a href="/exper/showExper?id=${exper.id}" class="pink btn-display-help"> ${exper.name} </a>
									&nbsp;&nbsp; <small><fmt:formatDate value="${exper.beginTime}" pattern="yyyy年MM月dd日"/></small>&nbsp;&nbsp;
                                    <c:set var="now" value="<%=System.currentTimeMillis()%>"/>
                                    <c:if test="${(now-exper.createTime.time)<1209600000}">
                                        <img src="/images/new.gif" alt="">
                                    </c:if>
                                    &nbsp;
                                    <i class="ace-icon fa fa-times red2 " onclick="isSure(${exper.id})"></i>
                                    &nbsp;&nbsp;
                                    <a href="/exper/attendList?experId=${exper.id}">
                                    <button class="btn btn-sm btn-info" type="button">
                                       报名情况
                                    </button>
                                    </a>
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
<script type="text/javascript">
	function isSure(id){
		if(confirm("你确定要删除吗？"))
		{
			$.ajax({
				url:"/exper/delete",
				type:"post",
				dataType:"text",
				data:{"id":id},
				success:function(data){
					var result = parseInt(data);
					if(result == 1){
						alert("delete success");
						window.location.href = "/exper/myPublishExperiment";
					}else{
						alert("未知错误");
					}
				}
			});
		}
		else
		{
			//否则说明下了，赫赫
			alert("你按了取消，那就是返回false");
		}
	}
</script>
</body>
</html>