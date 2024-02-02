<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">편집</th>
			<th scope="col">부서이름</th>
			<th scope="col">사원번호</th>
			<th scope="col">사원이름</th>
			<th scope="col">사원이메일</th>
		</tr>
	</thead>
	<tbody>
				<input type="hidden" id="department_id" value="${member.department_id}">
		<c:forEach items="${list}" var="member">
			<tr>
				<input type="hidden" value="${member.ID}" class="member_id">
				<td><input type="checkbox" class="check"></td>
				<td>${member.DEPARTMENT_NAME}</td>
				<td>${member.ID}</td>
				<td>${member.NAME}</td>
				<td>${member.EMAIL}</td>
			</tr>
		</c:forEach>

	</tbody>
</table>

<button type="button" id="createbtn">추가하기</button>
<button type="button" id="deletebtn">삭제하기</button>

<script src="/resources/departmentjs/department.js"></script>