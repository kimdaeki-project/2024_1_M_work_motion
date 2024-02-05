const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pwCheckBtn = document.getElementById("pwCheckBtn");
const joinbtn = document.getElementById("joinbtn");
const check = true;
pwCheckBtn.addEventListener("click",(e)=>{
    pw =  pw.value;
    e.preventDefault;
    fetch("/member/pwCheck",{
        method:"POST",
        body:"password="+pw

    }).then(r=>r.text())
    .then(r=>{
        if(r>0){
            pwResult.innerHTML= '비밀번호 확인되었습니다';
            check = true;
        }else{
            pwResult.innerHTML= '비밀번호 확인 실패';
            check = false;
        }
    })

})



joinbtn.addEventListener("click",()=>{
    if(check){
        submit();
    }else{
        alert("비밀번호 인증해주세요");
    }
})
