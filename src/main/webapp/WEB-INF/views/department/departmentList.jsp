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
				<td><input type="hidden" value="${dto.id}" name="id" class="id">
					<input type="checkbox" class="checks"></td>
				<th scope="row">${dto.id}</th>
				<td><a href="./departmentDetail?id=${dto.id}">${dto.name}</a></td>
				<td>${dto.phone_num}</td>
				<td><a href="./departmentUpdate?id=${dto.id}"><button
							type="button" class="btn btn-primary">부서수정</button></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:if test="${pager.lastNum > 1}">
<nav aria-label="...">
	<ul class="pagination">

		<!-- 이전@@@@@@@@@@ -->
		<c:if test="${!pager.start} ">
			<li class="page-item"><a class="page-link"
				href="./departmentList?page=${pager.startNum-1}&search=${pager.search}">Previous</a></li>
		</c:if>

		<!-- 번호@@@@@@@@@@@@ -->
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link"
					href="./departmentList?page=${i}&search=${pager.search}">${i}</a></li>
		</c:forEach>
		<!-- 다음@@@@@@@@@@@@@@@ -->

		<c:if test="${!pager.last}">
			<li class="page-item"><a class="page-link"
				href="./departmentList?page=${pager.lastNum+1}&search=${pager.search}">Next</a></li>
		</c:if>
	</ul>
</nav>
</c:if>

<!-- 검색부분@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<form action="./departmentList">
	<div class="input-group mb-3">
		<input type="text" class="form-control" name="search"
			aria-label="Text input with dropdown button">
		<button class="btn btn-outline-secondary" type="submit">찾기</button>
	</div>
</form>


<!-- 검색부분@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<a href="./departmentCreate"><button type="button"
		class="btn btn-success">부서 추가</button></a>
<button type="button" id="deleteDepartment" class="btn btn-danger">부서
	삭제</button>
<script src="/resources/departmentjs/deletedepartment.js"></script>
