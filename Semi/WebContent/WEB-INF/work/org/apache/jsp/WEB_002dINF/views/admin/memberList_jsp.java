/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.44
 * Generated at: 2021-04-19 07:31:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.service.MemberService;
import member.model.vo.Member;
import java.util.List;
import member.model.vo.Member;

public final class memberList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1618817105608L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1618817105608L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.service.MemberService");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String msg = (String) session.getAttribute("msg");
	if (msg != null)
	session.removeAttribute("msg");
	Member loginMember = (Member) session.getAttribute("loginMember");
	//사용자 쿠키처리
	String saveId = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			String name = c.getName();
			String value = c.getValue();
			System.out.println(name + " : " + value);
			if ("saveId".equals(name))
		saveId = value;
		}
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/css/header.css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.6.0.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/Logo.png\" id=\"Logo\"/></a>\r\n");
      out.write("\t\t\t<div class=\"login\">\r\n");
      out.write("\t\t\t");

				if (loginMember == null) {
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"로그인\" id=\"login_button\">\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"회원가입\" id=\"signup_button\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/enroll';\">\r\n");
      out.write("\t\t\t");

				} else {
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<table id=\"login\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(loginMember.getName());
      out.write("님, 안녕하세요.</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"button\" value=\"mypage\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/mypage';\" class=\"loginbtn\" />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"logout\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/logout';\" class=\"loginbtn\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"loginEnd\"></div>\r\n");
      out.write("\t\t<!-- Loginframe 평소에 hide -->\r\n");
      out.write("\t\t<div id=\"login_frame_div\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/city1.png\" id=\"login_image\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- 로그인 포지션-->\r\n");
      out.write("\t\t\t<form id=\"login_form\"\r\n");
      out.write("\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/member/login\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" id=\"login_closeBtn\" value=\"X\" style=\"float:right;\"/>\r\n");
      out.write("\t\t\t\t\t<h1 style=\"clear:both;\">로그인</h1>\r\n");
      out.write("\t\t\t\t\t<br> \r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"id_input\" id=\"id_input\" placeholder=\"아이디를 입력해주세요.\"");
      out.print(saveId != null ? "value='" + saveId + "'" : "");
      out.write("> <br>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"password_input\" id=\"password_input\" placeholder=\"비밀번호를 입력해주세요.\"> <br> \r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"login_submit\" id=\"login_submit\" value=\"로그인\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div id=\"checkbox_findbox_wrapper\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"checkbox_wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"saveid\" id=\"saveid\" ");
      out.print(saveId != null ? "checked" : "");
      out.write(" /> \r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"saveid\">로그인 유지하기</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/member/find\"><span id=\"find_span\">아이디+비밀번호 찾기</span></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br> <br>\r\n");
      out.write("\t\t\t\t\t<div class=\"enroll_div\" id=\"enroll_div\"  onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/enroll';\" style=\"clear:both\";>\r\n");
      out.write("\t\t\t\t\t\t미플 회원가입하기\r\n");
      out.write("\t\t\t\t\t\t<!-- 회원이 아니신가요? <span id=\"enroll_span\" onclick=\"enroll_span()\">회원가입</span> -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li><a href=\"\">전체</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/meeting/meetingEnrollUpdate\">mt:enrollUpdate</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/meeting/meetingView\">mt:View</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">음악</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">게임</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">운동</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">요리</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">독서</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">재테크</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"\">자동차</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardList\">자유게시판</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/board/adminBoardList\">공지사항</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/memberList\">회원관리</a></li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\t");
if(msg!=null){
      out.write("\r\n");
      out.write("\t\t\t\talert(\"");
      out.print(msg);
      out.write("\");\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t$(signup_button).click(function(){\r\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/member/enroll\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(login_button).click(function() {\r\n");
      out.write("\t\t\t\tvar top = screen.availHeight / 2 - 200;\r\n");
      out.write("\t\t\t\t$(\"#login_frame_div\").attr('style', 'display:flex; top:'+top+'px;');\r\n");
      out.write("\t\t\t\tif(id_input.value.length==0){\r\n");
      out.write("\t\t\t\t\t$('#id_input').focus();\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$('#password_input').focus();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(login_closeBtn).click(function(){\r\n");
      out.write("\t\t\t\t$(\"#login_frame_div\").attr('style', 'display:none;');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</header>\r\n");
      out.write("\r\n");
      out.write("\t<section>");
      out.write('\r');
      out.write('\n');

	List<Member> list = (List<Member>) request.getAttribute("list");
	Member member = new Member();
	String type = request.getParameter("searchType");
	String kw = request.getParameter("searchKeyword");
	int cPage = (int)request.getAttribute("cPage");

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/admin.css\">\r\n");
      out.write("<style>\r\n");
      out.write("\tdiv#search-memberId {display: ");
      out.print( type != null && "memberId".equals(type) ? "inline-block" : "none" );
      out.write(";}\r\n");
      out.write("\tdiv#search-memberName{display: ");
      out.print( type != null && "memberName".equals(type) ? "inline-block" : "none" );
      out.write(";}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    $(\"#searchType\").change(function(){\r\n");
      out.write("        var result = $(\"#searchType option:selected\").val();\r\n");
      out.write("        if(result == 'memberId'){\r\n");
      out.write("            $(\"#search-memberId\").css(\"display\",\"inline-block\");\r\n");
      out.write("            $(\"#search-memberName\").css(\"display\",\"none\");\r\n");
      out.write("        }\r\n");
      out.write("        else if(result == 'memberName'){\r\n");
      out.write("            $(\"#search-memberId\").css(\"display\",\"none\");\r\n");
      out.write("            $(\"#search-memberName\").css(\"display\",\"inline-block\");\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    $(\".member-role\").change(function(){\r\n");
      out.write("    \tvar memberId = $(this).data(\"memberId\");\r\n");
      out.write("    \tvar memberRole = $(this).val();\r\n");
      out.write("    \t\r\n");
      out.write("    \tvar memberRoleStr = \r\n");
      out.write("    \t\tmemberRole == \"");
      out.print( MemberService.ADMIN_ROLE );
      out.write("\" ?\r\n");
      out.write("    \t\t\t\t\"관리자\" : \"일반\";\r\n");
      out.write("    \t\r\n");
      out.write("    \tif(confirm(\"[\" + memberId + \"] 회원의 권한을 [\" + memberRoleStr + \"]로 변경하시겠습니까?\")){\r\n");
      out.write("    \t\tvar $frm = $(document.memberRoleUpdateFrm);\r\n");
      out.write("    \t\t$frm.find(\"[name=memberId]\").val(memberId);\r\n");
      out.write("    \t\t$frm.find(\"[name=memberRole]\").val(memberRole);\r\n");
      out.write("    \t\t$frm.submit();\r\n");
      out.write("    \t}\r\n");
      out.write("    \telse {\r\n");
      out.write("    \t\t//기본 선택된 option태그로 다시 변경\r\n");
      out.write("    \t\t$(this).children(\"[selected]\").prop(\"selected\", true);\r\n");
      out.write("    \t}\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    $(\".event1\").change(function(){\r\n");
      out.write("    \tvar memberId = $(this).data(\"memberId\");\r\n");
      out.write("    \tvar event1 = $(this).val();\r\n");
      out.write("    \t\r\n");
      out.write("    \tvar event1Str = \r\n");
      out.write("    \t\tevent1 == \"");
      out.print( MemberService.EVENT_TRUE );
      out.write("\" ?\r\n");
      out.write("    \t\t\t\t\"동의\" : \"동의안함\";\r\n");
      out.write("    \t\r\n");
      out.write("    \tif(confirm(\"[\" + memberId + \"] 회원의 권한을 [\" + event1Str + \"]로 변경하시겠습니까?\")){\r\n");
      out.write("    \t\tvar $frm = $(document.memberEventUpdateFrm);\r\n");
      out.write("    \t\t$frm.find(\"[name=memberId]\").val(memberId);\r\n");
      out.write("    \t\t$frm.find(\"[name=event1]\").val(event1);\r\n");
      out.write("    \t\t$frm.submit();\r\n");
      out.write("    \t}\r\n");
      out.write("    \telse {\r\n");
      out.write("    \t\t//기본 선택된 option태그로 다시 변경\r\n");
      out.write("    \t\t$(this).children(\"[selected]\").prop(\"selected\", true);\r\n");
      out.write("    \t}\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    $(\".event2\").change(function(){\r\n");
      out.write("    \tvar memberId = $(this).data(\"memberId\");\r\n");
      out.write("    \tvar event2 = $(this).val();\r\n");
      out.write("    \t\r\n");
      out.write("    \tvar event2Str = \r\n");
      out.write("    \t\tevent2 == \"");
      out.print( MemberService.EVENT_TRUE );
      out.write("\" ?\r\n");
      out.write("    \t\t\t\t\"동의\" : \"동의안함\";\r\n");
      out.write("    \t\r\n");
      out.write("    \tif(confirm(\"[\" + memberId + \"] 회원의 권한을 [\" + event2Str + \"]로 변경하시겠습니까?\")){\r\n");
      out.write("    \t\tvar $frm = $(document.memberEventUpdateFrm2);\r\n");
      out.write("    \t\t$frm.find(\"[name=memberId]\").val(memberId);\r\n");
      out.write("    \t\t$frm.find(\"[name=event2]\").val(event2);\r\n");
      out.write("    \t\t$frm.submit();\r\n");
      out.write("    \t}\r\n");
      out.write("    \telse {\r\n");
      out.write("    \t\t//기본 선택된 option태그로 다시 변경\r\n");
      out.write("    \t\t$(this).children(\"[selected]\").prop(\"selected\", true);\r\n");
      out.write("    \t}\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"memberList-container\">\r\n");
      out.write("    <h2>회원관리</h2>\r\n");
      out.write("\r\n");
      out.write("    <!-- 검색 -->\r\n");
      out.write("    <div id=\"search-container\">\r\n");
      out.write("            검색타입 : \r\n");
      out.write("            <select id=\"searchType\">\r\n");
      out.write("                <option value=\"\">선택</option>\r\n");
      out.write("                <option value=\"memberId\" ");
      out.print( "memberId".equals(type) ? "selected" : "" );
      out.write(">아이디</option>\r\n");
      out.write("                <option value=\"memberName\" ");
      out.print( "memberName".equals(type) ? "selected" : "" );
      out.write(">회원명</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <div id=\"search-memberId\">\r\n");
      out.write("                <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberFinder\" >\r\n");
      out.write("                    <input type=\"hidden\" name=\"searchType\" value=\"memberId\">\r\n");
      out.write("                    <input type=\"text\" name=\"searchKeyword\" placeholder=\"검색할 아이디 입력\" value=\"");
      out.print( "memberId".equals(type) ? kw : "" );
      out.write("\">\r\n");
      out.write("                    <button type=\"submit\">검색</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"search-memberName\">\r\n");
      out.write("                <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberFinder\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"searchType\" value=\"memberName\">\r\n");
      out.write("                    <input type=\"text\" name=\"searchKeyword\" placeholder=\"검색할 이름 입력\" value=\"");
      out.print( "memberName".equals(type) ? kw : "" );
      out.write("\">\r\n");
      out.write("                    <button type=\"submit\">검색</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 회원조회 -->\r\n");
      out.write("        <div id=\"tableArea\">\r\n");
      out.write("            <table id = \"tbl-member\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>아이디</th>\r\n");
      out.write("                        <th>이름</th>\r\n");
      out.write("                        <th>회원권한</th>\r\n");
      out.write("                        <th>이메일</th>\r\n");
      out.write("                        <th>전화번호</th>\r\n");
      out.write("                        <th>event1</th>\r\n");
      out.write("                        <th>event2</th>\r\n");
      out.write("                        <th>가입일</th>\r\n");
      out.write("                        <th id=\"hidden-table\"></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                ");
 if(list == null || list.isEmpty()){ 
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"9\" style=\"text-align:center;\">조회된 회원이 없습니다.</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                ");
 
                	}
                else {
                	for(Member m : list){
                
      out.write("\r\n");
      out.write("                \t<tr>\r\n");
      out.write("                        <td>");
      out.print( m.getMemberId() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( m.getName() );
      out.write("</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                        \t<select class=\"member-role\" data-member-id=\"");
      out.print( m.getMemberId() );
      out.write("\">\r\n");
      out.write("                        \t\t<option\r\n");
      out.write("                        \t\t\tvalue=\"");
      out.print(MemberService.ADMIN_ROLE );
      out.write("\"\r\n");
      out.write("                        \t\t\t");
      out.print(MemberService.ADMIN_ROLE.equals(m.getMemberRole()) ? "selected" : "" );
      out.write(">관리자</option>\r\n");
      out.write("                        \t\t<option \r\n");
      out.write("                        \t\t\tvalue=\"");
      out.print(MemberService.MEMBER_ROLE );
      out.write("\"\r\n");
      out.write("                        \t\t\t");
      out.print(MemberService.MEMBER_ROLE.equals(m.getMemberRole()) ? "selected" : "" );
      out.write(">일반</option>\r\n");
      out.write("                        \t</select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>");
      out.print( m.getEmail() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( m.getPhone() );
      out.write("</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                        \t<select class=\"event1\" data-member-id=\"");
      out.print( m.getMemberId() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option \r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print( MemberService.EVENT_TRUE );
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( MemberService.EVENT_TRUE.equals(m.getEvent1()) ? "selected" : ""  );
      out.write(">동의</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option \r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print( MemberService.EVENT_FALSE );
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( MemberService.EVENT_FALSE.equals(m.getEvent1()) ? "selected" : ""  );
      out.write(">동의안함</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                        \t<select class=\"event2\" data-member-id=\"");
      out.print( m.getMemberId() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option \r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print( MemberService.EVENT_TRUE );
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( MemberService.EVENT_TRUE.equals(m.getEvent2()) ? "selected" : ""  );
      out.write(">동의</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option \r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print( MemberService.EVENT_FALSE );
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( MemberService.EVENT_FALSE.equals(m.getEvent2()) ? "selected" : ""  );
      out.write(">동의안함</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>");
      out.print( m.getEnrollDate() );
      out.write("</td>\r\n");
      out.write("                        <td><input type=\"button\" data-member-id=\"");
      out.print( m.getMemberId() );
      out.write("\" class=\"delMember\" value=\"강제탈퇴\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write(" \r\n");
      out.write("                ");
		
                	}
                }
                
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("            <!-- 페이지바 -->\r\n");
      out.write("            <div id=\"pageBar\">\r\n");
      out.write("            \t");
      out.print( request.getAttribute("pageBar") != null ? request.getAttribute("pageBar") : "");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("     </div>\r\n");
      out.write("</div>\r\n");
      out.write("<form \r\n");
      out.write("\taction=\"");
      out.print( request.getContextPath() );
      out.write("/admin/memberDelete\"\r\n");
      out.write("\tname=\"admMemberDelFrm\"\r\n");
      out.write("\tmethod=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"memberId\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<script>\r\n");
      out.write("$(\".delMember\").click(function(){\r\n");
      out.write("\tvar memberId = $(this).data(\"memberId\");\r\n");
      out.write("\tif(confirm(memberId+\"를 정말 추방시키겠습니까?\")){\r\n");
      out.write("\t\tvar $frm = $(document.admMemberDelFrm);\r\n");
      out.write("\t\t$frm.find(\"[name=memberId]\").val(memberId);\r\n");
      out.write("\t\t$(document.admMemberDelFrm).submit();\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<form\r\n");
      out.write("\taction=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberRoleUpdate\"\r\n");
      out.write("\tname=\"memberRoleUpdateFrm\" method=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"memberId\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"memberRole\" />\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form\r\n");
      out.write("\taction=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberEventUpdate\"\r\n");
      out.write("\tname=\"memberEventUpdateFrm\" method=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"memberId\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"event1\" />\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form\r\n");
      out.write("\taction=\"");
      out.print(request.getContextPath() );
      out.write("/admin/memberEventUpdate2\"\r\n");
      out.write("\tname=\"memberEventUpdateFrm2\" method=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"memberId\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"event2\" />\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("    <footer>footer</footer>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
