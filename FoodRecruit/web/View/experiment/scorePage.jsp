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
    <div class="row">
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
                                <form class="form-horizontal" id="sample-form">

                                    <div class="form-group">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-2"><label>责任心（<span style="color: #595cff">满分20分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner1" maxlength="3">
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
                                                           id="spinner2" maxlength="3">
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
                                                           id="spinner3" maxlength="3">
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
                                                           id="spinner4" maxlength="3">
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
                                                           id="spinner5" maxlength="3">
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
                                                           id="spinner6" maxlength="3">
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
                                                           id="spinner7" maxlength="3">
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
                                                           id="spinner8" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </form>

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
                                <div>
                                    <form class="form-horizontal" >
                                        <div class="form-group">
                                            <div class="col-xs-5"></div>
                                            <div class="col-xs-1"><label>请评分</label></div>
                                            <div class="col-xs-6">
                                                <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                    <div class="input-group">
                                                        <input type="text" class="input-mini spinner-input form-control"
                                                               id="spinner9" maxlength="3">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="step-pane" id="step3">
                                <div class="center"><h4 class="light-red">评分说明：科联负责人进行一次跟踪调查后评分，以下得分*20%+附加分</h4></div>

                                <form class="form-horizontal" >
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>注重整洁（<span style="color: #595cff">满分20分</span>）:优：（17-20）中（11-16）差（<11）</label></div>
                                        <div class="col-xs-6">
                                            <div class="ace-spinner touch-spinner" style="width: 100px;">
                                                <div class="input-group">
                                                    <input type="text" class="input-mini spinner-input form-control"
                                                           id="spinner10" maxlength="3">
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
                                                           id="spinner11" maxlength="3">
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
                                                           id="spinner12" maxlength="3">
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
                                                           id="spinner13" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>是否主动联系科联负责人备案（<span style="color: #595cff">20分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <label>
                                                <input name="status1" type="radio" class="ace">
                                                <span class="lbl">是</span>
                                            </label>
                                            <label>
                                                <input name="status1" type="radio" class="ace">
                                                <span class="lbl">否</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-1"></div>
                                        <div class="col-xs-5"><label>是否成为科联会员（<span style="color: #595cff">10分</span>）</label></div>
                                        <div class="col-xs-6">
                                            <label>
                                                <input name="status2" type="radio" class="ace">
                                                <span class="lbl">是</span>
                                            </label>
                                            <label>
                                                <input name="status2" type="radio" class="ace">
                                                <span class="lbl">否</span>
                                            </label>
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
                                                           id="spinner14" maxlength="3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <div class="step-pane" id="step4">
                                <div class="center">
                                    <h3 class="green">评分完成!</h3>
                                   您可以查看并修改结果，或者继续评分。
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

<script type="text/javascript">
    $(document).ready(function () {
        $('#spinner1').ace_spinner({
            value: 0,
            min: 0,
            max: 20,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner2').ace_spinner({
            value: 0,
            min: 0,
            max: 20,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner3').ace_spinner({
            value: 0,
            min: 0,
            max: 15,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner4').ace_spinner({
            value: 0,
            min: 0,
            max: 15,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner5').ace_spinner({
            value: 0,
            min: 0,
            max: 10,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner6').ace_spinner({
            value: 0,
            min: 0,
            max: 10,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner7').ace_spinner({
            value: 0,
            min: 0,
            max: 10,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });

        $('#spinner8').ace_spinner({
            value: 0,
            min: 0,
            max: 5,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });

        $('#spinner9').ace_spinner({
            value: 0,
            min: 0,
            max: 100,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner10').ace_spinner({
            value: 0,
            min: 0,
            max: 20,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner11').ace_spinner({
            value: 0,
            min: 0,
            max: 20,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner12').ace_spinner({
            value: 0,
            min: 0,
            max: 15,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner13').ace_spinner({
            value: 0,
            min: 0,
            max: 15,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
        $('#spinner14').ace_spinner({
            value: 0,
            min: 0,
            max: 5,
            step: 1,
            on_sides: true,
            icon_up: 'ace-icon fa fa-plus smaller-75',
            icon_down: 'ace-icon fa fa-minus smaller-75',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger'
        });
    });
</script>

<script type="text/javascript">
    jQuery(function($) {

        $('[data-rel=tooltip]').tooltip();

        $(".select2").css('width','200px').select2({allowClear:true})
                .on('change', function(){
                    $(this).closest('form').validate().element($(this));
                });


        var $validation = false;
        $('#fuelux-wizard')
                .ace_wizard({
                    //step: 2 //optional argument. wizard will jump to step "2" at first
                })
                .on('change' , function(e, info){
                    if(info.step == 1 && $validation) {
                        if(!$('#validation-form').valid()) return false;
                    }
                })
                .on('finished', function(e) {
                    bootbox.dialog({
                        message: "Thank you! Your information was successfully saved!",
                        buttons: {
                            "success" : {
                                "label" : "OK",
                                "className" : "btn-sm btn-primary"
                            }
                        }
                    });
                }).on('stepclick', function(e){
                    //e.preventDefault();//this will prevent clicking and selecting steps
                });


        //jump to a step
        $('#step-jump').on('click', function() {
            var wizard = $('#fuelux-wizard').data('wizard')
            wizard.currentStep = 3;
            wizard.setState();
        })
        //determine selected step
        //wizard.selectedItem().step



        //hide or show the other form which requires validation
        //this is for demo only, you usullay want just one form in your application
        $('#skip-validation').removeAttr('checked').on('click', function(){
            $validation = this.checked;
            if(this.checked) {
                $('#sample-form').hide();
                $('#validation-form').removeClass('hide');
            }
            else {
                $('#validation-form').addClass('hide');
                $('#sample-form').show();
            }
        })

        //documentation : http://docs.jquery.com/Plugins/Validation/validate


        $.mask.definitions['~']='[+-]';
        $('#phone').mask('(999) 999-9999');

        jQuery.validator.addMethod("phone", function (value, element) {
            return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
        }, "Enter a valid phone number.");

        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                email: {
                    required: true,
                    email:true
                },
                password: {
                    required: true,
                    minlength: 5
                },
                password2: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                },
                name: {
                    required: true
                },
                phone: {
                    required: true,
                    phone: 'required'
                },
                url: {
                    required: true,
                    url: true
                },
                comment: {
                    required: true
                },
                date: {
                    required: true,
                    date: true
                },
                state: {
                    required: true
                },
                platform: {
                    required: true
                },
                subscription: {
                    required: true
                },
                gender: 'required',
                agree: 'required'
            },

            messages: {
                email: {
                    required: "Please provide a valid email.",
                    email: "Please provide a valid email."
                },
                password: {
                    required: "Please specify a password.",
                    minlength: "Please specify a secure password."
                },
                subscription: "Please choose at least one option",
                gender: "Please choose gender",
                agree: "Please accept our policy"
            },


            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
                $(e).remove();
            },

            errorPlacement: function (error, element) {
                if(element.is(':checkbox') || element.is(':radio')) {
                    var controls = element.closest('div[class*="col-"]');
                    if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                }
                else if(element.is('.select2')) {
                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                }
                else if(element.is('.chosen-select')) {
                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                }
                else error.insertAfter(element.parent());
            },

            submitHandler: function (form) {
            },
            invalidHandler: function (form) {
            }
        });
    })
</script>
