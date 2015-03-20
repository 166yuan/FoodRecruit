<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>实验管理</title>
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

<c:import url="header.jsp"/>

<div class="col-xs-12" >
    <h3 class="header smaller lighter blue">实验管理</h3>
    <div class="table-header">
        查询结果按时间先后顺便排列
    </div>

    <!-- <div class="table-responsive"> -->

    <!-- <div class="dataTables_borderWrap"> -->
    <div>
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="row">

                <div class="col-xs-6">
                    <div class="ui-pg-div"><span class="label label-lg label-success arrowed-right">新增实验</span><a href="/exper/publish" target="_blank"><span
                            class="ui-icon ace-icon fa fa-plus-circle purple" id="addclass"></span></a></div>
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
                        colspan="1" aria-label="Domain: activate to sort column ascending">实验名称
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">发布时间
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">实验时间
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">编辑
                    </th>
                </tr>
                </thead>


                <tbody role="alert" aria-live="polite" aria-relevant="all">
                <c:forEach items="${list}" var="exper">
                    <tr class="odd">
                        <td class="center  sorting_1">
                            <label class="position-relative">
                                <input type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        </td>

                        <td class=" ">
                            <a>${exper.id}</a>
                        </td>
                        <td class=" "><a href="/exper/showExper?id=${exper.id}&from=mana">${exper.name}</a></td>
                        <td class=" ">${exper.createTime}</td>
                        <td class=""><fmt:formatDate  value="${exper.beginTime}"  pattern="yyyy年MM月dd日" />——<fmt:formatDate  value="${exper.endTime}"  pattern="yyyy年MM月dd日" /></td>
                        <td class=" ">
                            <div class="hidden-sm hidden-xs action-buttons">
                                <a class="green" href="/compet/update?id=${exper.id}">
                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                </a>

                                <a class="red" href="#" onclick="">
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
        $('#experpage').addClass('active');
    });
    function deleteCompet(id){
        $.ajax({
            url:"/compet/delete",
            type:"get",
            dataType:"text",
            data:{"id":id},
            success:function(data){
                var result = parseInt(data);
                if(result==1){
                    alert("删除成功");
                    window.location.reload();
                }else{
                    alert("删除失败，未知错误");
                }
            }

        });
    }
</script>

