<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<p>${detail.content}</p>

<a href="./update?id=${detail.id}"><button type="button" class="btn btn-primary">수정하기</button></a>

<form action="./delete" method="post">
<input type="hidden" value="${category_ID}" name="category_ID">
<button type="submit" class="btn btn-danger" name="id" value="${detail.id}">삭제하기</button>
</form>