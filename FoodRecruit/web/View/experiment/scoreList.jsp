<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>实验员评分</title>

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
            <a href="/View/user/myspace.jsp">主页</a>
        </li>
        <li class="active">
            评分列表
        </li>
    </ul>
    <!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<!--main content-->
<div class="page-content">
    <div class="page-header">
        <h1>
            实验评分
        </h1>
    </div>

</div>
<div class="line-center">
    <h3>
        实验名：${experName}
    </h3>
</div>

<div class="main-container">

    <div class="col-xs-12">

        <div class="table-header">
            参与者列表
        </div>

        <!-- <div class="table-responsive"> -->

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
                            colspan="1" aria-label="Clicks: activate to sort column ascending">分数
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                            colspan="1" aria-label="Clicks: activate to sort column ascending">评分状态
                        </th>
                        <th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2"
                            rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">操作
                        </th>
                    </tr>
                    </thead>


                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                    <c:forEach items="${list}" var="paticipater">
                        <tr class="odd">
                            <td class="center  sorting_1">
                                <label class="position-relative">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </td>

                            <td class=" ">${paticipater.name}</td>
                            <c:choose>
                                <c:when test="${paticipater.gender==1}">
                                    <td class="">男</td>
                                </c:when>
                                <c:otherwise>
                                    <td class="">女</td>
                                </c:otherwise>
                            </c:choose>

                            <td class=" ">${paticipater.major}</td>
                            <td class=" ">${paticipater.classes}</td>
                            <td class=" ">90分</td>
                            <td class=" ">
                                <c:choose>
                                    <c:when test="${paticipater.isEvaluate==true}">
                                        <span class="label label-sm label-success">评分完成</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-sm label-warning">未评分</span>
                                    </c:otherwise>
                                </c:choose>

                            </td>
                            <td>
                                <a class="btn btn-info btn-xs" href="/score/scorePage?experId=${paticipater.experId}&userId=${paticipater.userId}&experName=${experName}&userName=${paticipater.name}">去评分</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

                <div class="row">
                    <!--这里分页-->
                </div>
                <!-- main content end-->
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

</script>