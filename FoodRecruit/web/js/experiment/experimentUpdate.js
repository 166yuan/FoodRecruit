/**
 * Created by Mklaus on 15/2/3.
 */
function update(){

    var name          = document.getElementById("name").value;
    var content       = document.getElementById("content").value;
    var requirement   = document.getElementById("requirement").value;
    var type          = document.getElementById("type").value;
    var pretime       = document.getElementById("pretime").value;
    var endtime       = document.getElementById("endtime").value;
    var linkman       = document.getElementById("linkman").value;
    var role          = document.getElementById("Role").value;
    var phone         = document.getElementById("phoneNumber").value;
    var qq            = document.getElementById("QQ").value;
    var email         = document.getElementById("Email").value;
    var count         = document.getElementById("count").value;
    var note          = document.getElementById("remark").value;

    var data = {"name":name,"content":content,"requirement":requirement,"type":type,
        "pretime":pretime,"endtime":endtime,"linkman":linkman,"role":role,"phone":phone,
        "qq":qq,"email":email,"count":count,"note":note};


    var jsonData = JSON.stringify(data);

    $.ajax({
        url:"/exper/update",
        type:"post",
        dataType:"json",
        data:jsonData,
        success:function(data){
            var result = parseInt(data);
            if(result != -1){
                alert("success");
                window.location.href = "/exper/showExper?id="+ result +"&from=me";
            }else{
                alert("发布不成功，未知错误");
            }
        }
    });

    return;
}