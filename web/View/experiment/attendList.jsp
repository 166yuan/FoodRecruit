<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>实验报名情况</title>

    <script type="text/javascript" src="/js/experiment/experimentUpdate.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/all.css">
    <style type="text/css">
        .line-center {
            text-align: center;
        }
    </style>
</head>
<body class="no-skin">

<!--导航栏开始-->
<c:import url="/View/common/header.jsp"/>
<!--导航栏结束-->

<!-- 面包屑-->
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try {
            ace.settings.check('breadcrumbs', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="/user/home">主页</a>
        </li>
        <li class="active">
            报名情况
        </li>
    </ul>
    <!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<!--main content-->
<div class="page-content">
    <div class="page-header">
        <h1>
            报名情况
        </h1>
    </div>

</div>
<div class="line-center">
    <h3>
        实验名：${experName}
    </h3>

    <h3>
        招收人数：${number}
    </h3>

    <h3>
        报名人数：${list.size()} / ${number}
    </h3>
</div>

<div class="main-container">

    <div class="col-xs-12">

        <div class="table-header">
            申请列表
        </div>

        <!-- <div class="table-responsive"> -->
        <div class="row">
            <div class="col-xs-3"></div>
            <div class="col-xs-3">
                <button class="btn btn-info btn-primary" onclick="acceptAll()">招收以下所选</button>
            </div>
            <div class="col-xs-3">
                <button class="btn btn-warning btn-primary" onclick="cancelAll()">取消以下所选</button>
            </div>
            <div class="col-xs-3"></div>
        </div>
        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
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
                            colspan="1" aria-label="Update: activate to sort column ascending">
                            <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                            申请时间
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
                        <th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2"
                            rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">操作
                        </th>
                    </tr>
                    </thead>


                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                        <c:forEach items="${list}" var="eu">
                        <tr class="odd">
                            <td class="center  sorting_1">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <input type="hidden" value="${eu.id}" class="hidden-id">
                            <td class=" "><fmt:formatDate value="${eu.createTime}" pattern="yyyy年MM月dd日 hh:MM"/></td>
                            <td class=" ">${eu.user.name}</td>
                            <c:choose>
                                <c:when test="${eu.user.gender==true}">
                                    <td class=" ">男</td>
                                </c:when>
                                <c:when test="${eu.user.gender==false}">
                                    <td class=" ">女</td>
                                </c:when>
                                <c:otherwise>
                                    <td class="">保密</td>
                                </c:otherwise>
                            </c:choose>
                            <td class=" ">${eu.user.major.majorName}</td>
                            <td class=" ">${eu.user.classes.className}</td>
                            <td class=" ">
                                <c:choose>
                                    <c:when test="${eu.isAgree==true}">
                                        <span class="label label-sm label-success">招收</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-sm label-danger">未招收</span>
                                    </c:otherwise>
                                </c:choose>


                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>

                </table>

                <div class="row">
                    <!--这里分页-->
                </div>
                <!-- main content end-->
                <br>
                <div class="center"><button class="btn btn-info">保存并通知</button></div>
                <div class="center"><span><strong>仅有保存了实验员才能收到通知</strong></span></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    function agree(eid, uid) {
        $.get("/exper/employ?experId=" + parseInt(eid) + "&userId=" + parseInt(uid) + "&isAgree=" + true, function (data, status) {
            window.location.reload();
        });
    }
    function refuse(eid, uid) {
        $.get("/exper/employ?experId=" + eid + "&userId=" + uid + "&isAgree=" + false, function (data, status) {
            window.location.reload();
        });
    }
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
                        var dom= $(this).parents(".odd").find('.hidden-id').val();
                        $.get("/experUser/acceptUser?euid="+dom
                                ,function(data){
                                }
                        );
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
                        var dom= $(this).parents(".odd").find('.hidden-id').val();
                        $.get("/experUser/cancelUser?euid="+dom
                                ,function(data){
                                }
                        );
                    }
                }
        );
        alert("操作成功");
        window.location.reload();
    }
</script>