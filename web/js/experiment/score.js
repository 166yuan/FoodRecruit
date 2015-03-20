/**
 * Created by Administrator on 2015/3/10.
 */

/* spinner初始化*/
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
/* wizard初始化 */
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

function scoreA(){
    var duty= $('input[name="duty"]').val();
    var discipline= $('input[name="discipline"]').val();
    var tidy= $('input[name="tidy"]').val();
    var care= $('input[name="care"]').val();
    var operation= $('input[name="operation"]').val();
    var fault= $('input[name="fault"]').val();
    var efficiency= $('input[name="efficiency"]').val();
    var advise= $('input[name="advise"]').val();
    var experId=$('input[name="experId"]').val();
    var userId=$('input[name="userId"]').val();
    var data = {"duty":duty,"discipline":discipline,"tidy":tidy,"care":care,"operation":operation,"fault":fault,
    "efficiency":efficiency,"advise":advise,"experId":experId,"userId":userId
    };

    $.ajax({
        url:"/score/saveScoreA",
        type:"get",
        dataType:"text",
        data:data,
        success:function(data){
            var result = parseInt(data);
            if(result == 1){
                alert("保存成功");
            }else{
                alert("未知错误");
            }
        }
    });

}

function scoreB(){
    var scoreB= $('input[name="scoreB"]').val();
    var experId=$('input[name="experId"]').val();
    var userId=$('input[name="userId"]').val();
    $.ajax({
        url:"/score/saveScoreB",
        type:"get",
        dataType:"text",
        data:{"scoreB":scoreB,"experId":experId,"userId":userId},
        success:function(data){
            var result = parseInt(data);
            if(result == 1){
                alert("保存成功");
            }else{
                alert("未知错误");
            }
        }
    });
}

function scoreC(){
    var Ttidy=$('input[name="Ttidy"]').val();
    var Tcare=$('input[name="Tcare"]').val();
    var Toperation=$('input[name="Toperation"]').val();
    var Tconnect=$('input[name="Tconnect"]').val();
    var member=$('input[name="member"]:checked').val();
    var recorded=$('input[name="recorded"]:checked').val();
    var append=$('input[name="append"]').val();
    var experId=$('input[name="experId"]').val();
    var userId=$('input[name="userId"]').val();
    console.log(member);
    console.log(recorded);
    $.ajax({
        url:"/score/saveScoreC",
        type:"get",
        dataType:"text",
        data:{"experId":experId,"userId":userId,"Toperation":Toperation,"Ttidy":Ttidy,"Tcare":Tcare,"Tconnect":Tconnect,"member":member,
        "recorded":recorded,"append":append},
        success:function(data){
            var result = parseInt(data);
            if(result == 1){
                alert("保存成功");
            }else{
                alert("未知错误");
            }
        }
    });
}