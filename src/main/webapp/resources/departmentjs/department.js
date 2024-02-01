console.log("ddddd")
let checks = document.getElementsByClassName("check");
let createbtn = document.getElementById("createbtn");
let department_id = document.getElementById("department_id");
let member_id = document.getElementsByClassName("member_id");
createbtn.addEventListener("click", function(){

   
   for(let i = 0; i<checks.length;i++){
    if(checks[i].checked){

        fetch("/department/memberList",{

            method:"Post",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body:"department_id:"+department_id.value+"&id:"+member_id.value
        })
        .then(r =>{r.text()})
        .then(re =>{
            console.log("dddd")
        })
        
    }
   }



})