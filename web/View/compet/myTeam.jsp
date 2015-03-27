<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的队伍</title>
    <style type="text/css">
        #team{
            text-align:center;
            font-size: 20px;
        }
    </style>
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
            我的队伍
        </li>
    </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<div class="page-content">
    <div class="page-header">
        <h1>
            我的队伍
        </h1>
    </div>

</div>

<div class="row">
<div class="col-sm-3">
</div>
    <div class="col-sm-6">
        <div class="widget-box">
            <div class="widget-header widget-header-flat">
                <h4 class="widget-title">${team.comName}</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main">
                    <div class="row">
                        <div class="col-sm-6" id="team">
                            <p>队长：${team.leader}</p>
                            <c:forEach items="${team.nameList}" var="member">
                                <p>队员：${member}</p>
                            </c:forEach>
                            <c:if test="${team.teamType==true}">
                                组队状态：<span style="color: #1718ff">完成</span>
                            </c:if>
                            <c:if test="${team.teamType==false}">
                                组队状态：<span style="color: #ff0000">未完成</span>
                            </c:if>
                        </div>


                    </div>

                    <hr>
                    <div class="row">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-3">
    </div>
</div>

</body>
</html>