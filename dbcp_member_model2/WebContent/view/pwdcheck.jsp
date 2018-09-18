<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//정보를 가져와야 하는지 탈퇴를 위한 비밀번호를 확인해야 하는지 결정
	//cmd=check 이면 비밀번호 확인 후 정보 가져오기
	//cmd=leave 이면 비밀번호 확인 후 탈퇴 시키기
	String cmd=request.getParameter("cmd");

	//session 정보에서 아이디만 추출
	MemberVO vo=(MemberVO)session.getAttribute("vo");
	String id=vo.getUserid();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="../pwdCheck.do">
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid" value="<%=id%>" readonly><br>
		<label for="password">비밀번호 확인</label>
		<input type="password" name="password" id="password" required="required" autofocus><br>
		<input type="hidden" name="cmd" value="<%=cmd%>">		
		<input type="submit" value="확인">
	</form>
</body>
</html>





