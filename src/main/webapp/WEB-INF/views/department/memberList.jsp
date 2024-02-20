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
		<input type="hidden" id="department_id"
			value="${member.department_id}">
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
<c:if test="${pager.lastNum > 1}">
<nav aria-label="...">
	<ul class="pagination">

		<!-- 이전@@@@@@@@@@ -->
			<c:if test="${!pager.start}">
				<li class="page-item"><a class="page-link"
					href="./memberList?department_id=${member.department_id}&page=${pager.startNum-1}&search=${pager.search}">Previous</a>
				</li>
			</c:if>
		

		<!-- 번호@@@@@@@@@@@@ -->
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link"
				href="./memberList?department_id=${member.department_id}&page=${i}&search=${pager.search}">${i}</a></li>
		</c:forEach>

		<!-- 다음@@@@@@@@@@@@@@@ -->
			<c:if test="${!pager.last}">
				<li class="page-item"><a class="page-link"
					href="./memberList?department_id=${member.department_id}&page=${pager.lastNum+1}&search=${pager.search}">Next</a></li>
			</c:if>
	</ul>
</nav>
</c:if>


<!-- 검색@@@@@@@@@@@@@@@@ -->
<form action="./memberList">
	<div class="input-group mb-3">
		<input type="text" width="200px" name="search"
			aria-label="Text input with dropdown button"> <input
			type="hidden" value="${member.department_id}" name="department_id">
		<button class="btn btn-outline-secondary" type="submit">찾기</button>
	</div>
</form>


<button type="button" id="createbtn" class="btn btn-success">추가하기</button>
<script src="/resources/departmentjs/createmember.js"></script>