/**
 * Created by Mklaus on 15/2/1.
 */

$(document).ready(function(){

});

function apply(){
    var experId = $("#experId").val();

    console.log(experId);
    $.ajax({
        url:"/experUser/join",
        type:"post",
        dataType:"text",
        data:{"experId":experId},
        success:function(data){
            var result = parseInt(data);
            if(result == 1){
                alert("申请成功");
            }else{
                alert("未知错误");
            }
        }
    });

    return;
}