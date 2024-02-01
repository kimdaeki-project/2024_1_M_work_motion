<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<style type="text/css">
    #container {
        display: flex;
        width: 100%;
        justify-content: center;
        flex-direction: column;
        padding: 20px;
    }
    #projectList {
        display: flex;
        flex-direction: row;
    }
    .projectCard {
        margin: 10px;
        text-decoration: none;
    }
</style>

<div id="container">
    <h1>프로젝트</h1>
    <h2>나의 프로젝트</h2>
    <div style="background-color: #2e3337" id="projectList">
        <c:forEach items="${list}" var="item">
            <a href="/projects/${item.id}/tasks" class="projectCard">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.info}</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
    <h2>공통 프로젝트</h2>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>

<!-- 윈도우 사이즈 변경할 때 프로젝트 리스트 높이 조절 -->
<script src="/resources/js/project.js"></script>
