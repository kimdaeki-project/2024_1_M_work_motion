<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<link
    href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
    rel="stylesheet"
/>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<div class="container mt-3">
    <form action="/tasks/create" method="post">
        <input type="hidden" name="project_id" value="${project.id}" />
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
            <div class="input-group mb-1">
                <input
                    type="text"
                    class="form-control"
                    placeholder="담당자를 선택해주세요"
                    aria-label="charge"
                    aria-describedby="addChargeButton"
                    name="charge"
                />
                <button
                    class="btn btn-outline-primary"
                    type="button"
                    id="addChargeButton"
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
                    name="end-dt"
                />
            </div>
        </div>
        <div class="mb-3">
            <div class="form-check form-switch">
                <input
                    class="form-check-input"
                    type="checkbox"
                    role="switch"
                    id="has_limit"
                    name="has_limit"
                />
                <label class="form-check-label" for="has_limit"
                    >스케줄에 등록하기</label
                >
            </div>
        </div>
        <button type="submit" class="btn btn-primary">작성하기</button>
    </form>
</div>

<script>
    // 시작날짜(min 속성)
    let sDate = new Date();
    let minStr = sDate.toISOString().split("T")[0];
    const inputDate = document.getElementsByClassName("inputDate");
    for (let i = 0; i < inputDate.length; i++) {
        inputDate[i].setAttribute("min", minStr);
    }
</script>

<script>
    $("#summernote").summernote({
        placeholder: "내용을 입력해주세요.",
        tabsize: 4,
        height: 400,
        toolbar: [
            ["style", ["style"]],
            ["font", ["bold", "underline", "clear"]],
            ["color", ["color"]],
            ["para", ["ul", "ol", "paragraph"]],
            ["table", ["table"]],
            ["insert", ["link", "picture", "video"]],
        ],
    });
</script>
