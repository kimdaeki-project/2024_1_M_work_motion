const all = document.getElementById("all");
const checks = document.getElementsByClassName("checks");
const btn = document.getElementById("btn");
const abc = document.getElementsByClassName("abc");
//전체 동의
 all.addEventListener("click",()=>{
    let v = all.getAttribute("checked");
    v = all.checked;
    for(let ch of checks){
        ch.checked = v;
    }

 })

for(let che of checks){
    che.addEventListener("click",()=>{
        let flag =true;
        for(let che of checks){
            if(!ch.checked){
                flag =!flag;
                break;
            }
        }
        all.checked=flag;
    })
}



btn.addEventListener("click",(e)=>{
    e.preventDefault();
    let flag = true;

 for(let ah of abc){
        if(!ah.checked){
            flag=!flag;
            break;
        }
    }
    if(flag){
            location.href="/member/join";
    }else{
        alert('필수 약관 동의해주세요');
    }


 })



 

