const signUpBtn = document.getElementById("signUp");
const signInBtn = document.getElementById("signIn");
const container = document.querySelector(".container");
const findIdBtn = document.getElementById("findIdBtn");
const nameId =document.getElementById("nameId");
const phoneId = document.getElementById("phoneId");
const findIdFrm = document.getElementById("findIdFrm");
const msg2 =document.getElementById("msg2");


signUpBtn.addEventListener("click", () => {
  container.classList.add("right-panel-active");
});
signInBtn.addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

findIdBtn.addEventListener("click",()=>{
     if(nameId.value ==""){         //아이디 입력
         alert("이름을 입력해 주세요");
       }else{
         if(phoneId.value ==""){     //전화번호 입력
         alert("전화번호를 입력해 주세요");
         }else{
            fetch("/member/findId",{
              method:"post",
              headers : {'Content-type': ' application/x-www-form-urlencoded;charset=utf-8'},
              body:"name="+nameId.value+"&phone="+phoneId.value
            }).then(result=>result.text())
            .then(result=>{
              result.trim();
              if(result==""){
                msg2.innerHTML = "등록된 아이디가 없습니다"
              }else{
                msg2.innerHTML =""+nameId.value+"님 ID:"+result+"입니다"; 
              }
            })
          
         }
       }
     


   })


