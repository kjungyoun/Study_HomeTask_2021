window.onload = function(){
	
	var st = setInterval(getNum, 1000);
	
	setTimeout(function(){
		clearInterval(st);
	}, 6000);
};

function getNum(){
	
	var list = document.getElementsByTagName("ul")[0];
	
	var number = Math.floor(Math.random()*45 + 1);
	
	// innerHTML 은 함수 실행 순간에만 내용을 넣는 것
	// 함수가 재 호출되면 이전에 넣은 태그가 기억되지 않음
	// 따라서 아래와 같이 태그를 직접 생성하고 그안에 내용을 넣은 뒤 appenChild로 넣어줘야 다음 함수 실행때도 이전내용 기억됨
	var newli = document.createElement('li');
	newli.innerHTML = number;
	
	list.appendChild(newli);
	
	
}
