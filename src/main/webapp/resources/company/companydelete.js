console.log("여기는 컴퍼니 js")


const checks = document.getElementsByClassName("companycheck");
const companybtn = document.getElementById("companybtn");
const cid = document.getElementsByClassName("cid");

companybtn.addEventListener("click", function(){
    let num= [];

    for(let  i = 0; i<checks.length;i++){
        if(checks[i].checked){
            console.log(cid[i].value)
            num.push(cid[i].value)

            console.log(num[i])
        }
    }

        fetch("/company/delete",{

            method:"POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded;charset=UTF-8"
            },
            body:"id="+num
        })
        .then(r => r.text())
        .then(re => {

            if(re>0){
                alert("삭제 성공")
            }else{
                alert("삭제 실패")
            }

            location.href="/company/updateList"
        })


})


