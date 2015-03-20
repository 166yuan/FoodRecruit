/**
 * Created by Administrator on 2015/2/12.
 */
jQuery(function($){

$('#id-disable-check').on('click',function(){
    var inp = $('#form-field-2').get(0);
    if(inp.hasAttribute('readonly')){
        inp.removeAttribute('readonly');
    }else{
        inp.setAttribute('readonly','true');
    }
});
});