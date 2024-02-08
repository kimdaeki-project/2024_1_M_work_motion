const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pwCheckBtn = document.getElementById("pwCheckBtn");
const mypageFrm = document.getElementById("mypageFrm");
const updateBtn = document.getElementById("updateBtn");
const updatePw = document.getElementById("updatePw");
const check = false;
const check2 = true;
pwCheckBtn.addEventListener("click",()=>{
   
    let formdata = new FormData(mypageFrm);
    updatePw.disabled = true;
    fetch("/member/pwCheck",{
        method:"POST",
        body:formdata
        
    }).then(r=>r.text())
    .then(r=>{
        
        if(r>0){
            console.log(r);
            pwResult.innerHTML= '비밀번호 확인되었습니다';
            check = true;
        }else{
            console.log(r);
            pwResult.innerHTML= '비밀번호 확인 실패';
            check = false;
        }
    })
    check2=false;
    updatePw.disabled = false;
})
   
updateBtn.addEventListener("click",()=>{

        if(check2){                     //비밀번호 확인 x 
            if(check){                  //비밀번호 변경
                pw.disabled = true;
                mypageFrm.submit();
            }else{
                alert("비밀번호를 확인해주세요");

            }
                
        }else{
            pw.disabled = true;
            updatePw.disabled = true;
            mypageFrm.submit();

        }




})






