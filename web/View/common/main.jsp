<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
  <meta charset="UTF-8">
  <!-- 强制国内垃圾浏览器开启高速模式-->
  <meta name="renderer" content="webkit">
  <title>个人中心</title>
</head>
<html>
<body class="no-skin">
<c:import  url="/View/common/header.jsp"/>
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
        <a href="/user/getProfile">
          <i class="menu-icon fa fa-user"></i>
          <span class="menu-text"> 查看个人信息 </span>
        </a>

        <b class="arrow"></b>
      </li>


      <li class="hover hsub" id="foodtest">
        <a href="#" class="dropdown-toggle">
          <i class="menu-icon fa fa-list"></i>
          <span class="menu-text"> 实验发布 </span>

          <b class="arrow fa fa-angle-down"></b>
        </a>

        <b class="arrow"></b>

        <ul class="submenu">

                <li class="hover">
                    <a href="/exper/publish">
                        <i class="menu-icon fa fa-caret-right"></i>
                        发布实验信息
                    </a>

                    <b class="arrow"></b>
                </li>


          <li class="hover">
            <a href="/exper/myPublishExperiment?page=1">
              <i class="menu-icon fa fa-caret-right"></i>
              我发布的实验
            </a>

            <b class="arrow"></b>
          </li>

            <li class="hover">
                <a href="/exper/scoreExper?page=1">
                    <i class="menu-icon fa fa-caret-right"></i>
                    我的实验员评分
                </a>

                <b class="arrow"></b>
            </li>
        </ul>
      </li>




      <li class="hover hsub" id="recruit">
        <a href="#" class="dropdown-toggle">
          <i class="menu-icon fa fa-list"></i>
          <span class="menu-text"> 参与实验 </span>

          <b class="arrow fa fa-angle-down"></b>
        </a>

        <b class="arrow"></b>

        <ul class="submenu">
          <li class="hover">
            <a href="/exper/nendAssistant?page=1">
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
              我得到的实验评分
            </a>

            <b class="arrow"></b>
          </li>
        </ul>
      </li>



      <c:choose>
        <c:when test="${user_type==1}">
          <li class="hover">
            <a href="#">
              <i class="menu-icon fa fa-pencil-square-o"></i>
              <span class="menu-text"> 我的竞赛 </span>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
              <li class="hover">
                <a href="/compet/getAll?page=1">
                  <i class="menu-icon fa fa-caret-right"></i>
                  查看竞赛列表
                </a>

                <b class="arrow"></b>
              </li>

              <li class="hover">
                <a href="/compet/mycompet">
                  <i class="menu-icon fa fa-caret-right"></i>
                  我参与的竞赛
                </a>

                <b class="arrow"></b>
              </li>

            </ul>
          </li>
        </c:when>
        <c:otherwise>
          <li class="hover">
            <a href="#">
              <i class="menu-icon fa fa-pencil-square-o"></i>
              <span class="menu-text"> 竞赛管理 </span>
            </a>

            <b class="arrow"></b>
            <ul class="submenu">
              <li class="hover">
                <a href="/compet/publish">
                  <i class="menu-icon fa fa-caret-right"></i>
                  竞赛发布
                </a>

                <b class="arrow"></b>
              </li>

              <li class="hover">
                <a href="/compet/getAll?page=1">
                  <i class="menu-icon fa fa-caret-right"></i>
                  竞赛管理
                </a>

                <b class="arrow"></b>
              </li>

            </ul>
          </li>
        </c:otherwise>
      </c:choose>

      <li class="hover">
        <a href="/user/feedback">
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




