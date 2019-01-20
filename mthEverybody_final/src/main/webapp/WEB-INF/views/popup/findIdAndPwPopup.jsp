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
//탈퇴 버튼 onclick시 호출
function findMemberId()
{
	//회원 이메일로 아이디 확인 Ajax
	var inputEmailVlaue = document.getElementById('input-email').value;
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function(){
		
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200)
		{
			//true: 회원 비밀번호 일치
			var result = xmlhttp.responseText;
			if(result == "" || result == null)
			{
				document.getElementById('result-findId-area').innerHTML = '해당 메일로 가입된 이력이 없습니다.';
				document.getElementById('result-findId-area').style.color = "red";
			}
			else
			{
				document.getElementById('result-findId-area').innerHTML = result;
				document.getElementById('result-findId-area').style.color = "#00a000";
			}
		}
	};
	xmlhttp.open("POST","${pageContext.request.contextPath}/findMemberId",true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("member_email="+inputEmailVlaue);
}
function submitTempPwForm(){
	var formForTempPw = document.getElementById('sendTempPwForm');
	formForTempPw.action = "${pageContext.request.contextPath}/sendTempPassword";
	formForTempPw.submit();
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

        <div id="joinmember-input-box_delete">
          <div class="row">
            <h4>Forgot your ID or PassWord?</h4>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
              <!-- Start form   style='margin: 1em auto; border: 1px solid grey; border-radius: 0.5em; padding: 0.5em;' -->
              <div style='margin: 1em auto;'>
                  <div class="form-group">
                    <label for="input-email">아이디 찾기</label>
                    <input type="email" class="form-control" name="member_email" id="input-email" placeholder="가입한 이메일">
                  </div>
                  <div id='result-findId-area'></div>
                  <div class="form-check" style='text-align: right;'>
                    <button type="button" class="btn btn-primary" onclick="findMemberId()">아이디 찾기</button>
                  </div>
              </div>
              <hr>
              <div style='margin: 1em auto;'>
                 	 <form id="sendTempPwForm" method='post'>
                	  <div class="form-group">
                    		<label >임시 비밀번호 전송</label>
                   			<input type="text" class="form-control" name="member_id" id="input-id2" placeholder="가입한 아이디" required>
                  		</div>
                  		<div class="form-group">
                    		<input type="email" class="form-control" name="member_email" id="input-email2" placeholder="이메일" required>
                    	</div>
                 		 <div style='font-size:0.9em; margin-bottom: 1em;'>해당 메일로 임시 비밀번호가 전송됩니다. 정확한 주소를 기입해주세요.</div>
                  		<div class="form-check" style='text-align: right;'>
                   			 <button type="button" class="btn btn-primary" onclick="submitTempPwForm()">임시 비밀번호 전송</button>
                 		 </div>
                    </form>
              </div>
              <div class="form-check" style='text-align: center;'>
                <button type="button" class="btn btn-primary" onclick="location.href='#'">취소</button>
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