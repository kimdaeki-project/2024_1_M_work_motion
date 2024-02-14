console.log("여기는 tossjsp입니다")
const apibtn = document.getElementById("apibtn");
const payment = document.getElementsByClassName("payment");

let num = [];




apibtn.addEventListener("click", function(){
    for(let i = 0 ; i<payment.length;i++){
    
        if(payment[i].checked){
            console.log(payment[i].value)
            localStorage.setItem("키",payment[i].value);
        }
    }
    location.href="/resources/js/api/toss.html"

})