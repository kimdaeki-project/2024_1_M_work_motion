
const rm = document.getElementById("referrer_modal")
const s = document.getElementById("referrer_search")
const add = document.getElementById("referrer_add")


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
   
})

add.addEventListener("click",(e) => {    
    
    let search = s.getAttribute("data-search");
    let kind = s.getAttribute("date-kind");

    fetch("./referrer?search=" + search + "&kind=" + kind,{
        method:"GET"
    }).then(r => r.text())
    .then((r) => {

        rm.innerHTML = r;
    })

});
