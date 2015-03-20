function publish(){
    var isok=true;
  var name=document.getElementById("name").value;
    var content=document.getElementById("content").value;
    var type=document.getElementById("type").value;
    var pretime=document.getElementsByName("pretime").value;
    var endtime=document.getElementsByName("endtime").value;
    var link=document.getElementById("linkman").value;
    var role=document.getElementById("Role").value;
    var phone=document.getElementById("phoneNumber").value;
    var qq=document.getElementById("QQ").value;
    var email=document.getElementById("Email").value;
    var count=document.getElementById("count").value;
    var note=document.getElementById("remark").value;
  $.getJSON('/exper/addExper?name='+name+'&content='+content+'&type='+type+'&pretime='+pretime+
      '&endtime='+endtime+'&link='+link+'&role='+role+'&phone='+phone+'&qq='+qq+'&email='+email+'&count='+count
      +'&note='+note
      ,function(data){
    if(data==true){
      window.location.href="/exper/showExper";
    }
  });
}