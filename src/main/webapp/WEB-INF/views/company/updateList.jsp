<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th>편집</th>
			<th scope="col">회사번호</th>
			<th scope="col">회사이름</th>
			<th scope="col">회사대표이름</th>
			<th scope="col">회사전화번호</th>
			<th>수정하기</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
		<input type="hidden" value="${dto.id}" class="cid"></td> 
				<td><input type="checkbox" class="companycheck"></td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.owner}</td>
				<td>${dto.phone_num}</td>
				<td><a href="./update?id=${dto.id}"><button type="button" class="btn btn-primary">회사수정</button></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="./create">
<button type="button" class="btn btn-primary">회사추가하기</button></a>

<button type="button" id="companybtn" class="btn btn-danger">회사삭제하기</button>

<script src="/resources/company/companydelete.js"></script>


