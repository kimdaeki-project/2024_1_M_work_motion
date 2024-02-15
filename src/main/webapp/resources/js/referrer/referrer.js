
const rm = document.getElementById("referrer_modal")
const s = document.getElementById("referrer_search")
const modal = document.getElementById("budgetTeamInfo")

modal.addEventListener("click",function(e){

    if(e.target.classList.contains("modal-btn")){
       
        fetch("./referrer", {
            method: "GET"
        }).then(r => r.text())
            .then((r) => {         

                rm.innerHTML = r;
            })
    }

})



rm.addEventListener("click", (e) => {

    if (e.target.classList.contains("referrer")) {
        e.target
        let page = e.target.getAttribute("data-page");
        let search = e.target.getAttribute("data-search");
        let kind = e.target.getAttribute("data-kind");
        let start = e.target.getAttribute("data-start");
        let last = e.target.getAttribute("data-last");

        fetch("./referrer?page=" + page + "&search=" + search + "&kind=" + kind, {
            method: "GET"
        }).then(r => r.text())
            .then((r) => {         

                rm.innerHTML = r;
            })
    }
   
    if(e.target.classList.contains("ref-btn")){            
    // 선택한 값과 검색한 값을 가져오기
    const kind = document.getElementById("ref_kind").value;
    const search = document.getElementById("search").value;   

    // AJAX 요청 보내기
    fetch("./referrer?search=" + search + "&kind=" + kind, {
        method: "GET"
    }).then(r => r.text())
    .then((r) => {
        // AJAX 요청이 완료되고 결과를 처리하기
        rm.innerHTML = r ;      
     });    
    }

})




