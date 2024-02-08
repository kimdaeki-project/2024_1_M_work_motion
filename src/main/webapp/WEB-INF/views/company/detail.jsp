<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">회사이름</th>
			<th scope="col">회사정보</th>
			<th scope="col">회사전화번호</th>
			<th scope="col">회사대표</th>
			<th scope="col">회사사원의수</th>
			<th scope="col">회사개설일</th>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${detail.name}</td>
			<td>${detail.info}</td>
			<td>${detail.phone_num}</td>
			<td>${detail.owner}</td>
			<td>${member}</td>
			<td>${detail.create_dt}</td>
		</tr>
	</tbody>
</table>
