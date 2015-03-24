/**
 * Created by Mklaus on 15/1/30.
 */

$(document).ready(function(){

    var passForm = $("#pass-form");
    passForm.onsubmit = submitPassForm;
});

function submitPassForm(){
    var password = document.getElementById("form-field-pass1").value;
    var newPass  = $("#form-field-pass2").val();
    var repeat   = $("#form-field-pass3").val();

    if(password.length <= 0 || newPass.length <= 0) {
        $("#passwd-message").html("<p style='color: red'>原密码和新密码不能为空</p>");
        return false;
    }

    if(newPass != repeat){
        $("#passwd-message").html("<p style='color: red'>两次新密码不相同</p>");
        return false;
    }

    $.ajax({
        url:"/user/passwd",
        type:"post",
        dataType:"text",
        data:{"password":password,"newPass":newPass},
        success:function(data){
            var result = parseInt(data);
            if(result == 1){
                alert("modify success.");
                window.location.reload();
            }else{
                $("#passwd-message").html("<p style='color: red'>密码不正确</p>");
                return false;
            }
        }
    });

    return false;
}


function submitProfileForm(){
    var name    = $("#form-field-name").val();
    var major   = $("#major option:selected").val();
    var classes = $("#classes option:selected").val();
    var radio   = document.getElementsByName("form-field-radio");
    var gender;
    if(radio[1].checked == true){
        gender = false;
    }else{
        gender=true;
    }
    console.log(gender);
    var self_info = $("#form-field-comment").val();
    var email     = $("#form-field-email").val();
    var phone     = $("#form-field-phone").val();
    var QQ        = $("#form-field-QQ").val();

    var jsonData = {"name":name,"major":major,"classes":classes,"gender":gender,
    "self_info":self_info,"email":email,"phone":phone,"QQ":QQ};

    var data = JSON.stringify(jsonData);

    $.ajax({
        url:"/user/updateProfile",
        type:"post",
        dataType:"text",
        contentType:"json",
        data:data,
        success:function(data){
            var result = parseInt(data);
            if(result == 1){
                alert("modify success");
                window.location.reload();
            }else{
                alert("未知错误!");
            }
        }
    });

    return false;
}

function uploadFile(file){
  var docObj=document.getElementById("upfile");
  var imgPreview=document.getElementById("preview");
    if(docObj.files&&docObj.files[0]){
        imgPreview.style.display="block";
        imgPreview.style.width='150px';
        imgPreview.style.height='150px';
        imgPreview.src=window.URL.createObjectURL(docObj.files[0]);
    }else{
        docObj.select();
        var imgSrc=document.selection.createRange().text;
    }
    $('.ace-file-container').hide();
}