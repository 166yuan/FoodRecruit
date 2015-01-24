<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/22
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <title>食试求士</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="/css/main.css" >
    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

</head>
<html>
<body>

<nav class="navbar navbar-ghost" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">求试</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">修改个人信息</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">食试
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">发布实验信息</a></li>
                            <li><a href="#">已发布的实验信息</a></li>
                            <li><a href="#">我的实验助手</a></li>
                        </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">求士
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">成为实验助手</a></li>
                            <li><a href="#">我参与的实验</a></li>
                            <li><a href="#">我的评分</a></li>
                        </ul>
                </li>
                <li><a href="#">意见反馈</a></li>
                <li><a href="#">食试求士管理制度</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${username}，你好</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

</body>
</html>
</html>
<script type="text/javascript">
    $('.dropdown').hover(function(){
                $(this).children('.dropdown-menu').show();
            },
            function(){
                $(this).children('.dropdown-menu').hide();
            }
    );
</script>
