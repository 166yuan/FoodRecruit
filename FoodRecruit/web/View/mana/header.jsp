<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <i class="fa fa-leaf"></i>
        <span id="title">求士后台管理</span>

      </a>

      <!-- /section:basics/navbar.layout.brand -->

      <!-- #section:basics/navbar.toggle -->

      <!-- /section:basics/navbar.toggle -->
    </div>


  </div><!-- /.navbar-container -->
</div>
<!--导航栏结束-->
<!-- 主体部分-->
<div class="main-container" id="main-container">
  <div id="sidebar" class="sidebar      h-sidebar                navbar-collapse collapse">
    <script type="text/javascript">
      try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list" style="top: 0px;">

      <li class="hover">
        <span> </span>
      </li>

      <li class="hover" id="userpage">
        <a href="/mana/index">
          <i class="menu-icon fa fa-users"></i>
          <span class="menu-text"> 用户管理 </span>
        </a>

        <b class="arrow"></b>

      </li>

      <li class="hover hsub" id="experpage">
        <a href="#" class="dropdown-toggle">
          <i class="menu-icon fa fa-flask"></i>
          <span class="menu-text"> 实验管理 </span>

          <b class="arrow fa fa-angle-down"></b>
        </a>

        <b class="arrow"></b>
      </li>

      <li class="hover hsub" id="contentpage">
        <a href="#" class="dropdown-toggle">
          <i class="menu-icon fa fa-globe"></i>
          <span class="menu-text"> 竞赛管理 </span>

          <b class="arrow fa fa-angle-down"></b>
        </a>

        <b class="arrow"></b>

        <ul class="submenu">
          <li class="hover">
            <a href="tables.html">
              <i class="menu-icon fa fa-caret-right"></i>
              下拉栏1
            </a>

            <b class="arrow"></b>
          </li>
          <li class="hover">
            <a href="jqgrid.html">
              <i class="menu-icon fa fa-caret-right"></i>
              下拉栏2
            </a>
            <b class="arrow"></b>
          </li>
        </ul>
      </li>

      <li class="hover hsub" id="feedpage">
        <a href="/mana/showfeedback?type=3" >
          <i class="menu-icon fa fa-user"></i>
          <span class="menu-text"> 用户反馈 </span>
        </a>

      <li class="hover hsub" id="classpage">
        <a href="/mana/classmanager?page=1" >
          <i class="menu-icon fa fa-pencil-square-o"></i>
          <span class="menu-text"> 班级管理 </span>
        </a>
      <ul class="submenu">
        <li class="hover">
          <a href="/mana/majormanager?page=1">
            <i class="menu-icon fa fa-caret-right"></i>
            查看专业
          </a>

          <b class="arrow"></b>
        </li>
        <li class="hover">
          <a href="/mana/classmanager?page=1">
            <i class="menu-icon fa fa-caret-right"></i>
            查看班级
          </a>
          <b class="arrow"></b>
        </li>
      </ul>
      </li>

      <li class="hover" id="oppage">
        <a href="widgets.html">
          <i class="menu-icon fa fa-list-alt"></i>
          <span class="menu-text"> 操作一览 </span>
        </a>
        <b class="arrow"></b>
      </li>


      <li class="hover hsub">
        <a href="#" class="dropdown-toggle">
          <i class="menu-icon fa fa-tag"></i>
          <span class="menu-text"> 关于 </span>
          <b class="arrow fa fa-angle-down"></b>
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