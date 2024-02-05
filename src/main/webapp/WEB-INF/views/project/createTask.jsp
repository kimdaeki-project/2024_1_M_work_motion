<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<link
    href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
    rel="stylesheet"
/>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<div class="container mt-3">
    <form action="/tasks/create" method="post" enctype="multipart/form-data">
        <input
            type="hidden"
            name="project_id"
            value="${project.id}"
            id="projectId"
        />
        <div class="mb-3">
            <label for="name" class="form-label">제목</label>
            <input type="text" class="form-control" id="name" name="name" />
        </div>
        <div class="mb-3">
            <label for="summernote" class="form-label">본문</label>
            <textarea id="summernote" name="content"></textarea>
        </div>
        <div class="mb-3">
            <label for="charge" class="form-label">담당자</label>
            <input
                type="hidden"
                name="charge"
                class="form-control"
                id="charge"
            />
            <div class="input-group mb-1">
                <input
                    type="text"
                    class="form-control"
                    placeholder="담당자를 선택해주세요"
                    aria-label="charge"
                    name="basic"
                    aria-describedby="addChargeButton"
                />
                <button
                    class="btn btn-outline-primary"
                    type="button"
                    id="addChargeButton"
                    data-bs-toggle="modal"
                    data-bs-target="#staticBackdrop"
                >
                    추가하기
                </button>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">기한</label>
            <div class="input-group mb-1">
                <span class="input-group-text" id="start_dt">시작일</span>
                <input
                    type="date"
                    class="form-control inputDate"
                    name="start_dt"
                />
            </div>
            <div class="input-group">
                <span class="input-group-text" id="end_dt">종료일</span>
                <input
                    type="date"
                    class="form-control inputDate"
                    name="end_dt"
                />
            </div>
        </div>
        <div class="mb-3">
            <div class="form-check form-switch">
                <input
                    type="hidden"
                    class="form-control"
                    name="has_limit"
                    id="has_limitInput"
                    value="0"
                />
                <input
                    class="form-check-input"
                    type="checkbox"
                    role="switch"
                    id="has_limit"
                />
                <label class="form-check-label" for="has_limit"
                    >스케줄에 등록하기</label
                >
            </div>
        </div>
        <button type="submit" class="btn btn-primary">작성하기</button>
    </form>
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

<script
    type="text/javascript"
    src="/resources/js/project/createTask.js"
></script>
