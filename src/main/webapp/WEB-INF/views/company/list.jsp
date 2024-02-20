<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty member}">
<script>
alert("로그인 하셔야 이용 가능합니다")
location.href="/member/login"
</script>
</c:if>
<c:if test="${empty check}">
<script>
alert("구독 하셔야 이용가능합니다")
location.href="/product/list"
</script>
</c:if>
<table class="table">
	<thead>
		<tr>
			<th scope="col">회사번호</th>
			<th scope="col">회사이름</th>
			<th scope="col">회사정보</th>
			<th scope="col">회사대표이름</th>
			<th scope="col">회사전화번호</th>s
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

<c:if test="${pager.lastNum > 1}">
	<nav aria-label="...">
		<ul class="pagination">

			<!-- 이전@@@@@@@@@@ -->
			<c:if test="${!pager.start}">
				<li class="page-item"><a class="page-link"
					href="./list?search=${pager.search}&page=${pager.lastNum+1}">Previous</a>
				</li>
			</c:if>


			<!-- 번호@@@@@@@@@@@@ -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link"
					href="./list?page=${i}&search=${pager.search}">${i}</a></li>
			</c:forEach>

			<!-- 다음@@@@@@@@@@@@@@@ -->
			<c:if test="${!pager.last}">
				<li class="page-item"><a class="page-link"
					href="./list?page=${pager.lastNum+1}&search=${pager.search}">Next</a></li>
			</c:if>
		</ul>
	</nav>
</c:if>


<!-- 검색@@@@@@@@@@@@@@@@ -->
<form action="./list">
	<div class="input-group mb-3">
		<input type="text" class="form-control" name="search"
			aria-label="Text input with dropdown button">
		<button class="btn btn-outline-secondary" type="submit">찾기</button>
	</div>
</form>

<a href="./updateList"><button type="button" class="btn btn-primary">수정하기</button></a>

