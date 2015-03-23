<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c-rt" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>专业管理</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css">
    <link rel="stylesheet" type="text/css" href="/css/ace.min.css">

    <link rel="stylesheet" type="text/css" href="/css/manager.css">
    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/ace.min.js"></script>
    <script type="text/javascript" src="/js/jquery.jqGrid.min.js"></script>
</head>
<html>
<body class="no-skin">
<div class="ui-widget ui-widget-content ui-corner-all ui-jqdialog jqmID1" id="editmodgrid-table" dir="ltr" tabindex="-1"
     role="dialog" aria-labelledby="edithdgrid-table" aria-hidden="false"
     style="width: 300px; height: auto; overflow: hidden; z-index: 1050; display: block; left: 483px; top: 174px;" onmousedown="mouseDown(this,event)" onmousemove="mouseMove(event)" onmouseup="mouseUp(event)">
    <div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" id="edithdgrid-table"
         style="cursor: move;">
        <div class="widget-header"><span class="ui-jqdialog-title" style="float: left;">新增专业</span><a
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
                    <tr rowpos="1" class="FormData" id="tr_id">
                        <td class="CaptionTD">名称</td>
                        <td class="DataTD">&nbsp;<input type="text" id="m_name" name="name" role="textbox"
                                                        class="FormElement ui-widget-content ui-corner-all"></td>
                    </tr>

                    <tr rowpos="3" class="FormData" id="tr_name">
                        <td class="CaptionTD">年级</td>
                        <td class="DataTD">&nbsp;<input type="text" size="20" maxlength="30" id="m_year" name="year"
                                                        role="textbox"
                                                        class="FormElement ui-widget-content ui-corner-all">级</td>
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
                    <td class="EditButton"><button class="btn btn-info" id="sDate" onclick="submit()">
                        确定
                    </button>
                        <button class="btn btn-info" id="cDate" >
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
    <h3 class="header smaller lighter blue">专业管理</h3>
    <button class="btn btn-info" id="s_major">
        <i class="ace-icon fa fa-flask align-top bigger-125"></i>
        查看专业
    </button>

    <button class="btn btn-info" id="s_class">
        <i class="ace-icon fa fa-users align-top bigger-125"></i>
        查看班级
    </button>

    <br>
    <br>

    <div class="table-header">
        查询结果按时间先后顺便排列
    </div>

    <!-- <div class="table-responsive"> -->

    <!-- <div class="dataTables_borderWrap"> -->
    <div>
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="row">
                <div class="col-xs-6">
                    <div class="ui-pg-div"><span class="label label-lg label-success arrowed-right">新增专业</span><span
                            class="ui-icon ace-icon fa fa-plus-circle purple" id="addclass"></span></div>
                </div>
            </div>
            <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable"
                   aria-describedby="sample-table-2_info">
                <thead>
                <tr role="row">
                    <th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="">
                        <label class="position-relative">
                            <input type="checkbox" class="ace">
                            <span class="lbl"></span>
                        </label>
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">编号
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">专业名称
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">年级
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">编辑
                    </th>
                </tr>
                </thead>


                <tbody role="alert" aria-live="polite" aria-relevant="all">
                <c:forEach items="${list}" var="majar" varStatus="number">
                <tr class="odd">
                    <td class="center  sorting_1">
                        <label class="position-relative">
                            <input type="checkbox" class="ace">
                            <span class="lbl"></span>
                        </label>
                    </td>

                    <td class=" ">
                        ${number.count}
                    </td>
                    <td class=" ">${majar.majorName}</td>
                    <td class=" ">${majar.year}</td>
                    <td class=" ">
                        <div class="hidden-sm hidden-xs action-buttons">
                            <a class="green" href="#">
                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                            </a>

                            <a class="red" href="#" onclick="deletemajor(${majar.id})">
                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                            </a>
                        </div>
                    </td>
                </tr>
                </c:forEach>
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
<!-- 下面这个div不是多余的，是include页面中header.jsp的另一半-->
</div>
<!-- 主体结束-->
</body>
</html>
</html>

<script type="text/javascript">
    $(document).ready(function(){
        $('#editmodgrid-table').hide();
        $('#classpage').addClass('active');
        var url=document.URL;
        var index=url.indexOf('?');

    });
    $('#addclass').click(function(){$('#editmodgrid-table').show();});
    $('#divclose').click(function(){ $('#editmodgrid-table').hide();})
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
    $('#s_major').click(function(){window.location.href="/mana/majormanager?page=1";});
    $('#s_class').click(function(){window.location.href="/mana/classmanager?page=1";});
    function submit(){
        var name=document.getElementById('m_name').value;
        var year=document.getElementById('m_year').value;
        console.log(name);
        if(isNaN(year)){
        alert("年级必须是数字");
        }else if(year<2000||year>3000){
        alert("年级格式必须是20XX");
        }else{
            var data={
                "name":name,
                "year":year
            };
            data=JSON.stringify(data);
            $.ajax({
                url:"/mana/addmajor",
                type:"post",
                dataType:"json",
                data:data,
                success:function(data){
                    console.log(data);
                    if(data==1){
                        alert("添加成功");
                        window.location.href="/mana/majormanager?page=1";
                    }else if(data==-2){
                        alert("改专业已存在");
                    }else{
                        alert("添加失败，未知错误");
                    }
                }
            });
        }
    }
function deletemajor(mid) {
    console.log(mid);
    if (confirm("您确定要删除?")) {
        $.getJSON("/mana/deleteMajor?majorId=" + mid,
                function (data) {
                   if(data==1){
                       alert("删除成功");
                       window.location.reload();
                   }else{
                       alert("删除失败，未知错误");
                   }
                }
        );
    }
}
</script>
