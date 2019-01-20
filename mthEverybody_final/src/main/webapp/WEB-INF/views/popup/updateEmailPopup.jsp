<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

<style>
    .popup {
      width: 50%;
    }

    .wrapper.joinmember{
      width: 100%;
    }

    .col-lg-9.joinmember {
      flex: 0 0 100%;
      max-width: 100%;
    }

  @media(max-width: 992px) {
    .popup {
      width: 60%;
    }

    .wrapper.joinmember{
      width: 100%;
    }

    .col-lg-9.joinmember {
      flex: 0 0 100%;
      max-width: 100%;
    }
  }

  @media(max-width: 768px) {
    .popup {
      width: 80%;
    }
    .wrapper.joinmember{
      width: 100%;
    }

    .col-lg-9.joinmember {
      flex: 0 0 100%;
      max-width: 100%;
    }
  }

  @media(max-width: 576px) {
    .popup {
      width: 100%;
    }
    .wrapper.joinmember{
      width: 100%;
    }

    .col-lg-9.joinmember {
      flex: 0 0 100%;
      max-width: 100%;
    }
  }
</style>
<script>

var checkAllValue = false;

//이메일 체크(onkeyup, onblur)
function checkJoinEmail(){
	var inputEmail = document.getElementById('input-email');
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
	if(inputEmail.value =="" || inputEmail.value ==null)
	{
		document.getElementById('joinMember-email-chk').innerHTML = '이메일을 입력해주세요.';
		document.getElementById('joinMember-email-chk').style.color = "red";
	}
	else if(exptext.test(inputEmail.value) == false)
	{
		document.getElementById('joinMember-email-chk').innerHTML = '유효한 이메일 형식을 입력해주세요.';
		document.getElementById('joinMember-email-chk').style.color = "red";
	}
	else
	{
		document.getElementById('joinMember-email-chk').innerHTML = '유효한 이메일 형식입니다.';
		document.getElementById('joinMember-email-chk').style.color = "#00a000";
		checkAllValue = true;
	}
}

//submit 수행
function submitUpdateEmail() {
	
	if(checkAllValue == false)
	{
		alert('유효한 값을 입력해주세요.');
		return false;
	}
	else
	{
		document.getElementById('update-email-form').action="${pageContext.request.contextPath}/actionUpdateEmail";
		document.getElementById('update-email-form').submit();		
	}	
}
</script>
</head>

<body>

  <!-- wrapper 시작 -->
  <div class="wrapper joinmember">
    <!-- row 시작 -->
    <div class="row">
      <!-- /.col-lg-3 끝 -->
      <!-- col-lg-9 시작 -->
      <div class="col-lg-9 joinmember">
        <!-- 내용 넣는 공간 -->

        <div>
          <div class="row">
            <h3>인증할 이메일 변경</h3><br />
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
              <!-- Start form -->
              <div id='email-form-wrap_update'>
                <form id="update-email-form" method="post" autocomplete="off">
					 <div class="form-group">
					 	<input type="hidden" name="member_idx" value="${requestMemberIdx}">
                        <label for="input-email">이메일</label>
                        <input type="email" class="form-control" name="member_email"id="input-email" aria-describedby="emailHelp" placeholder="이메일" onkeyup="checkJoinEmail()" onblur="checkJoinEmail()">
                        <div class="view-sys-msg"><span id="joinMember-email-chk">본 메일로 인증번호 발송 및 아이디/비밀번호를 찾을 수 있습니다.<br>정확한 메일을 입력해주시길 바랍니다.</span></div>
                    </div>
                  	<div class="form-check">
                  		<button type="button" class="btn btn-primary" onclick="location.href='#'">취소</button>
                    	<button type="button" class="btn btn-primary" onclick="submitUpdateEmail()">수정 및 재인증</button>
                 	</div>
                </form>
              </div>
              <!-- end form -->
            </div>
          </div>
        </div>

      </div>
      <!-- /.col-lg-9 끝 -->
    </div>
    <!-- /.row 끝 -->
  </div>
  <!-- /.wrapper 끝 -->
</body>

</html>