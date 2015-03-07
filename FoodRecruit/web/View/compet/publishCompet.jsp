<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/2/24
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<head>
  <meta charset="UTF-8">
  <!-- 强制国内垃圾浏览器开启高速模式-->
  <meta name="renderer" content="webkit">
  <title>实验发布</title>
  <script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="/ueditor/ueditor.all.js"></script>

</head>
<html>
<body class="no-skin">
<!--导航栏-->

<!--导航栏结束-->
<!-- 主体部分-->
<c:import url="/View/common/header.jsp"/>
<div class="breadcrumbs" id="breadcrumbs">
  <script type="text/javascript">
    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
  </script>

  <ul class="breadcrumb">
    <li>
      <i class="ace-icon fa fa-home home-icon"></i>
      <a href="/View/user/myspace.jsp">主页</a>
    </li>
    <li class="active">竞赛发布</li>
  </ul><!-- /.breadcrumb -->

</div>

<div class="page-content">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <div class="page-header ">
        <h1 class="text-center">
          竞赛发布
        </h1>
      </div>
    </div>
  </div>
  <div class="row">
<form action="/compet/addCompet" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
  <div class="form-group">
    <label class="col-sm-4 control-label no-padding-right" >竞赛名称 </label>
    <div class="col-sm-8">
      <input type="text" id="name" name="name" placeholder="名称" class="col-xs-10 col-sm-5">
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label no-padding-right" >首页logo </label>
    <div class="col-sm-8">
      <input type="file"  name="file" >
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label no-padding-right" >队伍人数限制 </label>
    <div class="col-sm-4">
      <input type="text"  placeholder="最小人数" name="minnumber" class="col-xs-10 col-sm-5">

     <input type="text"  placeholder="最大人数" name="maxnumber" class="col-xs-10 col-sm-5">
    </div>
    <div class="col-sm-4"></div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label no-padding-right" >时间 </label>
    <div class="col-sm-8">
      <input type="text" name="daterange" id="id-date-range-picker-1" class="col-xs-10 col-sm-5"/>
      <small>手动修改请严格按照时间格式</small>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label no-padding-right" >竞赛内容 </label>
    <div class="col-sm-8">

    </div>
  </div>
  <div class="form-group">
    <div class="col-xs-1"></div>
    <div class="col-xs-10">
  <textarea name="description" id="ueditor"></textarea><br>
  <script>
    UE.getEditor('ueditor');
  </script>
  </div>
    <div class="col-xs-1"></div>
  </div>

  <div class="clearfix form-actions">
    <div class="col-md-offset-3 col-md-9">
      <button class="btn btn-info" type="submit">
        <i class="ace-icon fa fa-check bigger-110"></i>
        保存
      </button>

      &nbsp; &nbsp; &nbsp;
      <button class="btn" type="reset">
        <i class="ace-icon fa fa-undo bigger-110"></i>
        取消
      </button>
    </div>
  </div>
</form>
  </div>
</div>
<!-- 主体结束-->
<script type="text/javascript" src="/js/moment.min.js"></script>
<script type="text/javascript" src="/js/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/daterangepicker.css"/>
<script type="text/javascript">
  $(function() {
    //localization example for daterang picker
    //change moment.js language to French
    //example taken from: http://momentjs.com/docs/#/i18n/changing-language/
    moment.lang('fr', {
      months : "janvier_février_mars_avril_mai_juin_juillet_août_septembre_octobre_novembre_décembre".split("_"),
      monthsShort : "一月_二月_三月_四月_五月_六月_七月_八月_九月_十月_十一月_十二月".split("_"),
      weekdays : "dimanche_lundi_mardi_mercredi_jeudi_vendredi_samedi".split("_"),
      weekdaysShort : "dim._lun._mar._mer._jeu._ven._sam.".split("_"),
      weekdaysMin : "日_一_二_三_四_五_六".split("_"),
      longDateFormat : {
        LT : "HH:mm",
        L : "DD/MM/YYYY",
        LL : "D MMMM YYYY",
        LLL : "D MMMM YYYY LT",
        LLLL : "dddd D MMMM YYYY LT"
      },
      calendar : {
        sameDay: "[Aujourd'hui à] LT",
        nextDay: '[Demain à] LT',
        nextWeek: 'dddd [à] LT',
        lastDay: '[Hier à] LT',
        lastWeek: 'dddd [dernier à] LT',
        sameElse: 'L'
      },
      relativeTime : {
        future : "dans %s",
        past : "il y a %s",
        s : "quelques secondes",
        m : "une minute",
        mm : "%d minutes",
        h : "une heure",
        hh : "%d heures",
        d : "un jour",
        dd : "%d jours",
        M : "un mois",
        MM : "%d mois",
        y : "une année",
        yy : "%d années"
      },
      ordinal : function (number) {
        return number + (number === 1 ? 'er' : 'ème');
      },
      week : {
        dow : 1, // Monday is the first day of the week.
        doy : 4  // The week that contains Jan 4th is the first week of the year.
      }
    });

    //I've translated the following texts using Google Translate, so it may not be correct
    $('#id-date-range-picker-1').daterangepicker({
      locale : {
        applyLabel: '选择',
        clearLabel: 'Nettoyer',
        fromLabel: '起始',
        toLabel: '结束',
        weekLabel: 'W',
        customRangeLabel: 'Plage personnalisée',
        daysOfWeek: moment()._lang._weekdaysMin,
        monthNames: moment()._lang._monthsShort,
        firstDay: 0
      }
    })



    if(location.protocol == 'file:') alert("For retrieving data from server, you should access this page using a webserver.");
  });
</script>

</body>
</html>

