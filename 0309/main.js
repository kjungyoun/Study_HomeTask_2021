$(function () {
	// 회원가입 구현
    $("#Join").click(function() {
    	if(!$('#uid').val()){
    		alert('ID를 입력하세요')
    		$('#uid').focus()
    		return
    	}
    	if(!$('#pwd').val()){
    		alert('Password를 입력하세요')
    		$('#pwd').focus()
    		return
    	}
    	if(!$('#pwd-val').val()){
    		alert('Password 확인을 입력하세요')
    		$('#pwd-val').focus()
    		return
    	}
    	if(!$('#uname').val()){
    		alert('이름을 입력하세요')
    		$('#uname').focus()
    		return
    	}if(!$('#tel').val()){
    		alert('전화번호를 입력하세요')
    		$('#tel').focus()
    		return
    	}if(!$('#email').val()){
    		alert('이메일을 입력하세요')
    		$('#email').focus()
    		return
    	}if(!$('#addr').val()){
    		alert('주소를 입력하세요')
    		$('#addr').focus()
    		return
    	}if(!$('#addr2').val()){
    		alert('상세 주소를 입력하세요')
    		$('#addr2').focus()
    		return
    	}
    	var id = $('#uid').val();
    	console.log(id)
    	$.ajax({
    		url: './userlist.xml',
    		dataType: 'xml',
    		success: function(data){
    			$('id',data).each(function(idx, item) {
    				if(id == $(item).text()){
    					alert('중복된 아이디입니다. 다른 아이디를 선택해주세요')
    					$('#uid').focus()
    					return;
    				}
    			})
    		},
    		err: function(xhr,status,err){
    			alert(err);
    		}
    	})
    	alert('회원가입에 성공하였습니다!')
    })
    
    // modal 창 로그인 구현
    $("#login-btn").click(function() {
    	var id = $('#modal-id').val()
    	var pwd = $('#modal-pwd').val()
    	
    	if(!id){
    		alert('ID를 입력해주세요')
    		$('#modal-id').focus()
    		return;
    	}
    	if(!pwd){
    		alert('Password를 입력해주세요')
    		$('#modal-pwd').focus()
    		return;
    	}
    	$.ajax({
    		url: 'userlist.xml',
    		dataType: 'xml',
    		success: function(data){
    			$('data',data).each(function(idx, item) {
    				if(id == $('id',item).text() && pwd == $('password',item).text()){
    					alert('로그인 성공!');
    					$('#myModal').modal("hide");
    					$(".nav-link.text-danger:eq(0)").css('display', 'none');
    					$(".nav-link.text-danger:eq(1)").css('display', 'none');
    					$('#nav-id').css('display', '')
    					$('#nav-id').html(id);
    					$(".nav-link.text-danger:eq(2)").css('display', '');
    				}
    			})
    		}
    	})
    })
    
    // 주소 검색 구현 (API 이용)
    // https://postcode.map.daum.net/guide
    $('#addr').click(function() {
    	new daum.Postcode({
            oncomplete: function(data) {
            	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                   addr += extraAddr
                
                } else {
                	addr +=''
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $('#addr').val(addr)
                // 커서를 상세주소 필드로 이동한다.
                $("#addr2").focus();
            }
        }).open();
    })
    
    // 로그아웃 구현
    $('.nav-link.text-danger:eq(2)').click(function() {
    	self.location.reload()
    })
});
