<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>评分页</title>
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
            <a href="/View/user/myspace.jsp">主页${from}</a>
        </li>
        <li>
            <c:choose>
                <c:when test="${from == 'me'}">
                    <a href="/exper/myPublishExperiment">已发布实验</a>
                </c:when>
                <c:when test="${from == 'myInvolve'}">
                    <a href="#">我参与的实验</a>
                </c:when>
                <c:otherwise>
                    <a href="/exper/nendAssistant">成为实验助手</a>
                </c:otherwise>
            </c:choose>
        </li>
        <li class="active" id="smallTitle">${exper.name}</li>
    </ul>
    <!-- /.breadcrumb -->

</div>
<!-- 面包屑结束-->
<div class="page-content">
    <div class="center">
        <h5>实验名：${experName}</h5>
        <h5>实验员：${userName}<c:if test="${score.total!=null}">，总分 ：${score.total}</c:if></h5>
    </div>
    <div class="row">
        <input type="hidden" name="experId" value="${score.exper_id}">
        <input type="hidden" name="userId" value="${score.userId}">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->


            <div class="hr hr-18 hr-double dotted"></div>

            <div class="widget-box">
                <div class="widget-header widget-header-blue widget-header-flat">
                    <h4 class="widget-title lighter">实验评分</h4>


                </div>

                <div class="widget-body">
                    <div class="widget-main">
                        <div id="fuelux-wizard" data-target="#step-container">
                            <ul class="wizard-steps">
                                <li data-target="#step1" class="active">
                                    <span class="step">1</span>
                                    <span class="title">评分项A</span>
                                </li>

                                <li data-target="#step2">
                                    <span class="step">2</span>
                                    <span class="title">评分项B</span>
                                </li>

                                <li data-target="#step3">
                                    <span class="step">3</span>
                                    <span class="title">追加评分</span>
                                </li>

                                <li data-target="#step4">
                                    <span class="step">4</span>
                                    <span class="title">评分完成</span>
                                </li>
                            </ul>

                            <!-- /section:plugins/fuelux.wizard.steps -->
                        </div>

                        <hr>

                        <!-- #section:plugins/fuelux.wizard.container -->
                        <div class="step-content pos-rel" id="step-container">

                            <div class="step-pane active" id="step1">
                                <p class="alert alert-success">
                                    一、实验员的评价根据在实验过程中的表现进行评分，以下两项得分取平均值后*80%：
                                </p>
                                <c:if test="${score.scoreA!=null}"><div class="center"><h3>评分完毕，该项得分为：${score.scoreA}</h3></div></c:if>
                                <form class="form-horizontal" id="sample-form">

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>责任心（<span style="color: #595cff">满分20分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner1" name="duty"  value="${score.duty}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>准时，有纪律（<span style="color: #595cff">满分20分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner2" value="${score.discipline}" name="discipline" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>注重整洁（<span style="color: #595cff">满分15分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner3"name="tidy" value="${score.tidy}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>细心，注重细节（<span style="color: #595cff">满分10分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner4" name="care" value="${score.care}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>操作规范，严谨（<span style="color: #595cff">满分10分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner5" name="operation" value="${score.operation}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>改错，态度端正（<span style="color: #595cff">满分10分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner6" name="fault" value="${score.fault}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>高效率完成（<span style="color: #595cff">满分10分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner7" name="efficiency" value="${score.efficiency}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>对实验提出建议（<span style="color: #595cff">满分5分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner8" name="advise" value="${score.advise}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                           <div class="center"> <button class="btn btn-info" onclick="scoreA()">保存A项评分</button></div>
                            </div>

                            <div class="step-pane" id="step2">
                                <h3 class="lighter block green">B项评价标准</h3>
                                <p class="alert alert-info">
                                  <span style="color: #ff0000;font-size: larger">评分范围：80~100</span>  &nbsp;:责任心强，做实验细心，有想法。主动请求任务，实验后自觉清理实验用具。每次准时到，不迟不旷
                                </p>
                                <p class="alert alert-info">
                                    <span style="color: #ff0000;font-size: larger">评分范围：50~80</span>  &nbsp;: 比较有责任感，有缺席或迟到，但情况不严重，做实验偶尔出点小岔子，经提醒后能较好地完成任务
                                </p>
                                <p class="alert alert-info">
                                    <span style="color: #ff0000;font-size: larger">评分范围：0~50</span>   &nbsp;:经常缺席且没请假，被动接受任务，不善于思考，手脚笨拙，越帮越忙的，屡教不改
                                </p>
                                <c:if test="${score.scoreB!=null}"><div class="center"><h3>评分完毕，该项得分为：${score.scoreB}</h3></div></c:if>
                                <div>
                                    <form class="form-horizontal" >
                                        <div class="form-group">
                                            <div class="col-xs-5"></div>
                                            <div class="col-xs-1"><label>请评分</label></div>
                                            <div class="col-xs-6">
                                                <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                    <div class="input-group">
                                                        <input type="text" class="input-mini spinner-input form-control"
                                                               id="spinner9" value="${score.scoreB}" name="scoreB" maxlength="3">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="center"><button class="btn btn-info" onclick="scoreB()">保存B项评分</button></div>
                            </div>

                            <div class="step-pane" id="step3">
                                <div class="center"><h4 class="light-red">评分说明：科联负责人进行一次跟踪调查后评分，以下得分*20%+附加分</h4></div>
                                <c:if test="${score.secscore!=null}"><div class="center"><h3>评分完毕，该项得分为：${score.secscore}(不含附加分)</h3></div></c:if>
                                <form class="form-horizontal" >
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>注重整洁（<span style="color: #595cff">满分20分</span>）:优：（17-20）中（11-16）差（<11）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner10" value="${score.ttidy}" name="Ttidy" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>细心，爱惜仪器（<span style="color: #595cff">满分20分</span>）:优：（17-20）中（11-16）差（<11）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner11" value="${score.tcare}" name="Tcare" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>操作规范，严谨（<span style="color: #595cff">满分15分</span>）:优：（13-15）中（10-14）差（<10）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner12" name="Toperation" value="${score.toperation}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>积极与实验员联系（<span style="color: #595cff">满分15分</span>）:优：（13-15）中（10-14）差（<10）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner13" name="Tconnect" value="${score.tconnect}" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>是否主动联系科联负责人备案（<span style="color: #595cff">20分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <c:choose>
                                                <c:when test="${score.recorded==20}">
                                                    <label>
                                                        <input name="recorded" type="radio" class="ace" value="20" checked="true">
                                                        <span class="lbl">是</span>
                                                    </label>
                                                    <label>
                                                        <input name="recorded" type="radio" class="ace" value="0" >
                                                        <span class="lbl">否</span>
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>
                                                        <input name="recorded" type="radio" class="ace" value="20">
                                                        <span class="lbl">是</span>
                                                    </label>
                                                    <label>
                                                        <input name="recorded" type="radio" class="ace" value="0" checked="true">
                                                        <span class="lbl">否</span>
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>是否成为科联会员（<span style="color: #595cff">10分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <c:choose>
                                                <c:when test="${score.member==10}">
                                                    <label>
                                                        <input name="member" type="radio" class="ace" value="10" checked="true">
                                                        <span class="lbl">是</span>
                                                    </label>
                                                    <label>
                                                        <input name="member" type="radio" class="ace" value="0" >
                                                        <span class="lbl">否</span>
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>
                                                        <input name="member" type="radio" class="ace" value="10">
                                                        <span class="lbl">是</span>
                                                    </label>
                                                    <label>
                                                        <input name="member" type="radio" class="ace" value="0" checked="true">
                                                        <span class="lbl">否</span>
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                     <div class="center"><h5 class="light-red">以下是附加分</h5></div>
                                    <div class="form-group">
                                        <div class="col-xs-2"></div>
                                        <div class="col-xs-4"><label>一学期参加多次实验（<span style="color: #595cff">1分/次，最多5分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner14" value="${score.append}" name="append" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <div class="center"><button class="btn btn-info" onclick="scoreC()">保存C项评分</button></div>
                            </div>

                            <div class="step-pane" id="step4">
                                <div class="center">
                                    <h3 class="green">评分完成!</h3>
                                 <span style="font-size: larger">  您可以查看并修改结果，或者
                                    <a href="/exper/scoreList?experId=${score.exper_id}" target="_blank">继续评分</a></span>
                                </div>
                            </div>
                        </div>

                        <!-- /section:plugins/fuelux.wizard.container -->
                        <hr>
                        <div class="wizard-actions">
                            <!-- #section:plugins/fuelux.wizard.buttons -->
                            <button class="btn btn-prev" disabled="disabled">
                                <i class="ace-icon fa fa-arrow-left"></i>
                                上一项
                            </button>

                            <button class="btn btn-success btn-next" data-last="Finish">
                                下一项
                                <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                            </button>

                            <!-- /section:plugins/fuelux.wizard.buttons -->
                        </div>

                        <!-- /section:plugins/fuelux.wizard -->
                    </div>
                    <!-- /.widget-main -->
                </div>
                <!-- /.widget-body -->
            </div>

        </div>
        <!-- /.col -->
    </div>

</div>
<c:import url="/View/common/footer.jsp"/>
</body>
</html>
<script type="text/javascript" src="/js/ace-extra.min.js"></script>
<script type="text/javascript" src="/js/fuelux.spinner.min.js"></script>
<script type="text/javascript" src="/js/ace-elements.min.js"></script>
<script type="text/javascript" src="/js/ace.min.js"></script>
<script type="text/javascript" src="/js/fuelux.wizard.min.js"></script>
<script type="text/javascript" src="/js/select2.min.js"></script>
<script type="text/javascript" src="/js/experiment/score.js"></script>