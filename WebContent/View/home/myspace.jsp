<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/26
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >

    <link rel="stylesheet" type="text/css" href="../css/ace.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" >
    <script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/ace.min.js"></script>
</head>
<html>
<body class="no-skin">
<!--导航栏-->
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <!-- #section:basics/sidebar.mobile.toggle -->
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <!-- /section:basics/sidebar.mobile.toggle -->
        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    食试求士
                </small>
            </a>

            <!-- /section:basics/navbar.layout.brand -->

            <!-- #section:basics/navbar.toggle -->

            <!-- /section:basics/navbar.toggle -->
        </div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="purple">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="ace-icon fa fa-bell icon-animated-bell"></i>
                        <span class="badge badge-important">8</span>
                    </a>

                    <ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-exclamation-triangle"></i>
                            您有8个新消息
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
												您被录取为<a>化学分析</a>的实验员了。
											</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="btn btn-xs btn-primary fa fa-user"></i>
                                您已经成功加入队伍
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
												您的评分结果已经出来了
											</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
												您的审核没有通过啊。
											</span>
                                </div>
                            </a>
                        </li>

                        <li class="dropdown-footer">
                            <a href="#">
                                查看所有消息
                                <i class="ace-icon fa fa-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo">
								<span class="user-info">
									<small>欢迎您,</small>
									${sss}
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog"></i>
                                设置
                            </a>
                        </li>

                        <li>
                            <a href="profile.html">
                                <i class="ace-icon fa fa-user"></i>
                                个人信息
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-power-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- /section:basics/navbar.user_menu -->
            </ul>
        </div>

        <!-- /section:basics/navbar.dropdown -->
    </div><!-- /.navbar-container -->
</div>
<!--导航栏结束-->
<!-- 主体部分-->
<div class="main-container" id="main-container">
    <!-- 选项卡-->
    <div id="sidebar" class="sidebar      h-sidebar                navbar-collapse collapse">
        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">



        </div><!-- /.sidebar-shortcuts -->

        <ul class="nav nav-list" style="top: 0px;">
            <li class="hover">
                <a href="profile.html">
                    <i class="menu-icon fa fa-user"></i>
                    <span class="menu-text"> 查看个人信息 </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="hover hsub" id="foodtest">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 食试 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="hover">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            发布实验信息
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="hover">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已发布的实验信息
                        </a>

                        <b class="arrow"></b>
                    </li>
                    <li class="hover">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            我的实验助手
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="hover hsub" id="recruit">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 求士 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="hover">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            成为实验助手
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="hover">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            我参与的实验助手
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="hover">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            查看实验评分
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="hover">
                <a href="#">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 意见反馈 </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="hover">
                <a href="#">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 求士制度 </span>
                </a>

                <b class="arrow"></b>
            </li>


        </ul><!-- /.nav-list -->

        <!-- #section:basics/sidebar.layout.minimize -->
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

        <!-- /section:basics/sidebar.layout.minimize -->
        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
        </script>
    </div>
    <!-- 选项卡结束-->
</div>
<!-- 主体结束-->
</body>
</html>
</html>

