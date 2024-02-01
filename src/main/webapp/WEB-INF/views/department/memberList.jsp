<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">편집</th>
			<th scope="col">부서번호</th>
			<th scope="col">사원번호</th>
			<th scope="col">사원이름</th>
			<th scope="col">사원이메일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto" varStatus="status">
			<tr>
				<td><input type="checkbox" name="check" id="check"></td>
				<td>${dto. }</td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>