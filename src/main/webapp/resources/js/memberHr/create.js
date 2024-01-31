const btn = document.getElementById("btn");
const frm = document.getElementById("frm");

btn.addEventListener("click",()=>{
    let form = new FormData(frm);
    console.log(form);
    console.log(btn);
    console.log(frm);
    fetch("/hr/create",{
        method:"POST",
        body:form
    }).then(r=>r.text())
    .then(r=>{
        console.log(r.trim());
        r= r.trim();
        if(r>0){
            alert("성공");
        }else{
            alert("실패");
        }
    })
});