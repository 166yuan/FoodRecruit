<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- #section:basics/navbar.dropdown -->
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="/css/ace.min.css" >
<link rel="stylesheet" type="text/css" href="/css/all.css" >
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" >
<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/ace.min.js"></script>
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
            <img class="nav-user-photo" src="${imageUrl}" alt="Jason's Photo">
								<span class="user-info">
									<small>欢迎您,</small>
									${account}
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
              <a href="/user/profile">
                <i class="ace-icon fa fa-user"></i>
                个人信息
              </a>
            </li>

            <li class="divider"></li>

            <li>
              <a href="/user/logout">
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