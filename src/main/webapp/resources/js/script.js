$("svg").on("click",function(event){
	console.log("pizdec blyzd");
	$("input[id$='x']").val(event.pageX);
	$("input[id$='y']").val(event.pageY);
});
function hui(){
	console.log("hui");
}