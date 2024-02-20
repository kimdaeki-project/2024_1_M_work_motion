<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <p>${detail.info}</p>
    <form action="./payment" method="post">
    <input type="hidden" name="price" value="${detail.price}">
     <input type="hidden" name="period" value="${detail.period}">
    <button type="submit" class="btn btn-primary">결제하기</button>
    </form>