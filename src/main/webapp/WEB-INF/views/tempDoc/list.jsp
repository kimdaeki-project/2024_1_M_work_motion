<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-4 p-4">
    <div class="d-flex justify-content-center mb-3">
        <h2 class="">임시저장</h2>
    </div>
    <div class="justify-content-end d-flex">
        <form class="row g-3">
            <div class="col-auto">
                <select
                    name="kind"
                    class="form-select"
                    aria-label="Default select example"
                >
                    <option value="kind2">파일종류</option>
                    <option value="kind1">제목</option>
                </select>
            </div>
            <div class="col-auto">
                <label for="search" class="visually-hidden">Search</label>
                <input
                    type="text"
                    name="search"
                    class="form-control"
                    id="search"
                    placeholder="search"
                />
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>

    <table class="table table-dark table-hover">
        <thead>
            <tr>
                <td>서류번호</td>
                <td>제목</td>
                <td>저장일</td>
                <td>서류종류</td>
            </tr>
        </thead>
        <c:forEach items="${list}" var="dto">
            <tr>
                <td>${dto.id}</td>
                <td>
                    <a href="../document/temporarySaveDetail?id=${dto.id}"
                        >${dto.title}</a
                    >
                </td>
                <td>${dto.create_dt}</td>
                <td>${dto.templeteDTO.file_nm}</td>
            </tr>
        </c:forEach>
    </table>

    <nav
        aria-label="Page navigation example"
        class="justify-content-center d-flex"
    >
        <ul class="pagination">
            <c:if test="${!pager.start}">
                <li class="page-item">
                    <a
                        class="page-link"
                        href="./list?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}"
                        aria-label="Previous"
                    >
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>

            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                <li class="page-item">
                    <a
                        class="page-link"
                        href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}"
                        >${i}</a
                    >
                </li>
            </c:forEach>

            <c:if test="${!pager.last}">
                <li class="page-item">
                    <a
                        class="page-link"
                        href="./list?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}"
                        aria-label="Next"
                    >
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
