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
    #container .header {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
    }
    #projectList,
    #comProjectList {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
    }
    .projectCard {
        margin: 10px;
        text-decoration: none;
    }
    .card {
        transition: 0.2s;
    }
    .card:hover {
        transform: scale(1.02);
    }
    .card-body {
        height: 10vh;
        width: 15vh;
    }
</style>

<div id="container">
    <div class="header mb-3">
        <h1>프로젝트</h1>
        <a type="button" class="btn btn-primary" href="/projects/create"
            >프로젝트 추가</a
        >
    </div>

    <h2 class="mb-3">나의 프로젝트</h2>
    <div id="projectList">
        <c:forEach items="${myProjects}" var="project">
            <a href="/projects/detail?id=${project.id}" class="projectCard">
                <div class="card shadow mb-1 bg-body-tertiary rounded">
                    <div class="card-body">
                        <h5 class="card-title">${project.name}</h5>
                        <p class="card-text">${project.info}</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
    <h2>참여중인 프로젝트</h2>
    <div id="comProjectList">
        <c:forEach items="${includeProjects}" var="project">
            <a href="/projects/detail?id=${project.id}" class="projectCard">
                <div class="card shadow mb-1 bg-body-tertiary rounded">
                    <div class="card-body">
                        <h5 class="card-title">${project.name}</h5>
                        <p class="card-text">${project.info}</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>

<!-- 윈도우 사이즈 변경할 때 프로젝트 리스트 높이 조절 -->
<script src="/resources/js/project/project.js"></script>
