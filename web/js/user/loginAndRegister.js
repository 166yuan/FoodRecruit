/**
 * Created by Mklaus on 15/1/28.
 */

var flag=false;

$(document).ready(function() {
    var registerForm      = document.getElementById("register");
    registerForm.onsubmit = submitRegisterForm;
    var loginForm         = document.getElementById("login");
    loginForm.onsubmit    = submitLoginForm;
});


function submitRegisterForm(){
    var account  = document.getElementById("register-account").value;
    var password = document.getElementById("register-password").value;
    var repeat   = document.getElementById("repeat").value;
    var result   = 0;

    if (account.length <=0 || password.length <= 0) {
        $("#register-message").html("<p style='color: red'>帐号和密码不能为空</p>");
        return false;
    }

    if(repeat != password){
        $("#register-message").html("<p style='color: red'>两次密码不一致</p>");
        return false;
    }

    if(!flag){
        flag=true;
        $.ajax({
            url:"/user/register",
            type:"post",
            dataType:"text",
            data:{"account":account,"password":password},
            success:function(data){
                result = parseInt(data);
                if(result == -1) {
                    var message = $("#register-message");
                    message.html("<p style='color: red'>帐号已存在</p>");
                    return false;
                }else if(result == 1){
                    window.location.href = "/View/user/regSuccess.jsp";
                }
            }

        });

    }else{
alert("请勿重复提交");
    }

    return false;
}


function submitLoginForm(){

    var account  = document.getElementById("login-account").value;
    var password = document.getElementById("login-password").value;

    if (account.length <=0 || password.length <= 0) {
        $("#login-message").html("<p style='color: red'>帐号和密码不能为空</p>");
        return false;
    }

    $.ajax({
        url:"/user/doLogin",
        type:"post",
        dataType:"text",
        data:{"account":account,"password":password},
        success:function(data){
            var result = parseInt(data);
            if(result==3){
                window.location.href = "/user/home";
            }else
            if(result == -1) {
                var message = $("#login-message");
                message.html("<p style='color: red'>帐号或密码错误</p>");
                return false;
            }else if(result == -2) {
                var message = $("#login-message");
                message.html("<p style='color: red'>帐号未通过审核或被冻结，请联系管理员</p>");
                return false;
            }else if(result == 2){
                window.location.href = "/mana/index?page=1";
            }else if(result == 1){
                window.location.href = "/user/home";
            }
        }

    });

    return false;
}
