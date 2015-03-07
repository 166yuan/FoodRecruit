<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>
    竞赛报名
  </title>
  <link rel="stylesheet" type="text/css" href="/css/link.css">
  <link rel="stylesheet" type="text/css" href="/css/topbar.css" >
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.min.css" >
  <link rel="stylesheet" type="text/css" href="/css/jingmain.css" >
  <link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css">
  <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/jquery-ui.min.js"></script>
</head>
<body>
<div id="container">
  <div class="header-wrap" style="height: 140px;!important;">
    <header>
      <img src="/images/logo.gif"/>
    </header>
  </div>
  <div id="last-p"></div>
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
        竞赛报名
      </li>
    </ul><!-- /.breadcrumb -->

  </div>
  <div class="clear-area">
    <div class="alert alert-info" role="alert">
    您将参与竞赛&nbsp;<strong>${competition.name}</strong>
  </div>
  </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-1">

        </div>
        <div class="col-lg-10">
          <ul class="nav nav-pills nav-justified">
            <li role="presentation" class="active" id="leader"><a href="#">以队长参加</a></li>
            <li role="presentation" id="member"><a href="#" >以队员参加</a></li>
          </ul>
          <hr>
          <div class="show">
            <form id="new" class="form-horizontal" action="/compet/newteam">
              <input type="hidden" name="comId"  id="comid" value="${competition.id}"/>
              <div class="form-group">
                <label class="col-sm-4 control-label">队伍名称</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="name" id="name" placeholder="队伍名称">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">队伍最大人数限制</label>
                <div class="col-sm-4">
                  <select class="form-control" name="number" id="type">
                    <c:forEach var="i" begin="${competition.minNumber}" end="${competition.maxNumber}" step="1">
                      <option value="${i}"><c:out value="${i}"/></option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">队伍口号</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="slogan"  placeholder="口号">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-4 control-label">入队密码</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="password"  placeholder="入队密码">
                </div>
              </div>

              <div class="form-group">
                <div class="col-sm-6"></div>
                <button type="submit" class="btn btn-primary">下一步</button>
              </div>
            </form>
           <form id="join" class="form-horizontal">
             <div class="form-group">
               <label class="col-sm-4 control-label">请输入队伍名称</label>
               <div class="col-sm-4">
                 <input id="search" type="text" class="form-control ui-autocomplete-input" placeholder="队伍名称" autocomplete="off">
               </div>
             </div>
             <div class="form-group">
               <label class="col-sm-4 control-label">请输入密码（由队长决定）</label>
               <div class="col-sm-4">
                 <input type="text" class="form-control" id="enpassword" name="password"  placeholder="入队密码">
               </div>
             </div>
             <div class="form-group">
               <div class="col-sm-6"></div>
               <button type="button" id="joinTeam" class="btn btn-primary">下一步</button>
             </div>
           </form>
          </div>
        </div>
        <div class="col-lg-1">

        </div>
      </div>
    </div>

  <footer> ©：华南农业大学食品学院    </footer>
</div>

</body>
</html>

<script type="text/javascript">
  $(document).ready(function(){
      $("#join").hide();
    $("#member").click(function(){
      $("#leader").removeClass("active");
      $("li#member").addClass("active");
      $('#new').hide();
      $('#join').show();
    });

    $("#leader").click(function() {
        $("li#leader").addClass("active");
        $("li#member").removeClass("active");
        $("#new").show();
        $("#join").hide();
    });
      var comid=document.getElementById('comid').value;
      var ava=new Array();
      $.get("/compet/getTeamNames?id="+parseInt(comid),function(data){
          var arr=eval(data);
          for(var i=0;i<arr.length;i++)
          {
              ava.push(arr[i].name);
          }
      });
    $( "#search" ).autocomplete({
      source: ava
    });
     $('#joinTeam').click(function(){
            var comId=document.getElementById('comid').value;
            var teamName=document.getElementById('search').value;
            var password=document.getElementById('enpassword').value;
                 $.get("/compet/joinTeam?name="+teamName+"&password="+password+"&comId="+comId,function(data){
                    if(data==1){
                        alert("报名成功！");
                        window.location.href="../View/compet/attendSuccess.jsp";
                    }else if(data==-1){
                        alert("队伍不存在，请检查拼写")
                    }else if(data==-2){
                        alert("入队密码不正确");
                    }else if(data==-3){
                        alert("该队人数已满");
                    }else if(data==-4){
                        alert("您已经报名了，请勿重复报名");
                    }
                 });
             }
     );
  });
</script>