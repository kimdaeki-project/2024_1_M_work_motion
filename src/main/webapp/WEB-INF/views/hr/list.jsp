<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="container-fluid px-4">
	<h1 class="mt-4">Hr List</h1>
	<div class="card mb-4">  
	</div>
	<div class="card mb-4">
		<div class="card-header">
			<i class="fas fa-table me-1"></i>
			 Hr List
		</div>
		<div class="card-body">
			<table class="table table-bordered table-hover">
			<thead>
				<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Email</th>
				<th>Department</th>
				<th>PhoneNumber</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="li">
				<tr>
				<td><a href="" >${li.NAME}</a></td>
				<td>${li.PNAME}</td>
				<td>${li.EMAIL}</td>
				<td>${li.DNAME}</td>
				<td>${li.PHONE}</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
		<nav aria-label="Page navigation example">
		
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="/hr/list?page=${pager.lastNum-1}">Previous</a></li>


				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="p">
				<li class="page-item"><a class="page-link" href="/hr/list?page=${p}">${p}</a></li>
				</c:forEach>	


				<li class="page-item"><a class="page-link" href="/hr/list?page=${pager.lastNum+1}">Next</a></li>
			</ul>


		</nav>
	</div>
</div>


