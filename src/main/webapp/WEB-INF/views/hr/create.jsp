<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div>
			<form action="/hr/create" method="POST"  id="frm" >		

				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">email</label>
					<input type="text" class="form-control"id="email" name="email" >
				</div> 
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">password</label>
					<input type="text" class="form-control"id="password" name="password" >
				</div> 
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">name</label>
					<input type="text" class="form-control"id="name" name="name" >
				</div> 


				
				<button id="btn" class="btn btn-primary">Submit</button>
			</form>
	</div>
