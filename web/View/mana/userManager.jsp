<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css">
    <link rel="stylesheet" type="text/css" href="/css/ace.min.css">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/manager.css">

    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/ace.min.js"></script>
</head>
<html>
<body class="no-skin">
<div class="ui-widget ui-widget-content ui-corner-all ui-jqdialog jqmID1" id="editmodgrid-table" dir="ltr" tabindex="-1"
     role="dialog" aria-labelledby="edithdgrid-table" aria-hidden="false"
     style="width: 300px; height: auto; overflow: hidden; z-index: 1050; display: block; left: 483px; top: 174px;" onmousedown="mouseDown(this,event)" onmousemove="mouseMove(event)" onmouseup="mouseUp(event)">
    <div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="edithdgrid-table"
         style="cursor: move;">
        <div class="widget-header"><span class="ui-jqdialog-title" style="float: left;">新增用户</span><a
                class="ui-jqdialog-titlebar-close ui-corner-all" id="divclose" style="right: 0.3em;"><span
                class="ui-icon ui-icon-closethick"></span></a></div>
    </div>
    <div class="ui-jqdialog-content ui-widget-content" id="editcntgrid-table">
        <div>
            <form name="FormPost" id="FrmGrid_grid-table" class="FormGrid" onsubmit="return false;"
                  style="width:auto;overflow:auto;position:relative;height:auto;">
                <table id="TblGrid_grid-table" class="EditTable" cellspacing="0" cellpadding="0" border="0">
                    <tbody>
                    <tr id="FormError" style="display:none">
                        <td class="ui-state-error" colspan="2"></td>
                    </tr>
                    <tr style="display:none" class="tinfo">
                        <td class="topinfo" colspan="2"></td>
                    </tr>
                    <tr rowpos="1" class="FormData" >
                        <td class="CaptionTD">学号</td>
                        <td class="DataTD">&nbsp;<input type="text" id="account" name="account" role="textbox"
                                                        class="FormElement ui-widget-content ui-corner-all"></td>
                    </tr>
                    <tr rowpos="1" class="FormData">
                        <td class="CaptionTD">密码</td>
                        <td class="DataTD">&nbsp;<input type="text" id="password" name="password" role="textbox"
                                                        class="FormElement ui-widget-content ui-corner-all"></td>
                    </tr>

                    <tr class="FormData" style="display:none">
                        <td class="CaptionTD"></td>
                        <td colspan="1" class="DataTD"><input class="FormElement" id="id_g" type="text"
                                                              name="grid-table_id" value="_empty"></td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <table border="0" cellspacing="0" cellpadding="0" class="EditTable" id="TblGrid_grid-table_2">
                <tbody>
                <tr>
                    <td colspan="2">
                        <hr class="ui-widget-content" style="margin:1px">
                    </td>
                </tr>
                <tr id="Act_Buttons">
                    <td class="navButton"><a id="pData" class="fm-button ui-state-default ui-corner-left"
                                             style="display: none;"><span class="ui-icon ui-icon-triangle-1-w"
                                                                          style="display: none;"></span><i
                            class="ace-icon fa fa-chevron-left"></i></a><a id="nData"
                                                                           class="fm-button ui-state-default ui-corner-right"
                                                                           style="display: none;"><span
                            class="ui-icon ui-icon-triangle-1-e" style="display: none;"></span><i
                            class="ace-icon fa fa-chevron-right"></i></a></td>
                    <td class="EditButton"><button class="btn btn-info" id="sDate" onclick="adduser()">
                        确定
                    </button>&nbsp;<button class="btn btn-info" id="qDate" type="reset">
                        取消
                    </button></td>
                </tr>
                <tr style="display:none" class="binfo">
                    <td class="bottominfo" colspan="2"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"></div>
</div>
<c:import url="header.jsp"/>
<div class="col-xs-12">
    <h3 class="header smaller lighter blue">已注册用户</h3>

    <div class="table-header">
        查询结果按时间先后顺便排列
    </div>

    <!-- <div class="table-responsive"> -->

    <!-- <div class="dataTables_borderWrap"> -->
    <div>
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="row">
                <div class="col-xs-6">
                    <div id="sample-table-2_length" class="dataTables_length"><span class="label label-lg label-success arrowed-right">注册用户</span>
                      <a href="#"><span
                            class="ui-icon ace-icon fa fa-plus-circle purple" id="adduser"> </span></a></div>
                </div>
                <div class="col-xs-6">
                    <div id="" class="dataTables_length">
                    <button class="btn btn-success" onclick="acceptAll()">激活所选</button> <button class="btn btn-info" onclick="cancelAll()">取消所选</button> <button class="btn btn-danger" onclick="freezeAll()">冻结所选</button>
                    </div>
                </div>
            </div>
            <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable"
                   aria-describedby="sample-table-2_info">
                <thead>
                <tr role="row">
                    <th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="




													">
                        <label class="position-relative">
                            <input type="checkbox" class="ace">
                            <span class="lbl"></span>
                        </label>
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">ID
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">账号
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Update: activate to sort column ascending">
                        <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                        注册时间
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Price: activate to sort column ascending">姓名
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Clicks: activate to sort column ascending">性别
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Clicks: activate to sort column ascending">专业
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Clicks: activate to sort column ascending">班级
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Clicks: activate to sort column ascending">账号类型
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Clicks: activate to sort column ascending">账号状态
                    </th>
                    <th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2"
                        rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">操作
                    </th>
                </tr>
                </thead>
                <tbody role="alert" aria-live="polite" aria-relevant="all">
                <c:choose>
                    <c:when test="${list.size()>0}">
                        <c:forEach items="${list}" var="user" varStatus="number">
                            <tr class="odd">
                                <td class="center  sorting_1">
                                    <label class="position-relative">
                                        <input type="checkbox" class="ace">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${user.id}</td>
                                <td class=" ">
                                    <a href="/mana/showuserbyid?id=${user.id}">${user.account}</a>
                                </td>
                                <td class=" ">${user.createTime}</td>
                                <td class=" ">${user.name}</td>
                                <c:choose>
                                    <c:when test="${user.gender==true}">
                                        <td class="">男</td>
                                    </c:when>
                                    <c:when test="${user.gender==false}">
                                        <td class="">女</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="">未知</td>
                                    </c:otherwise>
                                </c:choose>
                                <td class=" ">${user.major.majorName}</td>
                                <td class=" ">${user.classes.className}</td>

                                <td class=" ">
                                    <c:choose>
                                        <c:when test="${user.type==1}">
                                            <span class="lbl">学生</span>
                                        </c:when>
                                        <c:when test="${user.type==2}">
                                            <span class="lbl">管理员</span>
                                        </c:when>
                                        <c:when test="${user.type==3}">
                                            <span class="lbl">超级管理员</span>
                                        </c:when>
                                    </c:choose>

                                </td>

                                <td class=" ">
                                    <label>
                                        <c:choose>
                                            <c:when test="${user.status==-1}">
                                                <input name="status${number.count}" type="radio" checked="true"
                                                       class="ace"/>
                                            </c:when>
                                            <c:otherwise>
                                                <input name="status${number.count}" type="radio" class="ace">
                                            </c:otherwise>
                                        </c:choose>
                                        <span class="lbl">未激活</span>
                                    </label>

                                    <label>
                                        <c:choose>
                                            <c:when test="${user.status==1}">
                                                <input name="status${number.count}" type="radio" checked="true"
                                                       class="ace"/>
                                            </c:when>
                                            <c:otherwise>
                                                <input name="status${number.count}" type="radio" class="ace">
                                            </c:otherwise>
                                        </c:choose>
                                        <span class="lbl">激活</span>
                                    </label>

                                    <label>
                                        <c:choose>
                                            <c:when test="${user.status==-2}">
                                                <input name="status${number.count}" type="radio" checked="true"
                                                       class="ace"/>
                                            </c:when>
                                            <c:otherwise>
                                                <input name="status${number.count}" type="radio" class="ace">
                                            </c:otherwise>
                                        </c:choose>
                                        <span class="lbl">冻结</span>
                                    </label>

                                </td>
                                <td class=" ">
                                    <div class="hidden-sm hidden-xs action-buttons">
                                        <a class="green" href="/mana/showuserbyid?id=${user.id}">
                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                        </a>

                                        <a class="red" href="#" onclick="deleteuser(${user.id})">
                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>

                </c:choose>
                </tbody>

            </table>
            <div class="row">

                <div class="col-xs-12">
                    <div class="dataTables_paginate paging_bootstrap">
                        <c:import url="/View/common/page.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- 主体结束-->
</body>
</html>
</html>
<script>
    $(document).ready(function(){
        $('#userpage').addClass("active");
        $('#editmodgrid-table').hide();
    });
    $('#adduser').click(function(){$('#editmodgrid-table').show();});
    $('#divclose').click(function(){ $('#editmodgrid-table').hide();});
    var isdown=false;
    var dleft,dtop,obj1,mouseX,mouseY;
    function mouseDown(obj,e){
        dleft=obj.style.left;
        dtop=obj.style.top;
        mouseX= e.clientX;
        mouseY= e.clientY;
        isdown=true;
    }
    function mouseMove(e){
        var div=document.getElementById("editmodgrid-table");
        var x= e.clientX;
        var y= e.clientY;
        if(isdown){
            div.style.left=parseInt(dleft)+parseInt(x)-parseInt(mouseX)+"px";
            div.style.top=parseInt(dtop)+parseInt(y)-parseInt(mouseY)+"px";
        }
    }

    function mouseUp(e){
        if(isdown){
            var x= e.clientX;
            var y= e.clientY;
            var div=document.getElementById("editmodgrid-table");
            isdown=false;
        }
    }
    function adduser(){
        var account=document.getElementById('account').value;
        var password=document.getElementById('password').value;
        console.log(account);
        console.log(password);
        $.ajax({
            url:"/user/register",
            type:"post",
            dataType:"text",
            data:{"account":account,"password":password},
            success:function(data){
                result = parseInt(data);
                if(result == -1) {
                    var message = $("#message");
                    message.html("<p style='color: red'>帐号已存在</p>");
                    return false;
                }else if(result == 1){
                   alert("注册成功");
                    window.location.reload();
                }
            }

        });
    }
    function deleteuser(uid){
        if(confirm("您确定要删除用户？")){
            $.get("/mana/deleteUser?userId="+uid,
                    function(data){
                   if(data==1){
                       alert("删除成功");
                       window.location.reload();
                   }else{
                       alert("删除失败，未知错误");
                   }
                    }

            );

    }}
    $(document).on('click', 'th input:checkbox' , function(){
        var that = this;
        $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });
    });

    function acceptAll(){
        $('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    if(this.checked){
                       var dom= $(this).parents(".odd").children().eq(1);
                        var uid=dom.html();
                        $.get("/mana/activeByid?uid="+uid,function(data){

                        });
                    }
                }
        );
        alert("操作成功");
        window.location.reload();
    }
    function cancelAll(){
        $('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    if(this.checked){
                        var dom= $(this).parents(".odd").children().eq(1);
                        var uid=dom.html();
                        $.get("/mana/cancleByid?uid="+uid,function(data){

                        });
                    }
                }
        );
        alert("操作成功");
        window.location.reload();
    }
    function freezeAll(){
        $('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    if(this.checked){
                        var dom= $(this).parents(".odd").children().eq(1);
                        var uid=dom.html();
                        $.get("/mana/freezeByid?uid="+uid,function(data){

                        });
                    }
                }
        );
        alert("操作成功");
        window.location.reload();
    }
</script>
