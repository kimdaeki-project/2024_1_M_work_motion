<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	
	<form class="form-control" id="form" method="POST" action="../document/add" enctype="multipart/form-data">
	<c:import url="/resources/upload/templete/${dto.name}"></c:import>
	
    <div class="button-container">
    
           <button name="svae" value="1">보내기</button>
           <button name="save" value="0">임시저장</button>
           
    </div>    	
	</form>	
</body>
</html>