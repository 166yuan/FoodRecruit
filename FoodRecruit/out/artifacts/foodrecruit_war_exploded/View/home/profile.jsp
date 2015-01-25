
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>我的信息</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >

    <link rel="stylesheet" type="text/css" href="/css/ace.min.css" >
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" >
    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/ace.min.js"></script>
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

                    i
                </li>

                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo">
								<span class="user-info">
									<small>欢迎您,</small>
									测试者
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
<!-- 面包屑-->
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="myspace.html">主页</a>
        </li>
        <li class="active">个人信息</li>
    </ul><!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<!-- 信息页-->
<div class="page-content">
<!-- /section:settings.box -->
<div class="page-header">
    <h1>
        个人信息页
    </h1>
</div><!-- /.page-header -->

<div class="row">
<div class="col-xs-12" id="page1">
<!-- PAGE CONTENT BEGINS -->
<div class="clearfix">
    <div class="pull-left alert alert-success no-margin">
        <button type="button" class="close" data-dismiss="alert">
            <i class="ace-icon fa fa-times"></i>
        </button>

        <i class="ace-icon fa fa-umbrella bigger-120 blue"></i>
        点击更改头像 ...
    </div>

    <div class="pull-right">
        <span class="green middle bolder">选择界面: &nbsp;</span>

        <div class="btn-toolbar inline middle no-margin">
            <div data-toggle="buttons" class="btn-group no-margin">
                <label class="btn btn-sm btn-yellow active" id="change1">
                    <span class="bigger-110">1</span>

                    <input type="radio" value="1">
                </label>

                <label class="btn btn-sm btn-yellow" id="change2">
                    <span class="bigger-110">2</span>

                    <input type="radio" value="2">
                </label>


            </div>
        </div>
    </div>
</div>

<div class="hr dotted"></div>

<div>
<div id="user-profile-1" class="user-profile row">
    <div class="col-xs-12 col-sm-3 center">
        <div>
            <!-- #section:pages/profile.picture -->
											<span class="profile-picture">
												<img id="avatar" class="editable img-responsive editable-click editable-empty" alt="Alex's Avatar" src="images/profileDemo.jpg"></img>
											</span>

            <!-- /section:pages/profile.picture -->
            <div class="space-4"></div>

            <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                <div class="inline position-relative">
                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                        <i class="ace-icon fa fa-circle light-green"></i>
                        &nbsp;
                        <span class="white">漩涡.鸣人</span>
                    </a>

                </div>
            </div>
        </div>

        <div class="space-6"></div>


    </div>

    <div class="col-xs-12 col-sm-9">

        <div class="space-12"></div>

        <!-- #section:pages/profile.info -->
        <div class="profile-user-info profile-user-info-striped">
            <div class="profile-info-row">
                <div class="profile-info-name"> 姓名 </div>

                <div class="profile-info-value">
                    <span class="editable editable-click" id="username">漩涡鸣人</span>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 类型 </div>

                <div class="profile-info-value">
                    <span class="editable editable-click" id="username">学生</span>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 专业.班级 </div>

                <div class="profile-info-value">
                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                    <span class="editable editable-click" id="country">软件工程</span>
                    <span class="editable editable-click" id="city">R1班</span>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 年龄 </div>

                <div class="profile-info-value">
                    <span class="editable editable-click" id="age">21</span>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 注册时间 </div>

                <div class="profile-info-value">
                    <span class="editable editable-click" id="signup">2014/12/11</span>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 个人简介 </div>

                <div class="profile-info-value">
                    <span class="editable editable-click" id="about">我要成为火影的男人！！！</span>
                </div>
            </div>
        </div>

        <!-- /section:pages/profile.info -->
        <div class="space-20"></div>

        <div class="widget-box transparent">
            <div class="widget-header widget-header-small">
                <h4 class="widget-title blue smaller">
                    <i class="ace-icon fa fa-rss orange"></i>
                    近期活动
                </h4>

                <div class="widget-toolbar action-buttons">
                    <a href="#" data-action="reload">
                        <i class="ace-icon fa fa-refresh blue"></i>
                    </a>
                    &nbsp;
                    <a href="#" class="pink">
                        <i class="ace-icon fa fa-trash-o"></i>
                    </a>
                </div>
            </div>

            <div class="widget-body">
                <div class="widget-main padding-8">
                    <!-- #section:pages/profile.feed -->
                    <div id="profile-feed-1" class="profile-feed ace-scroll scroll-active" style="position: relative;"><div class="scroll-track" style="display: block; height: 200px;"><div class="scroll-bar" style="height: 63px; top: 0px;"></div></div><div class="scroll-content" style="max-height: 200px;">
                        <div class="profile-activity clearfix">
                            <div>
                                <img class="pull-left" alt="Alex Doe's avatar" src="../assets/avatars/avatar5.png">
                                <a class="user" href="#"> 鸣人 </a>
                                修改自己的照片
                                <a href="#">去看看</a>

                                <div class="time">
                                    <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                    2014/11/29 16:20
                                </div>
                            </div>

                            <div class="tools action-buttons">
                                <a href="#" class="blue">
                                    <i class="ace-icon fa fa-pencil bigger-125"></i>
                                </a>

                                <a href="#" class="red">
                                    <i class="ace-icon fa fa-times bigger-125"></i>
                                </a>
                            </div>
                        </div>

                        <div class="profile-activity clearfix">
                            <div>
                                <img class="pull-left" alt="Susan Smith's avatar" src="../assets/avatars/avatar1.png">
                                <a class="user" href="#"> 鸣人 </a>

                                参加了求士招募
                                <div class="time">
                                    <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                    2014/11/29 16:20
                                </div>
                            </div>

                            <div class="tools action-buttons">
                                <a href="#" class="blue">
                                    <i class="ace-icon fa fa-pencil bigger-125"></i>
                                </a>

                                <a href="#" class="red">
                                    <i class="ace-icon fa fa-times bigger-125"></i>
                                </a>
                            </div>
                        </div>

                        <div class="profile-activity clearfix">
                            <div>
                                <i class="pull-left thumbicon fa fa-check btn-success no-hover"></i>
                                <a class="user" href="#"> 鸣人 </a>
                                加入了队伍
                                <a href="#">第七</a>

                                分队
                                <div class="time">
                                    <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                    2014/11/29 16:20
                                </div>
                            </div>

                            <div class="tools action-buttons">
                                <a href="#" class="blue">
                                    <i class="ace-icon fa fa-pencil bigger-125"></i>
                                </a>

                                <a href="#" class="red">
                                    <i class="ace-icon fa fa-times bigger-125"></i>
                                </a>
                            </div>
                        </div>
                    </div></div>

                    <!-- /section:pages/profile.feed -->
                </div>
            </div>
        </div>

        <div class="hr hr2 hr-double"></div>

        <div class="space-6"></div>

        <div class="center">
            <button type="button" class="btn btn-sm btn-primary btn-white btn-round">
                <span class="bigger-110">修改个人信息</span>

                <i class="icon-on-right ace-icon fa fa-arrow-right"></i>
            </button>
        </div>
    </div>
</div>
</div>
<!-- 分块一结束-->

<div id="user-profile-3" class="user-profile row">
    <div class="col-sm-offset-1 col-sm-10">
        <div class="well well-sm">
            <button type="button" class="close" data-dismiss="alert">×</button>
            &nbsp;
            <div class="inline middle blue bigger-110"> 当前信息完整度为 50 %</div>

            &nbsp; &nbsp; &nbsp;
            <div style="width:200px;" data-percent="70%" class="inline middle no-margin progress progress-striped active">
                <div class="progress-bar progress-bar-success" style="width:70%"></div>
            </div>
        </div><!-- /.well -->

        <div class="space"></div>

        <form class="form-horizontal">
            <div class="tabbable">
                <ul class="nav nav-tabs padding-16">
                    <li class="active">
                        <a data-toggle="tab" href="#edit-basic">
                            <i class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
                            基本信息
                        </a>
                    </li>

                    <li>
                        <a data-toggle="tab" href="#edit-password">
                            <i class="blue ace-icon fa fa-key bigger-125"></i>
                            密码设置
                        </a>
                    </li>
                </ul>

                <div class="tab-content profile-edit-tab-content">
                    <div id="edit-basic" class="tab-pane in active">
                        <h4 class="header blue bolder smaller">通常</h4>

                        <div class="row">
                            <div class="col-xs-12 col-sm-4">
                                <label class="ace-file-input ace-file-multiple"><input type="file"><span class="ace-file-container" data-title="修改头像"><span class="ace-file-name" data-title="No File ..."><i class=" ace-icon ace-icon fa fa-picture-o"></i></span></span><a class="remove" href="#"><i class=" ace-icon fa fa-times"></i></a></label>
                            </div>

                            <div class="vspace-12-sm"></div>

                            <div class="col-xs-12 col-sm-8">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label no-padding-right" for="form-field-username">姓名</label>

                                    <div class="col-sm-8">
                                        <input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="Username" value="alexdoe">
                                    </div>
                                </div>

                                <div class="space-4"></div>

                                <div class="form-group">
                                    <label class="col-sm-4 control-label no-padding-right" for="form-field-first">Name</label>

                                    <div class="col-sm-8">
                                        <input class="input-small" type="text" id="form-field-first" placeholder="First Name" value="Alex">
                                        <input class="input-small" type="text" id="form-field-last" placeholder="Last Name" value="Doe">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr>


                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">性别</label>

                            <div class="col-sm-9">
                                <label class="inline">
                                    <input name="form-field-radio" type="radio" class="ace">
                                    <span class="lbl middle"> 男</span>
                                </label>

                                &nbsp; &nbsp; &nbsp;
                                <label class="inline">
                                    <input name="form-field-radio" type="radio" class="ace">
                                    <span class="lbl middle"> 女</span>
                                </label>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-comment">个人简介</label>

                            <div class="col-sm-9">
                                <textarea id="form-field-comment"></textarea>
                            </div>
                        </div>

                        <div class="space"></div>
                        <h4 class="header blue bolder smaller">联系方式</h4>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-email">邮箱</label>

                            <div class="col-sm-9">
																<span class="input-icon input-icon-right">
																	<input type="email" id="form-field-email" value="alexdoe@gmail.com">
																	<i class="ace-icon fa fa-envelope"></i>
																</span>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-phone">电话</label>

                            <div class="col-sm-9">
																<span class="input-icon input-icon-right">
																	<input class="input-medium input-mask-phone" type="text" id="form-field-phone">
																	<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																</span>
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-phone">QQ</label>

                            <div class="col-sm-9">
																<span class="input-icon input-icon-right">
																	<input class="input-medium input-mask-phone" type="text" id="form-field-phone">

																</span>
                            </div>
                        </div>

                    </div>

                    <div id="edit-password" class="tab-pane">
                        <div class="space-10"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-pass1">原密码</label>

                            <div class="col-sm-9">
                                <input type="password" id="form-field-pass1">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-pass1">新密码</label>

                            <div class="col-sm-9">
                                <input type="password" id="form-field-pass1">
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-pass2">确认密码</label>

                            <div class="col-sm-9">
                                <input type="password" id="form-field-pass2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="button">
                        <i class="ace-icon fa fa-check bigger-110"></i>
                        保存
                    </button>

                    &nbsp; &nbsp;
                    <button class="btn" type="reset">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        重置
                    </button>
                </div>
            </div>
        </form>
    </div><!-- /.span -->
</div>

<!-- PAGE CONTENT ENDS -->
</div>

<!-- 在此添加-->

<!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->
</div><!-- /.row -->
</div>
<!-- 信息页结束-->
</div>
<!-- 主体结束-->
</body>
</html>
</html>



<script type="text/javascript">
    $(document).ready(
            function(){
                $('#user-profile-3').hide();
            }
    );
    $('#change1').click(
            function(){
                $('#user-profile-3').hide();
                $('#user-profile-1').show();
            }
    );
    $('#change2').click(
            function(){
                $('#user-profile-3').show();
                $('#user-profile-1').hide();

            }
    );
</script>
