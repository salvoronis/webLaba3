$("svg").on("click",function(event){
	console.log("pizdec blyzd");
	//$("input[id$='x']").val(event.pageX);
	//$("input[id$='y']").val(event.pageY);
	fuckingImg([{name:'ximg',value:event.pageX},{name:'suka',value:event.pageY}]);
	//var data = event.pageX+','+event.pageY
	//fuckingImg([{suka:event.pageX+','+event.pageY}]);
});
function hui(){
	console.log("hui");
}