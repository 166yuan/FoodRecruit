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
        <h4 class="widget-title blue smaller">
            <i class="ace-icon fa fa-rss orange"></i>
            我的队伍
            <c:if test="${userId==team.leader.id}">
                <a href="#" id="alterTeam" class="green pull-right" onclick="edit()">
                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                </a>
            </c:if>

        </h4>
        <hr>
        <div class="widget-body">
          <div class="center">
              <h5 class="red showteam">队名：${team.name}</h5>
              <input type="hidden" class="update-action" id="teamname" value="${team.name}"/>
          </div>
            <div class="center">
                <h5 class="red showteam">口号：${team.slogan}</h5>
                <input type="hidden" class="update-action" id="slogan" value="${team.slogan}"/>
            </div>

            <div class="profile-activity clearfix">
                <div>
                    <img  alt="头像" src="${team.leader.image_url}">
                    队长： <a class="user" href="#"> ${team.leader.name} </a>
                </div>
                <div class="tools action-buttons" style="display: none">
                    <a href="#" class="red">
                        <i class="ace-icon fa fa-times bigger-125"></i>
                    </a>
                </div>
            </div>
            <c:forEach items="${team.participants}" var="member">
                <c:if test="${team.leader.id!=member.user.id}">
                    <div class="profile-activity clearfix">
                        <div>
                            <img class="pull-left" alt="头像" src="${member.user.image_url}">
                            队员： <a class="user" href="#"> ${member.user.name} </a>
                        </div>
                        <div class="tools action-buttons" style="display: none">
                            <a href="#" class="red">
                                <i class="ace-icon fa fa-times bigger-125"></i>
                            </a>
                        </div>
                    </div>
                </c:if>

            </c:forEach>
        </div>
    </div>
    <div class="col-sm-3">
    </div>
</div>

</body>
</html>
<script type="text/javascript">
function edit(){
    console.log("click");
$('.action-buttons').show();
    $('#teamname').show();
    $('#slogan').show();
}
</script>