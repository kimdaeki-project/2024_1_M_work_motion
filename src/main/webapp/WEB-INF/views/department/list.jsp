<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">부서이름</th>
			<th scope="col">부서번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto" varStatus="status">
			<tr>
				<th scope="row">${status.count}</th>
				<td><a href="./detail?id=${dto.id}">${dto.name}</a></td>
				<td>${dto.phone_num}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<nav aria-label="Page navigation example">
	<ul class="pagination">
		<!-- 이전으로@@@@@@@@@@@@@@@@@@@@@@@ -->
		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			
		<!-- 숫자@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
		<c:forEach begin="${pager.startRow}" end="${pager.lastRow}" var="i">
		<li class="page-item"><a class="page-link" href="#">${i}</a></li>
		</c:forEach>
		
		<!-- 다음으로@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</nav>