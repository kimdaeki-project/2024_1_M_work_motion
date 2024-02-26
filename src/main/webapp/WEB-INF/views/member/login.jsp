<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Work Motion</title>
	
		<!-- Template -->
		<link href="/resources/css/styles.css" rel="stylesheet" />
		<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
	
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	
		 <!-- Jquery -->
		 <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
	  
        <style>
            @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");
        
            * {
                box-sizing: border-box;
            }
        
            body {
                font-family: "Montserrat", sans-serif;
                margin: 0;
                padding: 0;
            }
        
            .wrapper {
                width: 100%;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background: #ebecf0;
                overflow: hidden;
            }
        
            .container {
                border-radius: 10px;
                box-shadow: -5px -5px 10px #fff, 5px 5px 10px #babebc;
                position: absolute;
                width: 1200px;
                min-height: 700px;
                overflow: hidden;
            }
        
            form {
                background: #ebecf0;
                display: flex;
                flex-direction: column;
                padding: 0 50px;
                height: 100%;
                justify-content: center;
                align-items: center;
            }
        
            form input {
                background: #eee;
                padding: 16px;
                margin: 8px 0;
                width: 85%;
                border: 0;
                outline: none;
                border-radius: 20px;
                box-shadow: inset 7px 2px 10px #babebc, inset -5px -5px 12px #fff;
            }
        
            button {
                border-radius: 20px;
                border: none;
                outline: none;
                font-size: 12px;
                font-weight: bold;
                padding: 15px 45px;
                margin: 14px;
                letter-spacing: 1px;
                text-transform: uppercase;
                cursor: pointer;
                transition: transform 80ms ease-in;
            }
        
            .form_btn {
                box-shadow: -5px -5px 10px #fff, 5px 5px 8px #babebc;
            }
        
            .form_btn:active {
                box-shadow: inset 1px 1px 2px #babebc, inset -1px -1px 2px #fff;
            }
        
            .overlay_btn {
                background-color: #ff4b2b;
                color: #fff;
                box-shadow: -5px -5px 10px #ff6b3f, 5px 5px 8px #bf4b2b;
            }
        
            .sign-in-container {
                position: absolute;
                left: 0;
                width: 50%;
                height: 100%;
                transition: all 0.5s;
            }
        
            .sign-up-container {
                position: absolute;
                left: 0;
                width: 50%;
                height: 100%;
                opacity: 0;
                transition: all 0.5s;
            }
        
            .overlay-left {
                display: flex;
                flex-direction: column;
                padding: 0 50px;
                justify-content: center;
                align-items: center;
                position: absolute;
                right: 0;
                width: 50%;
                height: 100%;
                opacity: 0;
                background-color: #ff4b2b;
                color: #fff;
                transition: all 0.5s;
            }
        
            .overlay-right {
                display: flex;
                flex-direction: column;
                padding: 0 50px;
                justify-content: center;
                align-items: center;
                position: absolute;
                right: 0;
                width: 50%;
                height: 100%;
                background-color: #ff4b2b;
                color: #fff;
                transition: all 0.5s;
            }
        
            .container.right-panel-active .sign-in-container {
                transform: translateX(100%);
                opacity: 0;
            }
        
            .container.right-panel-active .sign-up-container {
                transform: translateX(100%);
                opacity: 1;
                z-index: 2;
            }
        
            .container.right-panel-active .overlay-right {
                transform: translateX(-100%);
                opacity: 0;
            }
        
            .container.right-panel-active .overlay-left {
                transform: translateX(-100%);
                opacity: 1;
                z-index: 2;
            }
        
            .social-links {
                margin: 20px 0;
            }
        
            form h1 {
                font-weight: bold;
                margin: 0;
                color: #000;
            }
        
            p {
                font-size: 16px;
                font-weight: bold;
                letter-spacing: 0.5px;
                margin: 20px 0 30px;
            }
        
            span {
                font-size: 15px;
                color: #000;
                letter-spacing: 0.5px;
                margin-bottom: 10px;
            }
        
            .social-links div {
                width: 40px;
                height: 40px;
                display: inline-flex;
                justify-content: center;
                align-items: center;
                margin: 0 5px;
                border-radius: 50%;
                box-shadow: -5px -5px 10px #fff, 5px 5px 8px #babebc;
                cursor: pointer;
            }
        
            .social-links a {
                color: #000;
            }
        
            .social-links div:active {
                box-shadow: inset 1px 1px 2px #babebc, inset -1px -1px 2px #fff;
            }
        </style>    

        </head>
    <body class="">


        <div class="wrapper">
            <div class="container">
              <div class="sign-up-container">
                <form>
                  <h1>find ID ,Password</h1>
                  <div class="social-links">
                    <div>
                      <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    </div>
                  </div>
                  <span>or use your email for registration</span>
                  <input type="text" placeholder="Name">
                  <input type="email" placeholder="Email">
                  <input type="password" placeholder="Password">
                  <button class="form_btn">Sign Up</button>
                </form>
              </div>
              <div class="sign-in-container">
                <form  action="/member/login" method="POST" >
                  <h1>Work Motion</h1>
                  <div class="social-links">
                    <div>
                      <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    </div>
                  </div>
                  <span id="msg" style="color: red;">${msg}</span>
                  <input type="email" name="email" value="tmdrbs727@naver.com" placeholder="Email">
                  <input type="password" name="password" value="RLAtmdrbs1070@" placeholder="Password">
                  <button class="form_btn">Login</button><br>
                  <span><a href="/member/agree" type="button" style="color: black" >Sign Up</a></span>
                  <span><a href="/company/join" type="button" style="color: black">Company Sign Up</a> </span>
                </form>
              </div>
              <div class="overlay-container">
                <div class="overlay-left">
                  <h1>Go Login</h1>
                  <p>thank you for coming , go login !!</p>
                  <button id="signIn" class="overlay_btn">Login</button>
                </div>
                <div class="overlay-right">
                  <h1>foget ID, Password</h1>
                  <p>We will find your ID or password</p>
                  <button id="signUp" class="overlay_btn">find ID,Password</button>
                </div>
              </div>
            </div>
          </div>






        
         <!-- Bootstrap JS -->
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	     <script src="/resources/js/member/loginCheck.js"></script>
    </body>
</html>