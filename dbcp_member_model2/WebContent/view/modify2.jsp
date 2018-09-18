<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request 정보 추출
	MemberVO vo=(MemberVO)request.getAttribute("vo");
	String userid=null,name=null,gender=null,email=null;
	if(vo!=null){
		userid=vo.getUserid();
		name=vo.getName();	
		gender=vo.getGender();
		email=vo.getEmail();	
	}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
<script src="js/jquery-3.3.1.slim.min.js"></script>
<script>
  $(function(){
	 $("document").ready(function(){
		var gender='<%=gender%>';		
		$("input[value="+gender+"]").attr("checked",true);		
	 }); 
  });
</script>
</head>
<body>
	<form id="modifyform" action="update.do" method="post">	
	<table>
		<tr>
			<td><label for="userid">아이디</label></td>
			<td><input type="text" name="userid" id="userid" 
			autofocus value="<%=userid%>" readonly>
			<small id="userid" class="text-info"></small>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="password">
			<small id="password" class="text-info"></small>	
			</td>
		</tr>
		<tr>
			<td>비밀번호 변경</td>
			<td><input type="password" name="confirm_password" id="confirm_password">
			<small id="confirm_password" class="text-info"></small>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name" value="<%=name%>" readonly>
			<small id="name" class="text-info"></small>
			</td>
		</tr>
		<tr>
			<td>성별</td>			
			<td>
				<input type="radio" name="gender" value="남" id="gender" class="gender" disabled>남
				<input type="radio" name="gender" value="여" class="gender" disabled>여			
				<small id="gender" class="text-info"></small>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="email" name="email" id="email" value="<%=email%>">
				<small id="email" class="text-info"></small>
			</td>
		</tr>
		<tr>			
			<td colspan="2">
				<input type="submit" value="정보수정">
				<input type="button" value="취소">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>