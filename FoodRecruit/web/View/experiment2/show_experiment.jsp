<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已发布实验</title>

<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/css/ace.min.css">
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" >

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/ace.min.js"></script>
<script type="text/javascript" src="/js/experiment/show_experiment.js"></script>


<link rel="stylesheet" type="text/css" media="all" href="/css/style.css">
<link rel="stylesheet" id="jetpack-widgets-css" href="/css/widgets.css" type="text/css" media="all">
<link rel="stylesheet" id="white-css" href="/css/white.css" type="text/css" media="all">
<link rel="stylesheet" id="wp-markdown-prettify-css" href="/css/prettify.css" type="text/css" media="all">

</head>
<body class="no-skin">

<!--导航栏开始-->
<c:import url="/View/common/main.jsp"/>
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
			<li>
				<a href="/View/experiment/myInvolveExperiment.jsp">我参与的实验</a>
			</li>
			<li class="active" id="smallTitle">实验</li>
		</ul><!-- /.breadcrumb -->

	</div>
<!-- 面包屑结束-->

<div class="col-md-offset-3 col-md-8">

		<div id="content" >					
				<div class="page-header">
							<h1 class="text-center">
								实验名称
							</h1>
					</div>
				<br>
				<h3 class="strong">实验内容：</h3><br>
				<div class="article">
					<p>了解国内果蔬罐头的种类及发展状况,了解果蔬罐藏的基本原理和罐头加工工艺上的变革,掌握果蔬制作罐头时的一般工艺方法和一些特性,并掌握罐头成品外观及物理指标检验 的方法,由此对进一步提高罐头品质提出自己的设想和措施</p>
				</div>
				<br>
				<h3 class="strong">实验要求：</h3><br>
				<div class="article">
					<p>了解国内果蔬罐头的种类及发展状况,了解果蔬罐藏的基本原理和罐头加工工艺上的变革,掌握果蔬制作罐头时的一般工艺方法和一些特性,并掌握罐头成品外观及物理指标检验 的方法,由此对进一步提高罐头品质提出自己的设想和措施</p>
				</div>

				<br><br><br>
				<p>实验性质：<span id="exper_type">院级创新项目</span></p>
				<p>需要助手：<span id="numberLimit">8</span>&nbsp;个</p>
				<hr>

				<div class="panel panel-default">
				  <!-- Default panel contents -->
				  <div class="panel-heading">contact</div>
				  <table class="table">
				    <tr>
				    	<td>联系人</td>
				    	<td id="cont_name">谢晋叶</td>
				    </tr>
				    <tr>
				    	<td>电话</td>
				    	<td id="phone">18027247255</td>
				    </tr>
				    <tr>
				    	<td>邮箱</td>
				    	<td id="email">xie.jinye@163.com</td>
				    </tr>
				  </table>
				</div>

				<form>
					<input type="text" value="1" id="experId"/>
				</form>

				<div class="center">
					<p class="btn btn-primary" onclick="apply()">加入实验</p>
				</div>
			</div><!-- #content -->

</div><!-- #page -->


</body>
</html>