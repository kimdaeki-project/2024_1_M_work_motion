<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
    <label>1개월구독하기 : </label>
    <input type="radio" class="payment" name="payment" value="19900"><br>
    <label>3개월구독하기 : </label>
    <input type="radio" class="payment" name="payment" value="29900"><br>
    <label>6개월구독하기 : </label>
    <input type="radio" class="payment" name="payment" value="49900"><br>
    <label>12개월구독하기 : </label>
    <input type="radio" class="payment" name="payment" value="89900"><br>
  
<button type="button" id="apibtn">결제하기</button>

<script src="/resources/js/api/tossjsp.js"></script>