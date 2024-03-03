<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/resources/js/board/boardStyle.css" rel="stylesheet" />

<div style="height: 100px; text-align: center;">
	<h1 style="height: 50px;"></h1>
<h2>${detail.title}</h2>
</div>

<div class="mb-3"
	style="width: 100%; border: 1; margin-left: 70px; width: 90%;">
	<textarea style="width: 1100px; heigth: 1000;" id="content" readonly="readonly"
		name="content" rows="25" cols="30">${detail.content}</textarea>
</div>


<a href="./update?id=${detail.id}"><button style=" margin-left: 70px;" type="button"
		class="btn btn-primary">수정하기</button></a>

<form action="./delete" method="post">
	<input type="hidden" value="${category_ID}" name="category_ID">
	<button type="submit" class="btn btn-danger" style=" margin-left: 70px;" name="id"
		value="${detail.id}">삭제하기</button>
</form>