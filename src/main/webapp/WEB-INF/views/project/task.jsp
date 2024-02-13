<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css"
    integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc="
    crossorigin="anonymous"
/>
<link
    rel="stylesheet"
    href="/resources/css/project/createTask.css"
    type="text/css"
/>

<!-- fullcalendar CDN -->
<link
    href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css"
    rel="stylesheet"
/>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
<!-- fullcalendar 언어 CDN -->
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>

<style>
    /* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
    .fc-header-toolbar {
        padding-top: 1em;
        padding-left: 1em;
        padding-right: 1em;
    }
</style>
<style>
    #container {
        height: 100%;
        display: flex;
        width: 100%;
        flex-direction: row;
        font-family: "Noto Sans KR", sans-serif;
    }
    .section {
        width: 100%;
        overflow: scroll;
    }
    .section .projectInfo {
        width: 100%;
        background-color: white;
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
        margin-left: 10vh;
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
    #crewList {
        max-height: 31vh;
        overflow: auto;
    }
</style>
<div id="container">
    <div class="section">
        <div class="projectInfo mb-3" data-bs-projectId="${project.id}" data-bs-ownerId="${project.owner_id}">
            <div class="top p-3">
                <div class="head">
                    <span class="title"> ${project.name}</span>
                    <span class="info">${project.info}</span>
                </div>

                <div>
                    <a
                        class="btn btn-primary"
                        href="/projects/setting?id=${project.id}"
                        >설정</a
                    >
                    <a
                        class="btn btn-primary"
                        href="/tasks/create?id=${project.id}"
                        >업무 추가</a
                    >
                </div>
            </div>
            <div class="body">
                <ul class="nav nav-underline" role="tablist" id="pills-tab">
                    <li class="nav-item">
                        <a
                            class="nav-link active"
                            aria-current="page"
                            href="#"
                            role="tab"
                            aria-controls="pills-home"
                            aria-selected="true"
                            data-bs-toggle="pill"
                            data-bs-target="#pills-home"
                            id="homeButton"
                            >홈</a
                        >
                    </li>
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="#"
                            role="tab"
                            aria-controls="pills-task"
                            aria-selected="true"
                            data-bs-toggle="pill"
                            data-bs-target="#pills-task"
                            id="taskButton"
                            >업무</a
                        >
                    </li>
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="#"
                            role="tab"
                            aria-controls="pills-scadule"
                            aria-selected="true"
                            data-bs-toggle="pill"
                            data-bs-target="#pills-scadule"
                            id="scaduleButton"
                            >스케줄</a
                        >
                    </li>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <!-- end col-->
                <div class="col-xl-7 tab-content" id="pills-tabContent">
                    <div
                        class="tab-pane fade show active"
                        id="pills-home"
                        role="tabpanel"
                        aria-labelledby="pills-home-tab"
                    >
                        <div class="card">
                            <div class="card-body">
                                <!-- comment box -->
                                <form
                                    action="#"
                                    class="comment-area-box mb-3"
                                    id="articleForm"
                                >
                                    <!-- <input
                                    type="hidden"
                                    name="project_id"
                                    value="${project.id}"
                                /> -->
                                    <span class="input-icon">
                                        <textarea
                                            rows="3"
                                            class="form-control"
                                            placeholder="Write something..."
                                            id="summernote"
                                            name="content"
                                        ></textarea>
                                    </span>
                                    <div class="comment-area-btn">
                                        <div class="float-end">
                                            <button
                                                type="button"
                                                class="btn btn-sm btn-dark waves-effect waves-light"
                                                id="submitArticleButton"
                                            >
                                                Post
                                            </button>
                                        </div>
                                    </div>
                                </form>

                                <div id="article"></div>
                            </div>
                        </div>
                        <!-- end card-->
                    </div>

                    <div
                        class="tab-pane fade"
                        id="pills-task"
                        role="tabpanel"
                        aria-labelledby="pills-task-tab"
                    >
                        <div class="card">
                            <div class="card-body">
                                <!-- comment box -->

                                <!-- <input
                                    type="hidden"
                                    name="project_id"
                                    value="${project.id}"
                                /> -->
                                <div id="task"></div>

                            </div>
                        </div>
                        <!-- end card-->
                    </div>

                    <div
                        class="tab-pane fade"
                        id="pills-scadule"
                        role="tabpanel"
                        aria-labelledby="pills-scadule-tab"
                    >
                        <div class="card">
                            <div class="card-body">
                                <div id="scadule">
                                    <div id="calendar-container">
                                        <div id="calendar"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end card-->
                    </div>
                </div>
                <div class="col-xl-5">
                    <!-- end card-->
                    <div class="card">
                        <div class="card-body">
                            <h4 class="header-title mb-3">
                                그룹장
                                <i class="mdi mdi-account ms-1"></i>
                                <button
                                    class="btn btn-primary float-end"
                                    id="addCrewButton"
                                    data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop"
                                >
                                    멤버 추가
                                </button>
                            </h4>

                            <button
                                class="list-group-item list-group-item-action"
                                data-bs-toggle="modal"
                                data-bs-target="#profileModal"
                                data-bs-memberId="${owner.id}"
                                onclick="createProfile(${owner.id}, true)"
                            >
                                <div
                                    class="d-flex align-items-center pb-1"
                                    id="tooltips-container"
                                >
                                    <img
                                        src="${owner.avatar.name}"
                                        class="rounded-circle img-fluid avatar-md img-thumbnail bg-transparent"
                                        alt=""
                                    />
                                    <div class="w-100 ms-2">
                                        <h5 class="mb-1">
                                            ${owner.name}<i
                                                class="mdi mdi-check-decagram text-info ms-1"
                                            ></i>
                                        </h5>
                                        <p class="mb-0 font-13 text-muted">
                                            ${owner.position.name}
                                        </p>
                                    </div>
                                    <i class="mdi mdi-chevron-right h2"></i>
                                </div>
                            </button>
                            <h4 class="header-title mb-3 mt-3">
                                프로젝트 멤버
                                <i class="mdi mdi-account-multiple ms-1"></i>
                            </h4>

                            <div class="list-group" id="crewList">
                                <c:forEach items="${crews}" var="crew">
                                    <button
                                        class="list-group-item list-group-item-action"
                                        data-bs-toggle="modal"
                                        data-bs-target="#profileModal"
                                        data-bs-memberId="${crew.id}"
                                        onclick="createProfile(${crew.id})"
                                    >
                                        <div
                                            class="d-flex align-items-center pb-1"
                                            id="tooltips-container"
                                        >
                                                
                                            
                                            <img
                                            
                                            <c:if test="${crew.avatar.name != null}">
                                                src="${crew.avatar.name}"
                                            </c:if>
                                            <c:if test="${crew.avatar.name == null}">
                                                src="https://bootdey.com/img/Content/avatar/avatar5.png"
                                            </c:if>
                                                class="rounded-circle img-fluid avatar-md img-thumbnail bg-transparent"
                                                alt=""
                                            />
                                            <div class="w-100 ms-2">
                                                <h5 class="mb-1">
                                                    ${crew.name}<i
                                                        class="mdi mdi-check-decagram text-info ms-1"
                                                    ></i>
                                                </h5>
                                                <p
                                                    class="mb-0 font-13 text-muted"
                                                >
                                                    ${crew.position.name}
                                                </p>
                                            </div>
                                            <i
                                                class="mdi mdi-chevron-right h2"
                                            ></i>
                                        </div>
                                    </button>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="dropdown float-end">
                                <a
                                    href="#"
                                    class="dropdown-toggle arrow-none card-drop"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false"
                                >
                                    <i class="mdi mdi-dots-vertical"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end">
                                    <!-- item-->
                                    <a
                                        href="javascript:void(0);"
                                        class="dropdown-item"
                                        >Sales Report</a
                                    >
                                    <!-- item-->
                                    <a
                                        href="javascript:void(0);"
                                        class="dropdown-item"
                                        >Export Report</a
                                    >
                                    <!-- item-->
                                    <a
                                        href="javascript:void(0);"
                                        class="dropdown-item"
                                        >Profit</a
                                    >
                                    <!-- item-->
                                    <a
                                        href="javascript:void(0);"
                                        class="dropdown-item"
                                        >Action</a
                                    >
                                </div>
                            </div>

                            <h4 class="header-title mb-3">
                                Upcoming Reminders
                                <i class="mdi mdi-adjust ms-1"></i>
                            </h4>

                            <div class="list-group">
                                <a href="#" class="my-1">
                                    <div
                                        class="d-flex align-items-start"
                                        id="tooltips-container"
                                    >
                                        <div class="">
                                            <i
                                                class="mdi mdi-circle h3 text-primary"
                                            ></i>
                                        </div>
                                        <div class="w-100 ms-2">
                                            <h5 class="mb-1 mt-0">
                                                New Admin Layout Discuss
                                            </h5>
                                            <ul
                                                class="list-inline text-muted font-12"
                                            >
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-calendar-blank-outline me-1"
                                                    ></i
                                                    >10 May 2021
                                                </li>
                                                <li class="list-inline-item">
                                                    -
                                                </li>
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-clock-time-eight-outline me-1"
                                                    ></i
                                                    >09:00am
                                                    <span class="px-1">To</span>
                                                    10:30am
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="my-1">
                                    <div
                                        class="d-flex align-items-start"
                                        id="tooltips-container"
                                    >
                                        <div class="">
                                            <i
                                                class="mdi mdi-circle h3 text-pink"
                                            ></i>
                                        </div>
                                        <div class="w-100 ms-2">
                                            <h5 class="mb-1 mt-0">
                                                Landing Pages Planning
                                            </h5>
                                            <ul
                                                class="list-inline text-muted font-12"
                                            >
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-calendar-blank-outline me-1"
                                                    ></i
                                                    >10 May 2021
                                                </li>
                                                <li class="list-inline-item">
                                                    -
                                                </li>
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-clock-time-eight-outline me-1"
                                                    ></i
                                                    >02:00pm
                                                    <span class="px-1">To</span>
                                                    4:00pm
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="my-1">
                                    <div
                                        class="d-flex align-items-start"
                                        id="tooltips-container"
                                    >
                                        <div class="">
                                            <i
                                                class="mdi mdi-circle h3 text-success"
                                            ></i>
                                        </div>
                                        <div class="w-100 ms-2">
                                            <h5 class="mb-1 mt-0">
                                                Meet Our Clients
                                            </h5>
                                            <ul
                                                class="list-inline text-muted font-12"
                                            >
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-calendar-blank-outline me-1"
                                                    ></i
                                                    >11 May 2021
                                                </li>
                                                <li class="list-inline-item">
                                                    -
                                                </li>
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-clock-time-eight-outline me-1"
                                                    ></i
                                                    >08:00am
                                                    <span class="px-1">To</span>
                                                    11:20am
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="my-1">
                                    <div
                                        class="d-flex align-items-start"
                                        id="tooltips-container"
                                    >
                                        <div class="">
                                            <i
                                                class="mdi mdi-circle h3 text-warning"
                                            ></i>
                                        </div>
                                        <div class="w-100 ms-2">
                                            <h5 class="mb-1 mt-0">
                                                Project Discussion
                                            </h5>
                                            <ul
                                                class="list-inline text-muted font-12"
                                            >
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-calendar-blank-outline me-1"
                                                    ></i
                                                    >11 May 2021
                                                </li>
                                                <li class="list-inline-item">
                                                    -
                                                </li>
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-clock-time-eight-outline me-1"
                                                    ></i
                                                    >12:00am
                                                    <span class="px-1">To</span>
                                                    03:00am
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </a>
                                <a href="#" class="my-1">
                                    <div
                                        class="d-flex align-items-start"
                                        id="tooltips-container"
                                    >
                                        <div class="">
                                            <i
                                                class="mdi mdi-circle h3 text-dark"
                                            ></i>
                                        </div>
                                        <div class="w-100 ms-2">
                                            <h5 class="mb-1 mt-0">
                                                Businees Meeting
                                            </h5>
                                            <ul
                                                class="list-inline text-muted font-12"
                                            >
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-calendar-blank-outline me-1"
                                                    ></i
                                                    >12 May 2021
                                                </li>
                                                <li class="list-inline-item">
                                                    -
                                                </li>
                                                <li class="list-inline-item">
                                                    <i
                                                        class="mdi mdi-clock-time-eight-outline me-1"
                                                    ></i
                                                    >08:30am
                                                    <span class="px-1">To</span>
                                                    10:00am
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end col -->
            </div>
            <!-- end row-->
        </div>
        <!-- <div class="article">
            <div class="content mt-3" id="taskContentSection">
                <c:forEach items="${tasks}" var="task">
                    <div class="taskCard">
                        <div class="cardHead">
                            <span class="title">${task.name}</span>
                            <span class="date">${task.create_dt}</span>
                        </div>
                        <hr>
                        <div class="cardBody">${task.content}</div>
                    </div>
                </c:forEach>
            </div>
            <div class="side d-none d-xl-block overflow-auto" id="projectMemberList">
                <c:forEach items="${crews}" var="crew">
                    <div class="memberCard">
                        <div class="avatar">
                        </div>
                        <div class="info">
                            <div class="name">${crew.name}</div>
                            <div class="role">${crew.position.name}</div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div> -->
    </div>
</div>

<!-- Modal -->
<div
    class="modal fade"
    id="staticBackdrop"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
>
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">
                    멤버 추가
                </h1>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                ></button>
            </div>
            <div class="modal-body" id="modalBody"></div>
            <div class="modal-footer">
                <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                >
                    닫기
                </button>
                <button
                    type="button"
                    class="btn btn-primary"
                    id="submitButton"
                    data-bs-dismiss="modal"
                >
                    추가하기
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div
    class="modal fade"
    id="profileModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="profileModal"
    aria-hidden="true"
>
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="profileModal">프로필</h1>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                ></button>
            </div>
            <div class="modal-body" id="profileBody"></div>
            <div class="modal-footer">
                <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                >
                    닫기
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div
    class="modal fade"
    id="calandarModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    style="z-index: 10000"
    aria-labelledby="calandarModalLabel"
    aria-hidden="true"
>
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">일정</h1>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                ></button>
            </div>
            <div class="modal-body" id="calandarModalBody"></div>
            <div class="modal-footer">
                <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                >
                    닫기
                </button>
                <button
                    type="button"
                    class="btn btn-primary"
                    id="deleteEventButton"
                    data-bs-dismiss="modal"
                >
                    삭제하기
                </button>
            </div>
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

<script></script>
