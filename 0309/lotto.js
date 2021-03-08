$(function(){
	var st = setInterval(function() {
		
		var flag = [];
		var num = Math.floor(Math.random()*45+1)
		if(flag[num]){
			while(flag[num]){
				num = Math.floor(Math.random()*45+1)
			}
		}
		flag[num] = true;
		$('ul').append('<li>'+num+'</li>')
	}, 1000)
	
	setTimeout(function() {
		clearInterval(st)
	}, 6000)
})