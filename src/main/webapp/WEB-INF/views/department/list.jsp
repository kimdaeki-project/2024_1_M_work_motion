<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
  <thead>
    <tr>
      <th scope="col">부서번호</th>
      <th scope="col">부서이름</th>
      <th scope="col">부서전화번호</th>
      <th>수정</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="dto">
    <tr>
      <th scope="row">${dto.id}</th>
      <td><a href="./detail?id=${dto.id}">${dto.name}</a></td>
      <td>${dto.phone_num}</td>
     <td><a href="./update?id=${dto.id}"><button type="button">부서수정</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
    <a href="./create"><button type="button">부서 추가</button></a>
