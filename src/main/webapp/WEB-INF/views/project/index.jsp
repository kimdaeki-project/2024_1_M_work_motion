<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<style type="text/css"></style>

<div class="container mt-1">
    <div class="d-flex flex-row">
        <div class="list-group" data-bs-spy="scroll">
            <c:forEach items="${list}" var="item">
                <div class="card mb-3" style="width: 18rem">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.info}</p>
                    </div>
                </div>
            </c:forEach>
            <c:forEach items="${list}" var="item">
                <div class="card mb-3" style="width: 18rem">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.info}</p>
                    </div>
                </div>
            </c:forEach>
            <c:forEach items="${list}" var="item">
                <div class="card mb-3" style="width: 18rem">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.info}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
