<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已发布实验</title>

<link rel="stylesheet" type="text/css" media="all" href="/css/style.css">
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
			<li>
				<c:choose>
					<c:when test="${from == 'me'}">
						<a href="/exper/myPublishExperiment">已发布实验</a>
					</c:when>
					<c:when test="${from == 'myInvolve'}">
						<a href="#">我参与的实验</a>
					</c:when>
					<c:otherwise>
						<a href="/exper/nendAssistant">成为实验助手</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li class="active" id="smallTitle">${exper.name}</li>
		</ul><!-- /.breadcrumb -->

	</div>
<!-- 面包屑结束-->
<div class="page-content">
<div class="col-md-offset-3 col-md-8">

		<div id="content" >					
				<div class="page-header">
							<h1 class="text-center">
								${exper.name}
							</h1>
					</div>
				<h3 class="strong">实验内容：</h3><br>
            <input id="experId" value="${exper.id}" type="hidden"/>
				<div class="article">
					<p>${exper.information}</p>
				</div>
            <hr>
				<h3 class="strong">实验要求：</h3><br>
				<div class="article">
					<p>${exper.requirement}</p>
				</div>
            <hr>
            <p><h4>实验时间</h4><span id="experTime"><strong><fmt:formatDate value="${exper.beginTime}" pattern="yyyy年MM月dd日 HH:mm"/></strong> 到 <strong><fmt:formatDate value="${exper.endTime}" pattern="yyyy年MM月dd日 HH:mm"/></strong></span></p>
                <hr>
				<p><h4>实验性质</h4><span id="exper_type">${exper.type}</span></p>
                <hr>
				<p><h4>需要助手</h4><span id="numberLimit">${exper.count}</span>&nbsp;个</p><hr>
                <p><h4>备注</h4><c:choose>
                <c:when test="${exper.type!=null}">
                    <span>${exper.note}</span>
                </c:when>
                <c:otherwise>
                    <span>暂无</span>
                </c:otherwise>
        </c:choose></p>
				<hr>

				<div class="panel panel-default">
				  <!-- Default panel contents -->
				  <div class="panel-heading">实验联系人</div>
				  <table class="table">
				    <tr>
				    	<td>联系人</td>
				    	<td id="cont_name">${exper.contact}</td>
				    </tr>
				    <tr>
				    	<td>电话</td>
				    	<td id="phone">${exper.phone}</td>
				    </tr>
				    <tr>
				    	<td>邮箱</td>
				    	<td id="email">${exper.email}</td>
				    </tr>
				  </table>
				</div>

               <c:choose>
                   <c:when test="${userId==exper.publishId}"></c:when>
                   <c:otherwise>
                       <div class="center">
                           <a  class="btn btn-primary" onclick="joinIn()">加入实验</a>
                       </div>
                   </c:otherwise>
               </c:choose>

			</div><!-- #content -->

</div><!-- #page -->

</div>
<c:import url="/View/common/footer.jsp"/>
</body>
</html>
<script type="text/javascript">
    function joinIn(){
        var experId = $("#experId").val();
        $.ajax({
            url:"/experUser/join",
            type:"post",
            dataType:"text",
            data:{"experId":experId},
            success:function(data){
                var result = parseInt(data);
                if(result == 1){
                    alert("申请成功");
                }else if(result==-2){
                    alert("您已经报名了");
                }else{
                    alert("未成功报名，未知错误");
                }
            }
        });
    }

</script>