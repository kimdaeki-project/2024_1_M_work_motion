<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<style>
    #container {
        height: 100%;
        display: flex;
        width: 100%;
        flex-direction: row;
        font-family: "Noto Sans KR", sans-serif;
    }
    .sideNav {
        display: flex;
        flex-direction: column;
        height: 100%;
        background-color: #fbeef0;
        color: #515151;
    }
    .sideNav .dashboard span {
        font-size: xx-large;
    }
    .sideNav .myProject span {
        font-size: large;
    }
    .sideNav .comProject span {
        font-size: large;
    }
    .section {
        width: 100%;
        overflow: scroll;
    }
    .section .projectInfo {
        width: 100%;
    }
    .section .projectInfo .top {
        display: flex;
        justify-content: space-between;
    }
    .section .projectInfo .head {
        display: flex;
        flex-direction: column;
    }
    .section .projectInfo .body {
        margin: 0px;
        display: flex;
        margin-left: 4vh;
    }
    .section .projectInfo .body a {
        margin-right: 2vh;
        text-decoration: none;
    }
    .section .projectInfo .body a:link {
        color: black;
    }
    .section .projectInfo .body a:visited {
        color: black;
    }

    .section .title {
        font-size: xx-large;
        font-weight: 900;
    }
    .article {
        display: flex;
        justify-content: space-around;
        background-color: #f5f4f4;
    }
    .article #taskContentSection {
        min-width: 60%;
    }
    .article .side {
        background-color: white;
        margin-top: 100px;
        width: 40vh;
        height: 500px;
    }
    .taskCard {
        background-color: white;
        margin: 10px;
        border-radius: 20px;
        border: 1px solid #c8c8c882;
    }
    .taskCard .cardHead {
        display: flex;
        flex-direction: column;
        padding: 10px;
    }
    .taskCard .cardBody {
        padding: 10px;
    }
</style>
<div id="container">
    <div class="sideNav p-4 col-2">
        <div class="dashboard">
            <span>대시보드</span>
        </div>
        <div class="myProject">
            <span>내 프로젝트</span>
        </div>
        <div class="comProject">
            <span>공통 프로젝트</span>
        </div>
    </div>
    <div class="section">
        <div class="projectInfo" data-bs-projectId="${project.id}">
            <div class="top p-3">
                <div class="head">
                    <span class="title"> ${project.name}</span>
                    <span class="info">${project.info}</span>
                </div>
                <div>
                    <button class="btn btn-primary">멤버 추가</button>
                </div>
            </div>
            <div class="body pl-2">
                <a href="#" class="ml-4">홈</a>
                <a href="#">업무</a>
                <a href="#">스케줄</a>
            </div>
        </div>
        <div class="article">
            <div class="content mt-3" id="taskContentSection">
                <span style="padding:10px">전체</span>
                <c:forEach items="${list}" var="item">
                    <div class="taskCard">
                        <div class="cardHead">
                            <span class="title">${item.name}</span>
                            <span class="date">${item.create_dt}</span>
                        </div>
                        <hr>
                        <div class="cardBody">${item.content}</div>
                    </div>
                </c:forEach>
                <c:forEach items="${list}" var="item">
                    <div class="taskCard">
                        <div class="cardHead">
                            <span class="title">${item.name}</span>
                            <span class="date">${item.create_dt}</span>
                        </div>
                        <div class="cardBody">${item.content}</div>
                    </div>
                </c:forEach>
                <c:forEach items="${list}" var="item">
                    <div class="taskCard">
                        <div class="cardHead">
                            <span class="title">${item.name}</span>
                            <span class="date">${item.create_dt}</span>
                        </div>
                        <div class="cardBody">${item.content}</div>
                    </div>
                </c:forEach>
                <c:forEach items="${list}" var="item">
                    <div class="taskCard">
                        <div class="cardHead">
                            <div class="profile">
                            </div>
                            <span class="title">${item.name}</span>
                            <span class="date">${item.create_dt}</span>
                        </div>
                        <div class="cardBody">${item.content}</div>
                    </div>
                </c:forEach>
            </div>
            <div class="side d-none d-xl-block" id="projectMemberList"></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/js/task.js"></script>
<script type="text/javascript">
    //높이 리사이즈
    const taskContentSeciton = document.getElementById("container");
    const firstHeight = window.innerHeight;
    container.style.height = firstHeight - 125 + "px";

    let currentProject = null;

    window.addEventListener("resize", () => {
        const afterHeight = window.innerHeight;
        const diff = afterHeight - firstHeight;
        const parent = document.getElementById("container").parentElement;
        container.style.height = firstHeight + diff - 125 + "px";
    });
</script>
