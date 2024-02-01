<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col">
                <div class="card shadow-lg border-0 rounded-lg ">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">My page</h3></div>
                    <div class="card-body">

            


                        <form action="/member/update" method="post">

                            <div class="form-floating mb-3">
                                <input class="form-control" id="email" type="email" name="email" placeholder="name@example.com" />
                                <label for="email">Email address</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="password" name="password" type="password" placeholder="Password" />
                                <label for="password">Password</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="name" name="name" type="text" placeholder="name" />
                                <label for="password">text</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="phone" name="phone" type="text" placeholder="phone" />
                                <label for="password">phone</label>
                            </div>
                            
                            <div class="d-flex align-items-center justify-content-between ml-5 mt-2 mb-3">
                               
                                <button class="btn btn-primary">정보 수정</button>
                            </div>
                        </form>
                    </div>
                  
                </div>
            </div>
        </div>
    </div>
</main>



      
      