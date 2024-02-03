<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<link
    rel="stylesheet"
    href="/resources/css/project/setting.css"
    type="text/css"
/>
<div
    class="container p-0 pt-3"
    id="container"
    data-bs-projectId="${project.id}"
>
    <h1 class="h3 mb-3">프로젝트 설정</h1>
    <div class="row">
        <div class="col-md-5 col-xl-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title mb-0">메뉴</h5>
                </div>

                <div
                    class="list-group list-group-flush nav nav-pills"
                    role="tablist"
                    id="pills-tab"
                >
                    <a
                        class="list-group-item list-group-item-action active"
                        href="#account"
                        role="tab"
                        aria-controls="pills-home"
                        aria-selected="true"
                        data-bs-toggle="pill"
                        data-bs-target="#pills-home"
                    >
                        기본 설정
                    </a>
                    <a
                        class="list-group-item list-group-item-action"
                        aria-controls="pills-member"
                        aria-selected="true"
                        data-bs-toggle="pill"
                        data-bs-target="#pills-member"
                        href="#member"
                        role="tab"
                    >
                        멤버
                    </a>
                    <a
                        class="list-group-item list-group-item-action"
                        aria-controls="pills-home"
                        aria-selected="true"
                        data-bs-toggle="pill"
                        data-bs-target="#pills-home"
                        href="#delete"
                        role="tab"
                    >
                        프로젝트 삭제
                    </a>
                </div>
            </div>
        </div>

        <div class="col-md-7 col-xl-8">
            <div class="tab-content" id="pills-tabContent">
                <div
                    class="tab-pane fade show active"
                    id="pills-home"
                    role="tabpanel"
                    aria-labelledby="pills-home-tab"
                >
                    <div class="card">
                        <div class="card-header">
                            <div class="card-actions float-right">
                                <div class="dropdown show">
                                    <a
                                        href="#"
                                        data-toggle="dropdown"
                                        data-display="static"
                                    >
                                        <svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            width="24"
                                            height="24"
                                            viewBox="0 0 24 24"
                                            fill="none"
                                            stroke="currentColor"
                                            stroke-width="2"
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            class="feather feather-more-horizontal align-middle"
                                        >
                                            <circle
                                                cx="12"
                                                cy="12"
                                                r="1"
                                            ></circle>
                                            <circle
                                                cx="19"
                                                cy="12"
                                                r="1"
                                            ></circle>
                                            <circle
                                                cx="5"
                                                cy="12"
                                                r="1"
                                            ></circle>
                                        </svg>
                                    </a>

                                    <div
                                        class="dropdown-menu dropdown-menu-right"
                                    >
                                        <a class="dropdown-item" href="#"
                                            >Action</a
                                        >
                                        <a class="dropdown-item" href="#"
                                            >Another action</a
                                        >
                                        <a class="dropdown-item" href="#"
                                            >Something else here</a
                                        >
                                    </div>
                                </div>
                            </div>
                            <h5 class="card-title mb-0">기본 정보</h5>
                        </div>
                        <div class="card-body">
                            <form
                                id="frm"
                                action="/projects/${project.id}"
                                method="post"
                            >
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <input
                                                type="hidden"
                                                value="${project.owner_id}"
                                                name="owner_id"
                                            />
                                            <label for="projectName"
                                                >프로젝트 이름</label
                                            >
                                            <input
                                                type="text"
                                                class="form-control"
                                                id="projectName"
                                                placeholder="프로젝트 이름"
                                                name="name"
                                                value="${project.name}"
                                            />
                                        </div>
                                        <div class="form-group">
                                            <label for="projectInfo"
                                                >프로젝트 설명</label
                                            >
                                            <textarea
                                                rows="2"
                                                class="form-control"
                                                id="projectInfo"
                                                name="info"
                                                placeholder="프로젝트 설명을 적어주세요."
                                            >
${project.info}</textarea
                                            >
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="text-center">
                                            <img
                                                alt="Andrew Jones"
                                                src="https://bootdey.com/img/Content/avatar/avatar1.png"
                                                class="rounded-circle img-responsive mt-2"
                                                width="128"
                                                height="128"
                                            />
                                            <div class="mt-2">
                                                <span class="btn btn-primary"
                                                    ><i class="fa fa-upload"></i
                                                ></span>
                                            </div>
                                            <small
                                                >For best results, use an image
                                                at least 128px by 128px in .jpg
                                                format</small
                                            >
                                        </div>
                                    </div>
                                </div>

                                <button
                                    type="submit"
                                    class="btn btn-primary"
                                    id="saveButton"
                                >
                                    변경내용 저장
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div
                    class="tab-pane fade"
                    id="pills-member"
                    role="tabpanel"
                    aria-labelledby="pills-member-tab"
                >
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">멤버</h5>
                            <form
                                id="memberFrm"
                                action="/projects/${project.id}/crews"
                                method="post"
                                enctype="application/x-www-form-urlencoded"
                            >
                                <div id="memberList"></div>

                                <button
                                    type="button"
                                    class="btn btn-primary"
                                    id="deleteButton"
                                >
                                    삭제하기
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/js/project/setting.js"></script>
