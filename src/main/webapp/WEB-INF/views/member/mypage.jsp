<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="input-group mb-3">


            






        <form id="form" action="/member/update" method="post" enctype="multipart/form-data">
        <span class="input-group-text" id="basic-addon1">email</span>
        <input type="text" class="form-control" placeholder="${memberDTO.email}" name="email" aria-label="Username" aria-describedby="basic-addon1">
        
        <span class="input-group-text" id="basic-addon1">password</span>
        <input type="text" class="form-control" placeholder="${memberDTO.password}" aria-label="Username" name="password" aria-describedby="basic-addon1">
        
        <span class="input-group-text" id="basic-addon1">name</span>
        <input type="text" class="form-control" placeholder="${memberDTO.name}" aria-label="Username" name="name" aria-describedby="basic-addon1">
       
        <span class="input-group-text" id="basic-addon1">phone</span>
        <input type="text" class="form-control" placeholder="${memberDTO.phone}" aria-label="Username" name="phone" aria-describedby="basic-addon1">
       
        <span class="input-group-text" id="basic-addon1">사진파일</span>
        <input type="file" class="form-control" placeholder="" aria-label="Username" name="ori_name" aria-describedby="basic-addon1">
       
        <button class="btn btn-primary">정보 수정</button>
    </form>
    </div>
    </div>
      
      
      