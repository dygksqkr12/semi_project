<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	Board board = (Board)request.getAttribute("board");
	int cPage = (int)request.getAttribute("cPage");
%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/board.css" />




<h2>게시글 수정</h2>
<form action="<%=request.getContextPath()%>/board/adminBoardUpdate"
	method="post" id="boardEnrollFrm">

	<input type="text" name="title" id="enroll_title" placeholder="제목을 입력하세요." value="<%=board.getTitle()%>"/> 
	<input type="hidden" name="content" value="" id="enroll_content" />
	
	<!-- admin부분 추후 접속 로그인 아이디로 변경해야함 -->
	<input type="hidden" name="writer" value="<%=board.getWriter() %>" id="enroll_writer" />
	<input type="hidden" name="boardNo" value="<%=board.getBoardNo() %>" />
	<input type="hidden" name="cPage" value="<%= cPage %>" />
	<div id="enroll_summerNoteWrapper">
		<div id="enroll_summernote"></div>
	</div>

	<input type="submit" value="수정" /> <input type="button" value="취소"
		onclick="cancel()" />
</form>

<script>
	//게시판 에디터 생성
      $("#enroll_summernote").summernote({
        width: 1198,
        height: 500,
        focus: true,
        disableResizeEditor: true,
      }).summernote('code','<%=board.getContent()%>');
      
	//submit 처리
      $("#boardEnrollFrm").submit(function(){
    		$("[name=content]").val($("#enroll_summernote").summernote('code'));
			var $title = $("[name=title]").val();
			var $content = $("[name=content]").val();
			
			//제목 유효성 검사
			if(/^.{1,}$/.test($title)==false){
				alert("제목을 입력해주세요!");
				$("[name=title]").focus();
				return false;
			}
			//내용 유효성 검사
			if($content.length==0 || $content=="<p><br></p>"){
				alert("내용을 입력해주세요!");
				$("#enroll_summernote").summernote("focus");
				return false;
			}
			
    	if(confirm("게시글을 수정 하시겠습니까?")){
    		return true;
    	}else{
    		return false;
    	}
      });
      
	//뒤로가기
      function cancel(){
    	  if(confirm("정말 게시글 수정을 중단 하시겠습니까?")){
    		  location.href='<%=request.getContextPath()%>/board/adminBoardView?no=<%=board.getBoardNo()%>&cPage=<%=cPage%>';
		}
	};
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>