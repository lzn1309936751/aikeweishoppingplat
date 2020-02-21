var hide = $(".conceal");
var hide1 = $(".conceal").find(".sub").find("a")
 $.getJSON("/privileges/query",{"id":$("#userId").val()},function(result){
	$.each(result,function(index,p){
		console.log(p.parent)
		if(p.parent){
			$.each(hide,function(index,val){
				
				if(p.name.toString()==$(val).find("span").text().toString()){
					$(val).removeClass("conceal")
				}
			})
		}
		if(!p.parent){
			$.each(hide1,function(i,v){
				if(p.name.toString()==$(v).html().toString()){
					$(v).parent().removeClass("conceal")
				}
			})
		}
	})
}) 
