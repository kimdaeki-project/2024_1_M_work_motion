const pass = document.getElementById("password");
const passCheck = document.getElementById("passwordCheck");
const result = document.getElementById("passResult");
const checkResult = document.getElementById("passCheckResult");
const emailCheck = document.getElementById("email");
const emailResult =document.getElementById("emailResult");
let p1 = false;
let p2 = false;

pass.addEventListener("click",()=>{
    pass.value='';
    result.innerHTML='';
})

pass.addEventListener("blur",()=>{
    val = pass.value;
    if(val.length>7){
        result.innerHTML = 'ok';
        p1 = true;
    }else{
        result.innerHTML = '최소글자는 8글자 입니다';
        p1 = false;
    }
    passCheck.value='';
    checkResult.innerHTML= '';
});

passCheck.addEventListener('keyup',()=>{
    if(passCheck==pass.value){
        p2=true;
    }else{
        checkResult.innerHTML="비밀번호가 맞지 않습니다.";
        p2=false;
    }
})

emailCheck.addEventListener("blur",()=>{
    fetch("/member/emailcheck?email="+emailCheck.value,{
        method:"GET"
    }).then((r)=>r.text())
    .then(r=>{
        console.log(r);
        let result = r.trim();
        console.log(r);
        if(result==1){
            emailResult.innerHTML = "중복 사용 가능";
        }else{
            emailResult.innerHTML = "중복 사용 불가 "
        }
    })



})




