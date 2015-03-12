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
          <a  href="/notification/myNotification">
            <i id="ring" class="ace-icon fa fa-bell icon-animated-bell"></i>
            <span class="badge badge-important" id="badge" type="hidden">8</span>
          </a>

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
              <a href="/user/getProfile">
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

<script type="text/javascript" >

  $(document).ready(function(){
    getNotification();
  });

  //  window.setInterval(getNotification,5000);

  function getNotification() {
    $("#ring").removeClass("icon-animated-bell");
    $("#badge").hide();

    $.ajax({
      url: "/notification/getNew",
      type: "get",
      success: function (data) {
        var size = parseInt(data);

        if (size >= 1) {
          $("#ring").addClass("icon-animated-bell");
          $("#badge").show();
          $("#badge").html(size);
        }
      }
    });
  }

</script>


