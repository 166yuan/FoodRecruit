
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>我的信息</title>
    <script type="text/javascript" src="/js/user/profile.js"></script>
</head>
<html>
<body class="no-skin">
<!--导航栏-->
<c:import url="/View/common/header.jsp"/>
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
            <a href="/View/user/myspace.jsp">主页</a>
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
        点击下面头像可更改哦！
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
                <img id="avatar" class="editable img-responsive editable-click editable-empty" width="150px" height="150px" alt="Alex's Avatar" src="${user.image_url}"/>
                <form name="userForm" action="/user/upload" method="post" enctype="multipart/form-data" class="form-inline editableform" >
                    <div class="control-group form-group">
                        <div>
                            <div class="editable-input editable-image">
                            <span>
                                <label class="ace-file-input ace-file-multiple" style="width: 150px;">
                                    <input type="file" name="file" id="upfile" onchange="uploadFile(this)">
                                    <span class="ace-file-container" data-title="点我选择新头像">
                                        <span class="ace-file-name" data-title="No File ...">
                                            <i class=" ace-icon fa fa-picture-o"></i>
                                        </span>
                                    </span>
                                    <img id="preview" style="display: none;"/>
                                    <a class="remove" href="#">
                                        <i class=" ace-icon fa fa-times"></i>
                                    </a>
                                </label>
                            </span>
                            </div>
                            <div class="editable-buttons">
                                <button type="submit" class="btn btn-info editable-submit">
                                    <i class="ace-icon fa fa-check"></i></button>
                                <button type="button" class="btn editable-cancel">
                                    <i class="ace-icon fa fa-times"></i></button></div>
                            </div>
                        <div class="editable-error-block help-block" style="display: none;"></div>
                    </div>
                </form>
            </span>



            <!-- /section:pages/profile.picture -->
            <div class="space-4"></div>

            <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                <div class="inline position-relative">
                    <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                        <i class="ace-icon fa fa-circle light-green"></i>
                        &nbsp;
                        <span class="white" id="badge">${user.name}</span>
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
                   ${user.name}
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 类型 </div>

                <div class="profile-info-value">
                    <c:choose>
                        <c:when test="${user.type == 1}">
                            <c:out value="学生"></c:out>
                        </c:when>
                        <c:otherwise>
                            <c:out value="管理员"></c:out>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 专业.班级 </div>

                <div class="profile-info-value">
                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                    ${user.major.majorName} • ${user.classes.className}
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 联系电话 </div>

                <div class="profile-info-value">
                    ${user.phone}
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> QQ </div>

                <div class="profile-info-value">
                    ${user.qq}
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> 个人简介 </div>

                <div class="profile-info-value">
                    ${user.self_info}
                </div>
            </div>
        </div>

        <!-- /section:pages/profile.info -->
        <div class="space-20"></div>


        <div class="hr hr2 hr-double"></div>

        <div class="space-6"></div>

        <div class="center">
            <button type="button" class="btn btn-sm btn-primary btn-white btn-round">
                <span class="bigger-110" ><a onclick="alterInfo()">修改个人信息</a></span>

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
                        <form id="profile-form">
                            <h4 class="header blue bolder smaller">通常</h4>

                            <div class="row">
                                <div class="col-xs-12 col-sm-4">
                                    <label class="ace-file-input ace-file-multiple"><input type="file"><span class="ace-file-container" data-title="修改头像"><span class="ace-file-name" data-title="No File ..."><i class=" ace-icon ace-icon fa fa-picture-o"></i></span></span><a class="remove" href="#"><i class=" ace-icon fa fa-times"></i></a></label>
                                </div>

                                <div class="vspace-12-sm"></div>

                                <div class="col-xs-12 col-sm-8">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label no-padding-right" for="form-field-name">姓名</label>

                                        <div class="col-sm-8">
                                            <input class="col-xs-12 col-sm-10" type="text" id="form-field-name" name="name" value="${user.name}" placeholder="Username">
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-4 control-label no-padding-right" >专业，年级</label>

                                        <div class="col-sm-8">
                                            <input class="input-small" type="text" name="major" value="aa" id="form-field-major" placeholder="专业">
                                            <input class="input-small" type="text" name="classes" value="..." id="form-field-classes" placeholder="年级">
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
                                        <input name="form-field-radio" type="radio" class="ace" checked="true">
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
                                    <textarea id="form-field-comment" ></textarea>
                                </div>
                            </div>

                            <div class="space"></div>
                            <h4 class="header blue bolder smaller">联系方式</h4>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-email">邮箱</label>

                                <div class="col-sm-9">
    																<span class="input-icon input-icon-right">
    																	<input type="email" name="email" value="${user.email}" id="form-field-email">
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
    																	<input class="input-medium input-mask-phone" name="phone" value="${user.phone}" type="text" id="form-field-phone">
    																	<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
    																</span>
                                </div>
                            </div>

                            <div class="space-4"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-QQ">QQ</label>

                                <div class="col-sm-9">
    																<span class="input-icon input-icon-right">
    																	<input class="input-medium input-mask-phone" name="qq" value="${user.qq}" type="text" id="form-field-QQ">

    																</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"></label>

                                <div class="col-sm-9"> 
                                         <div class="col-md-9">
                                                <button class="btn btn-info" type="button" onclick="submitProfileForm()">
                                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                                    确认修改
                                                </button>
                                       </div>
                                        
                                </div>
                            </div>
                       </form>
                     </div>
                    
                    <div id="edit-password" class="tab-pane">
                    <form id="pass-form">
                        <div class="space-10"></div>
                        <div id="passwd-message"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-pass1">原密码</label>

                            <div class="col-sm-9">
                                <input type="password" id="form-field-pass1">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-pass2">新密码</label>

                            <div class="col-sm-9">
                                <input type="password" id="form-field-pass2">
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-pass3">确认密码</label>

                            <div class="col-sm-9">
                                <input type="password" id="form-field-pass3">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>

                            <div class="col-sm-9"> 
                                     <div class="col-md-9">
                                            <button class="btn btn-info" type="button" onclick="submitPassForm()">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                确认修改
                                            </button>

                                            &nbsp; &nbsp;
                                            <button class="btn" type="reset">
                                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                                重置
                                            </button>
                                   </div>
                                    
                            </div>
                        </div>
                         </form>
                    </div>
                   

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
                $('.editableform').hide();
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
    $('#avatar').click(
        function(){
            $(this).hide();
            $('.editableform').show();
        }
    );
    $('.editable-cancel').click(
      function(){
          $('.ace-file-container').show();
          $('#preview').hide();
          $('.editableform').hide();
          $('#avatar').show();
      }
    );
    function alterInfo(){
        $('#user-profile-3').show();
        $('#user-profile-1').hide();
        $('#change1').removeClass("active");
        $('#change2').addClass("active");
    }
</script>
