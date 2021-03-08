$(document).ready(function() {
	
	$('button').each(function(index, element) {
		$(element).click(function() {
			cal($(element).val())
		})
	})
	var cnt = 1;
	function cal(data){
		if(data == '='){
			try {
				var num = $('#formula').val();
				$('#formula').val(eval(num));
				$('#result').append(cnt++ +'. ' + num + ' = '+ $('#formula').val()+'</br>')
			} catch (e) {
				alert("연산이 잘못되었습니다 : " +e)
			}
		}else if(data == 'CE'){
			$('#formula').val('0.0')
		}else{
			if($('#formula').val() == '0.0'){
				$('#formula').val(data)
			}else{
				var r = $('#formula').val() + data
				$('#formula').val(r)
			}
		}
	}
})