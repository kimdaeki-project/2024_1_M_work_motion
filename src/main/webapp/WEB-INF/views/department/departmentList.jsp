<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<table class="table">
		<thead>
			<tr>
				<th>편집</th>
				<th scope="col">부서번호</th>
				<th scope="col">부서이름</th>
				<th scope="col">부서전화번호</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
				<td>
				<input type="hidden" value="${dto.id}" name="id" class="id">
				<input type="checkbox" class="checks">
				</td>
					<th scope="row">${dto.id}</th>
					<td><a href="./departmentDetail?id=${dto.id}">${dto.name}</a></td>
					<td>${dto.phone_num}</td>
					<td><a href="./departmentUpdate?id=${dto.id}"><button type="button" class="btn btn-primary">부서수정</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./departmentCreate"><button type="button" class="btn btn-success">부서 추가</button></a>
	<button type="button" id="deleteDepartment" class="btn btn-danger">부서 삭제</button>
	<script src="/resources/departmentjs/deletedepartment.js"></script>
