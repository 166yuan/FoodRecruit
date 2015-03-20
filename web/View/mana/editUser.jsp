<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <!-- 强制国内垃圾浏览器开启高速模式-->
  <meta name="renderer" content="webkit">
  <title>个人中心</title>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >

  <link rel="stylesheet" type="text/css" href="/css/ace.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/manager.css" >
  <link rel="stylesheet" type="text/css" href="/css/all.css" >
  <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/ace.min.js"></script>
  <script type="text/javascript" src="/js/mana/edit.js"></script>
</head>

<body class="no-skin" >
<c:import url="header.jsp"/>

<div class="page-content">

  <!-- #section:settings.box -->
  <!-- /.ace-settings-container -->

  <!-- /section:settings.box -->
  <div class="page-header">
    <h1>
      <a href="/mana/index">用户管理</a>
      <small>
        <i class="ace-icon fa fa-angle-double-right"></i>
       账号信息
      </small>
    </h1>
  </div><!-- /.page-header -->

  <div class="row">
    <div class="col-xs-12" id="editbody">
      <!-- PAGE CONTENT BEGINS -->
      <div class="col-lg-10">
      <form class="form-horizontal" action="/mana/edituser" role="form">
        <input type="hidden" name="id" value="${user.id}">
        <!-- #section:elements.form -->
        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 账号 </label>
          <div class="col-sm-9">
            <input type="text" name="account" value="${user.account}" placeholder="账号" class="col-xs-10 col-sm-5">
          </div>
        </div>
        <!-- /section:elements.form -->
        <div class="space-4"></div>

        <div class="form-group">
          <label  class="col-sm-3 control-label no-padding-right" for="form-field-2"> 密码 </label>

          <div class="col-sm-9">
            <input type="password" readonly="" value="${user.password}" id="form-field-2" name="password" placeholder="密码" class="col-xs-10 col-sm-5">
          <span class="help-inline col-xs-12 col-sm-7">
											<label class="middle">
                                              <input class="ace" type="checkbox" id="id-disable-check">
                                              <span class="lbl"> 修改</span>
                                            </label>
										</span>
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 姓名 </label>
          <div class="col-sm-9">
            <input type="text"  value="${user.name}" placeholder="姓名" name="name" class="col-xs-10 col-sm-5">
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 注册时间 </label>
          <div class="col-sm-9">
            <span>${user.createTime}</span>
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label  class="col-sm-3 control-label no-padding-right" for="form-field-2"> 账号状态 </label>
          <div class="col-sm-9">
            <c:choose>
              <c:when test="${user.status==1}" >
          <input name="status" type="radio" checked="true" class="ace" value="1"/>
                  <span class="lbl">激活</span>
                  <input name="status" type="radio" class="ace" value="-1"/>
                  <span class="lbl">未激活</span>
                  <input name="status" type="radio" class="ace" value="-2"/>
                  <span class="lbl">冻结</span>
              </c:when>
                <c:when test="${user.status==-1}">
                    <input name="status" type="radio" class="ace" value="1"/>
                    <span class="lbl">激活</span>
                    <input name="status" type="radio" checked="true" class="ace" value="-1"/>
                    <span class="lbl">未激活</span>
                    <input name="status" type="radio" class="ace" value="-2"/>
                    <span class="lbl">冻结</span>
                </c:when>
              <c:otherwise>
                  <input name="status" type="radio" class="ace" value="1"/>
                  <span class="lbl">激活</span>
                  <input name="status" type="radio"  class="ace" value="-1"/>
                  <span class="lbl">未激活</span>
                  <input name="status" type="radio" checked="true" class="ace" value="-2"/>
                  <span class="lbl">冻结</span>
              </c:otherwise>
            </c:choose>
          </div>
        </div>


        <div class="form-group">

          <label  class="col-sm-3 control-label no-padding-right" for="form-field-2"> 用户等级</label>
          <div class="col-sm-9">
            <c:choose>
              <c:when test="${user.type==1}" >
                <input name="type" type="radio" checked="true" class="ace" value="1"/>
                  <span class="lbl">学生</span>
                  <input name="type" type="radio" class="ace" value="2"/>
                  <span class="lbl">管理员</span>
                  <input name="type" type="radio" class="ace" value="3"/>
                  <span class="lbl">超级管理员</span>
              </c:when>
                <c:when test="${user.type==2}">
                    <input name="type" type="radio"  class="ace" value="1"/>
                    <span class="lbl">学生</span>
                    <input name="type" type="radio" checked="true" class="ace" value="2"/>
                    <span class="lbl">管理员</span>
                    <input name="type" type="radio" class="ace" value="3"/>
                    <span class="lbl">超级管理员</span>
                </c:when>
              <c:otherwise>
                  <input name="type" type="radio"  class="ace" value="1"/>
                  <span class="lbl">学生</span>
                  <input name="type" type="radio"  class="ace" value="2"/>
                  <span class="lbl">管理员</span>
                  <input name="type" type="radio" checked="true" class="ace" value="3"/>
                  <span class="lbl">超级管理员</span>
              </c:otherwise>
            </c:choose>


          </div>
        </div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 性别 </label>
          <div class="col-sm-9">
            <c:choose>
              <c:when test="${user.gender==true}">
                <input name="gender" type="radio" checked="true" class="ace" value="true"/>
                  <span class="lbl">男</span>
                  <input name="gender" type="radio"  class="ace" value="false"/>
                  <span class="lbl">女</span>
                  <input name="gender" type="radio"  class="ace" value=""/>
                  <span class="lbl">未选定</span>
              </c:when>
               <c:when test="${user.gender==false}">
                   <input name="gender" type="radio"  class="ace" value="true"/>
                   <span class="lbl">男</span>
                   <input name="gender" type="radio" checked="true" class="ace" value="false"/>
                   <span class="lbl">女</span>
                   <input name="gender" type="radio"  class="ace" value=""/>
                   <span class="lbl">未选定</span>
               </c:when>
              <c:otherwise>
                  <input name="gender" type="radio"  class="ace" value="true"/>
                  <span class="lbl">男</span>
                  <input name="gender" type="radio" class="ace" value="false"/>
                  <span class="lbl">女</span>
                  <input name="gender" type="radio"  checked="true" class="ace" value=""/>
                  <span class="lbl">未选定</span>
              </c:otherwise>
            </c:choose>


          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 专业 </label>
          <div class="col-sm-3">
            <select class="form-control" name="major" id="form-field-select-1">
              <option value="${user.major.id}">${user.major.majorName}</option>
            </select>
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 班级 </label>
          <div class="col-sm-3">
            <select class="form-control" name="classes" id="form-field-select-2">
              <option value="${user.classes.id}">${user.classes.className}</option>
            </select>
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 联系方式 </label>
          <div class="col-sm-9">
            <input type="text" placeholder="联系方式" value="${user.phone}" name="phone" class="col-xs-10 col-sm-5">
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 邮箱 </label>
          <div class="col-sm-9">
            <input type="text" placeholder="邮箱"  value="${user.email}"  name="email" class="col-xs-10 col-sm-5">
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> qq </label>
          <div class="col-sm-9">
            <input type="text" placeholder="qq" value="${user.qq}" name="qq" class="col-xs-10 col-sm-5">
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 地址 </label>
          <div class="col-sm-9">
            <input type="text" placeholder="地址"  value="${user.address}"  name="address" class="col-xs-10 col-sm-5">
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 个人简介 </label>
          <div class="col-sm-9">
            <input type="text" placeholder="个人简介" value="${user.self_info}" name="self_info" class="col-xs-10 col-sm-5">
          </div>
        </div>

        <div class="space-4"></div>

        <div class="form-group">
          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 是否主动招收 </label>
          <div class="col-sm-9">
            <c:choose>
              <c:when test="${user.isActive==true}">
                <input name="isActive" type="radio" checked="true"  class="ace" value="true"/>
                  <span class="lbl">是</span>
                  <input name="isActive" type="radio"  class="ace" value="false"/>
                  <span class="lbl">否</span>
              </c:when>
              <c:otherwise>
                  <input name="isActive" type="radio"  class="ace" value="true"/>
                  <span class="lbl">是</span>
                  <input name="isActive" type="radio" checked="true"  class="ace" value="false"/>
                  <span class="lbl">否</span>
              </c:otherwise>
            </c:choose>


          </div>
        </div>

        <div class="space-4"></div>

        <div class="clearfix form-actions">
          <div class="col-md-offset-3 col-md-9">
            <button class="btn btn-info" type="submit">
              <i class="ace-icon fa fa-check bigger-110"></i>
              提交
            </button>

            &nbsp; &nbsp; &nbsp;
            <button class="btn" type="reset">
              <i class="ace-icon fa fa-undo bigger-110"></i>
              重置
            </button>
          </div>
        </div>

        <div class="hr hr-24"></div>
      </form>
      </div>
      <div class="col-lg-2"><img src="${user.image_url}" alt="头像"> </div>
    </div><!-- /.col -->
  </div><!-- /.row -->
    </div>

<!-- 下面这个div不是多余的，是include页面中header.jsp的另一半-->
</div>
<!-- 主体结束-->
</body>
</html>
<script>
    $(document).ready(
            function(){
                $('#userpage').addClass("active");
            }
    );
</script>

