<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/11/22
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >

    <link rel="stylesheet" type="text/css" href="../css/ace.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/main.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/login.css" >
    <script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/ace.min.js"></script>
    <script type="text/javascript" src="../js/demo.js"></script>
    <script type="text/javascript" src="../js/user/loginAndRegister.js"></script>
</head>
<html>
<body>

<nav class="navbar navbar-ghost" role="navigation">
    <div class="container" id="navbar">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" onclick="show_box('login-box');">登录</a></li>
                <li><a href="#" onclick="show_box('signup-box');">注册</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <a class="navbar-brand" href="#"><img alt="logo" src="/images/logo.gif" ></a>


    <div class="rowspan" style="width:80%; margin:0 auto;height:500px;">
        <h1 class="form-signin-heading">食试求士</h1>
        <div class="position-relative">
            <div id="login-box" class="login-box visiable widget-box no-border visible">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            请输入信息
                        </h4>

                        <div class="space-6"></div>
                        <div id="login-message"></div>
                        <form action="/user/login" id="login" method="post">
                            <fieldset>
                                <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="account" id="login-account" class="form-control" placeholder="学号或者工号">
															<i class="icon-user"></i>
														</span>
                                </label>

                                <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" id="login-password" class="form-control" placeholder="密码">
															<i class="icon-lock"></i>
														</span>
                                </label>
                                <div class="space"></div>
                                <div id="login-message"></div>
                                <div class="clearfix">
                                    <label class="inline">
                                        <input type="checkbox" >
                                        <span class="lbl"> 记住我</span>
                                    </label>

                                    <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                                        <i class="icon-key"></i>
                                        登录
                                    </button>
                                </div>

                                <div class="space-4"></div>
                            </fieldset>
                        </form>



                    </div><!-- /widget-main -->

                    <div class="toolbar clearfix">
                        <div>
                            <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                                <i class="icon-arrow-left"></i>
                                忘记密码？
                            </a>
                        </div>

                        <div>
                            <a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
                                还没注册？去注册
                                <i class="icon-arrow-right"></i>
                            </a>
                        </div>
                    </div>
                </div><!-- /widget-body -->
            </div><!-- /login-box -->

            <div id="forgot-box" class="forgot-box widget-box no-border">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header red lighter bigger">
                            <i class="icon-key"></i>
                            找回密码
                        </h4>

                        <div class="space-6"></div>
                        <p>
                            请输入您的邮箱来找回密码
                        </p>

                        <form>
                            <fieldset>
                                <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email">
															<i class="icon-envelope"></i>
														</span>
                                </label>

                                <div class="clearfix">
                                    <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                        <i class="icon-lightbulb"></i>
                                        发送！
                                    </button>
                                </div>
                            </fieldset>
                        </form>
                    </div><!-- /widget-main -->

                    <div class="toolbar center">
                        <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                            返回登录
                            <i class="icon-arrow-right"></i>
                        </a>
                    </div>
                </div><!-- /widget-body -->
            </div><!-- /forgot-box -->

            <div id="signup-box" class="signup-box widget-box no-border ">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header green lighter bigger">
                            <i class="icon-group blue"></i>
                            新用户注册
                        </h4>

                        <div class="space-6"></div>
                        <p>请输入您的注册信息 </p>
                        <div id="register-message"></div>
                        <form action="/user/register" id="register" method="post">
                            <fieldset>
                                <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="account" id="register-account" class="form-control" placeholder=学号">
															<i class="icon-user"></i>
														</span>
                                </label>

                                <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" id="register-password" class="form-control" placeholder="密码">
															<i class="icon-lock"></i>
														</span>
                                </label>

                                <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="repeat" class="form-control" placeholder="重复密码">
															<i class="icon-retweet"></i>
														</span>
                                </label>
                                <div class="space-24"></div>

                                <div class="clearfix">
                                    <button type="reset" class="width-30 pull-left btn btn-sm">
                                        <i class="icon-refresh"></i>
                                        重置
                                    </button>

                                    <input type="submit" value="注册"  class="width-65 pull-right btn btn-sm btn-success">

                                        <i class="icon-arrow-right icon-on-right"></i>
                                    </input>
                                </div>
                            </fieldset>
                        </form>
                    </div>

                    <div class="toolbar center">
                        <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                            <i class="icon-arrow-left"></i>
                            返回登录
                        </a>
                    </div>
                </div><!-- /widget-body -->
            </div><!-- /signup-box -->
        </div>
    </div>


</div>
<br>
<br>
<br>
<div class="clearfix"></div>
<div class="footer">
    <div class="container">
        <div>
            <dl>
                <dt>关于我们</dt>
            </dl>
            <div class="copyright">
			<span class="pull-left">版权归 XXX
								</span>
                <span class="pull-right">skl System V3.0 Pionner</span>
                <div style="height: 0px;line-height:0px;clear: both;">&nbsp;</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</html>
<script type="text/javascript">

    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
        jQuery("#login-message").html("");
        jQuery("#register-message").html("");
    }


</script>
