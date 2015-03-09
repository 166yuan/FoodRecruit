
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>实验报名情况</title>

    <script type="text/javascript" src="/js/experiment/experimentUpdate.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/all.css" >
    <style type="text/css">
        .line-center{
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
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="/View/user/myspace.jsp">主页</a>
        </li>
        <li class="active">
            报名情况
        </li>
    </ul><!-- /.breadcrumb -->

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
    <h3 >
    实验名：${experName}
</h3>
    <h3 >
       招收人数：${number}
    </h3>
    <h3 >
        报名人数：${list.size()} / ${number}
    </h3>
</div>

<div class="main-container">

    <div class="col-xs-12">

        <div class="table-header">
            申请列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid"><table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
                <thead>
                <tr role="row"><th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="




													">
                    <label class="position-relative">
                        <input type="checkbox" class="ace">
                        <span class="lbl"></span>
                    </label>
                </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending">
                        <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                        申请时间
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending">姓名</th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">性别</th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">专业</th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">班级</th>
                    <th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">操作</th>
                </tr></thead>


                <tbody role="alert" aria-live="polite" aria-relevant="all">
                <c:forEach items="${list}" var="exper">
                <tr class="odd">
                    <td class="center  sorting_1">
                        <label class="position-relative">
                            <input type="checkbox" class="ace">
                            <span class="lbl"></span>
                        </label>
                    </td>

                    <td class=" ">${exper.appTime}</td>
                    <td class=" ">${exper.name}</td>
                    <c:choose>
                        <c:when test="${exper.gender==1}">
                            <td class="">男</td>
                        </c:when>
                        <c:otherwise>
                            <td class="">女</td>
                        </c:otherwise>
                    </c:choose>

                    <td class=" ">${exper.major}</td>
                    <td class=" ">${exper.classes}</td>
                    <td class=" ">
                        <c:choose>
                            <c:when test="${exper.isAgree==true}">
                                <button class="btn btn-xs btn-danger" onclick="refuse(${exper.experId},${exper.userId})">不招收</button>
                            </c:when>
                            <c:otherwise>
                               <button class="btn btn-xs btn-primary" onclick="agree(${exper.experId},${exper.userId})">招收</button>
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
</div>
      </div>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">
    function agree(eid,uid){
        $.get("/exper/employ?experId="+parseInt(eid)+"&userId="+parseInt(uid)+"&isAgree="+true,function(data,status){
            window.location.reload();
        });
    }
    function refuse(eid,uid){
        $.get("/exper/employ?experId="+eid+"&userId="+uid+"&isAgree="+false,function(data,status){
            window.location.reload();
        });
    }
</script>