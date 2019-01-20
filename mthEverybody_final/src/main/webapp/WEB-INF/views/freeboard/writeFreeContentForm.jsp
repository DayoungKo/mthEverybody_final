<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>

  <title>자취생을 위한 모두의 떨이</title>
  <link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/img/logo/image2.png">
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/subbootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

  <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

  <!-- 텍스트에디터 삽입 js -->
  <script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>

  <style>
    button{
      margin-top: 20px;
    }
  </style>
</head>

<body>
  <!-- 헤더 영역 -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <jsp:include page="../commons/header.jsp" />
  </nav>

  <!-- wrapper 시작 -->
  <div class="wrapper body">
    <!-- row 시작 -->
    <div class="row">
      <!-- /.col-lg-3 시작 -->
      <div class="col-lg-3">
        <!-- 사이드바 -->
        <h1 class="my-4">Board</h1>
        <jsp:include page="../commons/asideHome.jsp" />
        <!-- 사이드바 끝 -->
        <!-- 광고상자 -->
        <div class="advertiseAside">
          <p>광고</p>
        </div>
        <!-- 광고상자 끝 -->
      </div>
      <!-- /.col-lg-3 끝 -->
      <!-- col-lg-9 시작 -->
      <div class="col-lg-9">
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <!-- 내용 넣는 공간 -->
          <form action="${pageContext.request.contextPath}/freeboard/actionWriteFreeContentForm?pageNum=${pageNum}" role="form" method="post" class="writeForm" autocomplete="off" enctype="multipart/form-data" style="
          margin-top: 45px;">
              <div class="form-group">
                  <label for="free_title" class="sr-only">제목</label>
                  <input type="text" name="free_title" class="form-control" placeholder="제목을 입력해 주세요">
                  <!-- <input type="text" name="free_title" class="form-control" placeholder="제목을 입력해 주세요" required> -->
              </div>
              <div class="form-group">
                  <label for="free_category" class="sr-only">글 구분</label>
                  <select name="free_category" class="form-control">
                    <option value="잡담">잡담</option>
                    <option value="질문">질문</option>
                    <option value="비밀">비밀</option>
                    <option value="그외">그외</option>
                  </select>
              </div>
            <!-- 글 입력 -->
            <textarea name="free_content" id="free_content" rows="20" cols="80" placeholder=" 내용을 입력해 주세요. "></textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                $(function(){
                  CKEDITOR.replace( 'free_content', {//해당 이름으로 된 textarea에 에디터를 적용
                  height:'500px',
                  filebrowserImageUploadUrl: '${pageContext.request.contextPath}/freeboard/freeImageUpload' //여기 경로로 파일을 전달하여 업로드 시킨다.
                  
                });
            
                  CKEDITOR.on('dialogDefinition', function( ev ){
                    var dialogName = ev.data.name;
                    var dialogDefinition = ev.data.definition;
             
                    switch (dialogName) {
                      case 'image': //Image Properties dialog
                      //dialogDefinition.removeContents('info');
                      dialogDefinition.removeContents('Link');
                      dialogDefinition.removeContents('advanced');
                      break;
                    }
                  });
                });
              </script>
          
              
          <!-- 글 입력 끝 -->
  			<br>
  			<!-- <input type="file" name="free_img_imgfilename" multiple> -->
            <input type="file" id="files" name="files" multiple>
            
            <a href="${pageContext.request.contextPath }/freeboard/freeBoard"><input type="button" class="btn btn-primary" value="목록으로"></a>
            <input type="submit" class="btn btn-success" value="글 등록">
          </form>
          
          
      </div>

    </div>
    <!-- /.col-lg-9 끝 -->
  </div>
  <!-- /.row 끝 -->
  </div>
  <!-- /.wrapper 끝 -->

  <!-- Footer 시작 -->
  <footer class="py-5 bg-dark">
    <jsp:include page="../commons/footer.jsp" />
  </footer>
  <!-- Footer 끝 -->
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>