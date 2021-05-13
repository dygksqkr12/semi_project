<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="meeting.model.vo.Meeting"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/meetingList.css" />
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<Meeting> list = (List<Meeting>)request.getAttribute("list");
	String location = (String)request.getAttribute("location");
	String category = (String)request.getAttribute("category");
	String search = (String)request.getAttribute("search");
	
	String cName;
	String lName;
	
	if(category.equals("C1")){
		cName="음악";
	}else if(category.equals("C2")){
		cName="게임";
	}else if(category.equals("C3")){
		cName="운동";
	}else if(category.equals("C4")){
		cName="요리";
	}else if(category.equals("C5")){
		cName="독서";
	}else if(category.equals("C6")){
		cName="재테크";
	}else if(category.equals("C7")){
		cName="자동차";
	}else{
		cName="전체";
	}
	
	if(location.equals("L1")){
		lName="서울";
	}else if(location.equals("L2")){
		lName="경기";
	}else if(location.equals("L3")){
		lName="인천";
	}else if(location.equals("L4")){
		lName="대전·충청";
	}else if(location.equals("L5")){
		lName="대구·경북";
	}else if(location.equals("L6")){
		lName="부산·경남";
	}else if(location.equals("L7")){
		lName="울산";
	}else if(location.equals("L8")){
		lName="광주";
	}else{
		lName="전국";
	}
%>

<div id="listWrapper">
	<div id="leftWrapper">
		<div class="leftName">
			<h4><%= cName+" > "+lName%></h4>
		<div class="leftName">
		<%
			if(search.length()!=0){
		%>
			<h4>제목 검색 : <%=search %></h4>
			<button type="button" onclick="location.href='<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=<%=location%>'">초기화</button>	
		<%}%>
		<div>
			<h3 class="leftATag">지역</h3>
		</div>
		<ol>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&search=<%=search%>">전국</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L1&search=<%=search%>">서울</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L2&search=<%=search%>">경기</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L3&search=<%=search%>">인천</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L4&search=<%=search%>">대전·충청</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L5&search=<%=search%>">대구·경북</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L6&search=<%=search%>">부산·경남</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L7&search=<%=search%>">울산</a></li>
			<li><a href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=L8&search=<%=search%>">광주</a></li>
		</ol>
	</div>
	
	<div id="rightWrapper">
		<h2>미플 모임</h2>
		<div id="search">
			<input type="text" name="" id="searchKeyword" placeholder="검색할 키워드를 입력하세요!"/>
			<button type="button" id="searchBtn">검색</button>
		</div>
		<%if(list.isEmpty()==false && list!=null){ %>
		<div class="boxWrapper">
		<%int i=0; int loop=list.size() >=3 ? 3 : list.size(); %>
		<%for(;i<loop;i++) { %>
		<% 
			Calendar now = Calendar.getInstance();
			now = new GregorianCalendar(now.get(Calendar.YEAR),now.get(Calendar.MONTH), now.get(Calendar.DATE));
			
			Calendar mDay = Calendar.getInstance();
			mDay.setTimeInMillis(list.get(i).getTime().getTime());
			mDay = new GregorianCalendar(mDay.get(Calendar.YEAR),mDay.get(Calendar.MONTH), mDay.get(Calendar.DATE));
			
			long mil2 = mDay.getTimeInMillis();
			long mil1 = now.getTimeInMillis();
			int diff = (int)((double)(mil2-mil1)/(1000*60*60*24));
			String dDay;
			if(diff>0){
				dDay="D-"+Integer.toString(diff);
			}else if(diff==0){
				dDay="D-Day!";
			}else{
				dDay="종료";
			}
		%>
			<div class="boxContents">
				<a href="<%=request.getContextPath()+"/meeting/meetingView?no="+list.get(i).getMeetingNo()%>">
					<img src="<%=request.getContextPath() %>/upload/<%=list.get(i).getAttach().getRenamedFilename() %>" width=220px height=150px/>
					<span><%=list.get(i).getTitle() %></span>
					<span id="dDay"><%=dDay %></span>
				</a>
			</div>
		<%} %>
		</div>
		<div class="boxWrapper">
		<%loop=list.size() >=6 ? 6 : list.size(); %>
		<%for(;i<loop;i++) { %>
		<% 
			Calendar now = Calendar.getInstance();
			now = new GregorianCalendar(now.get(Calendar.YEAR),now.get(Calendar.MONTH), now.get(Calendar.DATE));
			
			Calendar mDay = Calendar.getInstance();
			mDay.setTimeInMillis(list.get(i).getTime().getTime());
			mDay = new GregorianCalendar(mDay.get(Calendar.YEAR),mDay.get(Calendar.MONTH), mDay.get(Calendar.DATE));
			
			long mil2 = mDay.getTimeInMillis();
			long mil1 = now.getTimeInMillis();
			int diff = (int)((double)(mil2-mil1)/(1000*60*60*24));
			String dDay;
			if(diff>0){
				dDay="D-"+Integer.toString(diff);
			}else if(diff==0){
				dDay="D-Day!";
			}else{
				dDay="종료";
			}
		%>
			<div class="boxContents">
				<a href="<%=request.getContextPath()+"/meeting/meetingView?no="+list.get(i).getMeetingNo()%>">
					<img src="<%=request.getContextPath() %>/upload/<%=list.get(i).getAttach().getRenamedFilename() %>" width=220px height=150px/>
					<span><%=list.get(i).getTitle() %></span>
					<span id="dDay"><%=dDay %></span>
				</a>
			</div>
		<%} %>
		</div>
		<div class="boxWrapper">
		<%loop=list.size() >=9 ? 9 : list.size(); %>
		<%for(;i<loop;i++) { %>
		<% 
			Calendar now = Calendar.getInstance();
			now = new GregorianCalendar(now.get(Calendar.YEAR),now.get(Calendar.MONTH), now.get(Calendar.DATE));
			
			Calendar mDay = Calendar.getInstance();
			mDay.setTimeInMillis(list.get(i).getTime().getTime());
			mDay = new GregorianCalendar(mDay.get(Calendar.YEAR),mDay.get(Calendar.MONTH), mDay.get(Calendar.DATE));

			long mil2 = mDay.getTimeInMillis();
			long mil1 = now.getTimeInMillis();
			int diff = (int)((double)(mil2-mil1)/(1000*60*60*24));
			String dDay;
			if(diff>0){
				dDay="D-"+Integer.toString(diff);
			}else if(diff==0){
				dDay="D-Day!";
			}else{
				dDay="종료";
			}
			
		%>
			<div class="boxContents">
				<a href="<%=request.getContextPath()+"/meeting/meetingView?no="+list.get(i).getMeetingNo()%>">
					<img src="<%=request.getContextPath() %>/upload/<%=list.get(i).getAttach().getRenamedFilename() %>" width=220px height=150px/>
					<span><%=list.get(i).getTitle() %></span>
					<span id="dDay"><%=dDay %></span>
				</a>
			</div>
		<%} %>
		</div>
		<%}else{ %>
			<h1 style="line-height: 500px;">조회결과가 없습니다</h1>
		<% } %>
		<div id='pageBar'>
			<%= request.getAttribute("pageBar") != null ? request.getAttribute("pageBar") : ""%>
		</div>
	</div>
</div>

<script>
	$("#searchBtn").click(function(){
		var keyword = $("#searchKeyword").val();
		
		location.href="<%=request.getContextPath()%>/meeting/meetingList?category=<%=category%>&location=<%=location%>&search="+keyword;
	});
	$(document).ready(function(){
		<% if(search.length()!=0) {%>
			$("#searchKeyword").val("<%=search%>")
		<% } %>
	});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>