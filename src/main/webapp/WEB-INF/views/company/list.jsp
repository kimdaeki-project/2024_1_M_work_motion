<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">회사번호</th>
			<th scope="col">회사이름</th>
			<th scope="col">회사정보</th>
			<th scope="col">회사대표이름</th>
			<th scope="col">회사전화번호</th>
			<th scope="col">회사개설일</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id}</td>
				<td><a href="./detail?id=${dto.id}">${dto.name}</a></td>
				<td>${dto.info}</td>
				<td>${dto.owner}</td>
				<td>${dto.phone_num}</td>
				<td>${dto.create_dt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="./updateList"><button type="button" class="btn btn-primary">수정하기</button></a>

