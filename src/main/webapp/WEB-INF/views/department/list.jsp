<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">부서이름</th>
      <th scope="col">부서전화번호</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach varStatus="status" step="1" items="${list}" var="dto">
    <tr>
      <th scope="row">${status.index }</th>
      <td><a href="./detail?id=${dto.id}">${dto.name}</a></td>
      <td>${dto.phone_num}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>