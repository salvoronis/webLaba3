$("svg").on("click",function(event){
	fuckingImg([{name:'ximg',value:event.pageX},{name:'suka',value:event.pageY}]);
});
function check() {
    if ($("#ytext").val() != '')
        $("#formjs").removeAttr('disabled');
    else
        $("#formjs").attr('disabled', 'false');
}
/*$("formjs").on("click", function(event){
    console.log($("#ytext").val);
    console.log(widget_helpme_sliderx.getValue());
    //fuckingForm([{name:'xform',value:event.pageX},{name:'yform',value:event.pageY}]);
});*/
/*function formfuck(){
    console.log($("#ytext").val());
    console.log(widget_helpme_sliderx.getValue());
}*/
function renderImg(value){
	console.log(value);

	value*=50;
    var valh = value/2;
    var a = value + 270;
    var b = 270 - valh;
    var c = 270 + valh
    $('rect').attr('width', value);
    $('rect').attr('height', valh);
    $('#triangle').attr('points', '270,270 '+a+',270 270,'+b);
    $('path').attr('d','M '+b+' 270 A 90 90, 0, 0, 0, 270 '+c+' L 270 270 Z');
    $('.ypoint').each(function(index){
    	var kuda = (index*valh)+(270-value);
        $(this).attr('y',kuda);
    });
    $('.xpoint').each(function(index){
        var kuda = (index*valh)+(270-value);
        $(this).attr('x',kuda);
    });
}