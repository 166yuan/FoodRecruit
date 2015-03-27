<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <!-- 强制国内垃圾浏览器开启高速模式-->
    <meta name="renderer" content="webkit">
    <title>操作一览</title>
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
    <h3 class="header smaller lighter blue">操作一览</h3>
    <div class="table-header">
        查询结果按时间先后顺便排列
    </div>

    <!-- <div class="table-responsive"> -->

    <!-- <div class="dataTables_borderWrap"> -->
    <div>
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="row">
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
                        colspan="1" aria-label="Domain: activate to sort column ascending">发布时间
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">内容
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1"
                        colspan="1" aria-label="Domain: activate to sort column ascending">编辑
                    </th>
                </tr>
                </thead>


                <tbody role="alert" aria-live="polite" aria-relevant="all">
                <c:forEach items="${list}" var="log">
                    <tr class="odd">
                        <td class="center  sorting_1">
                            <label class="position-relative">
                                <input type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        </td>

                        <td class=" ">
                            <a>${log.id}</a>
                        </td>
                        <td class=""><fmt:formatDate  value="${log.createTime}"  pattern="yyyy年MM月dd日 HH:mm" /></td>
                       <td>${log.info}</td>
                        <td class=" ">
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
<br>
<br>
<br>
</body>
</html>
</html>
<script type="text/javascript">
    $(document).ready(function(){
        $('#oppage').addClass('active');
    });

</script>

