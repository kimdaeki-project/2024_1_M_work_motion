<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">편집</th>
			<th scope="col">사원번호</th>
			<th scope="col">사원이름</th>
			<th scope="col">사원이메일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<input type="hidden" id="department_id" value="${member.department_id}">
		</tr>
		<c:forEach items="${detail}" var="dto" varStatus="status">
			<tr>
				<input type="hidden" value="${dto.id}" class="member_id">
				<td><input type="checkbox" class="check"></td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="./memberList?department_id=${member.department_id}"><button type="button" class="btn btn-success">사원 추가하기</button></a>
<button type="button" id="deletebtn" class="btn btn-danger">사원 삭제하기</button>
<script src="/resources/departmentjs/deletemember.js"></script>