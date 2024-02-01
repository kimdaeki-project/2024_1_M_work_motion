const btn = document.getElementById("btn");
const frm = document.getElementById("frm");

btn.addEventListener("click",()=>{
    let form = new FormData(frm);
    console.log(form);
    console.log(btn);
    console.log(frm);
    $.ajax({
        type:"POST",
        url:"/hr/create",
        data:form,
        success:function(){
        
            alert("회원가입 성공");
            location.href = "/hr/login";
        }
    })
   
});