<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col">
                <div class="card shadow-lg border-0 rounded-lg ">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">${dto.name}</h3></div>
                    <div class="card-body">

            			<c:if test="${not empty dto.ANAME}">
            				<div>
            					<img  src="/resources/upload/member/${dto.ANAME}">
            				</div>
            				
            			</c:if>
					

                        <form action="/member/update" method="post" id="mypageFrm">
          
                            <div class="form-floating mb-3">
                                <input class="form-control" id="id" type="text" name="id" value="${dto.ID}" placeholder="name@example.com" />
                                <label for="id">사원 번호</label>
                            </div>
     
     						<div class="form-floating mb-3">
                                <input class="form-control" id="email" type="text" name="email" value="${dto.EMAIL}" placeholder="name@example.com" />
                                <label for="email">Email</label>
                            </div>

						<div class="form-floating mb-3">
							<input class="form-control" id="email" type="text" name="department"
								value="${dto.DNAME}" placeholder="name@example.com" /> <label
								for="email">부서</label>
						</div>

						<div class="form-floating mb-3">
							<input class="form-control" id="email" type="text" name="email"
								value="${dto.PNAME}" placeholder="name@example.com" /> <label
								for="email">직급</label>
						</div>

						<div class="form-floating mb-3">
							<input class="form-control" id="phone" type="text" name="phone"
								value="${dto.PHONE}" placeholder="name@example.com" /> <label
								for="phone">전화번호</label>
						</div>




						<div>
                            <input type="hidden" name="id" value="${dto.id}">
                            </div>
                            <div class="d-flex align-items-center justify-content-between ml-5 mt-2 mb-3">
                               
                                <button class="btn btn-primary" id="updateBtn" type="button">사원 정보 수정</button>
                            </div>
                        </form>
                        
                        		<button class="btn btn-danger">사원 정보 삭제</button>
                    </div>
                  
                </div>
            </div>
        </div>
    </div>