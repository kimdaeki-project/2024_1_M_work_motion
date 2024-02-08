<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th>편집</th>
			<th scope="col">회사번호</th>
			<th scope="col">회사이름</th>
			<th scope="col">회사대표이름</th>
			<th scope="col">회사전화번호</th>
			<th>수정하기</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<input type="hidden" value="${dto.id}" class="cid">
				</td>
				<td><input type="checkbox" class="companycheck"></td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.owner}</td>
				<td>${dto.phone_num}</td>
				<td><a href="./update?id=${dto.id}"><button type="button"
							class="btn btn-primary">회사수정</button></a></td>
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
					href="./updateList?search=${pager.search}&page=${pager.lastNum+1}">Previous</a>
				</li>
			</c:if>


			<!-- 번호@@@@@@@@@@@@ -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link"
					href="./updateList?page=${i}&search=${pager.search}">${i}</a></li>
			</c:forEach>

			<!-- 다음@@@@@@@@@@@@@@@ -->
			<c:if test="${!pager.last}">
				<li class="page-item"><a class="page-link"
					href="./updateList?page=${pager.lastNum+1}&search=${pager.search}">Next</a></li>
			</c:if>
		</ul>
	</nav>
</c:if>


<!-- 검색@@@@@@@@@@@@@@@@ -->
<form action="./updateList">
	<div class="input-group mb-3">
		<input type="text" class="form-control" name="search"
			aria-label="Text input with dropdown button">
		<button class="btn btn-outline-secondary" type="submit">찾기</button>
	</div>
</form>

<a href="./create">
	<button type="button" class="btn btn-primary">회사추가하기</button>
</a>

<button type="button" id="companybtn" class="btn btn-danger">회사삭제하기</button>

<script src="/resources/company/companydelete.js"></script>


