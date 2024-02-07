<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">사원번호</th>
			<th scope="col">사원이름</th>
			<th scope="col">사원이메일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		</tr>
		<c:forEach items="${detail}" var="dto" varStatus="status">
			<tr>
				<th scope="row">${status.count}</th>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- 페이징@@@@@@@@@@@@@@@ -->
<c:if test="${pager.lastNum > 1}">
<nav aria-label="...">
	<ul class="pagination">
	
		<!-- 이전@@@@@@@@@@ -->
		<c:if test="${!pager.start}">
		<li class="page-item" ><a class="page-link" href="./departmentDetail?id=${member.department_id}&page=${pager.startNum-1}&search=${pager.search}">Previous</a>
		</li>
		</c:if>
		
		<!-- 번호@@@@@@@@@@@@ -->
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<li class="page-item"><a class="page-link" href="./departmentDetail?id=${member.department_id}&page=${i}&search=${pager.search}">${i}</a></li>
		</c:forEach>
		<!-- 다음@@@@@@@@@@@@@@@ -->
		
		<c:if test="${!pager.last}">
		<li class="page-item"><a class="page-link" href="./departmentDetail?id=${member.department_id}&page=${pager.lastNum+1}&search=${pager.search}">Next</a></li>
		</c:if>
	</ul>
</nav>
</c:if>

<!-- 검색@@@@@@@@@@@@@@@@ -->
<form action="./departmentDetail">
	<div class="input-group mb-3">
		<input type="text" class="form-control" name="search"
			aria-label="Text input with dropdown button">
			<input type="hidden" value="${member.department_id}" name="id">
		<button class="btn btn-outline-secondary" type="submit">찾기</button>
	</div>
</form>

<div>
	<a href="./memberupdate?department_id=${member.department_id}"><button
			type="button" class="btn btn-success">수정하기</button></a>
</div>