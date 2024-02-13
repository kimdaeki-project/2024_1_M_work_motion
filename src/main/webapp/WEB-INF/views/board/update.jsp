<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="./update" method="post">
	<div class="mb-3">
		<label for="title" class="form-label">게시판제목</label> <input value="${update.title}" name="title"
			type="text" class="form-control" id="title">
	</div>
	<div class="mb-3">
		<label for="content" class="form-label">게시판내용</label>
		<textarea class="form-control" style="width: 100%;" id="content" name="content" 
			rows="3">${update.content}</textarea>
	</div>
	<input type="hidden" name="id" value="${update.id}">
	<button type="submit" class="btn btn-primary">수정하기</button>
</form>

