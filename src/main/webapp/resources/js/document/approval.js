const am = document.getElementById("approval_modal");
const a_s = document.getElementById("approval_search");
const a_modal = document.getElementById("modal-approval");


let a_save = [];
let a_save_name = [];
let save_department_name = [];

let a_count = 0;
let a_max = 3;

const a_check = document.getElementsByClassName("checkbox_save");
let approval_update = document.getElementById("approval-update");

const approval_list = document.getElementById("approval-list");



//모달창 
a_modal.addEventListener("click", function (e) {
    console.log(a_save[0]);
    console.log(a_save[1]);

    if (e.target.classList.contains("modal-btn")) {

        fetch("./approval", {
            method: "GET"
        }).then(r => r.text())
            .then((r) => {

                am.innerHTML = r;                

            })
    }

})


//페이번호 누르면 리스트 
am.addEventListener("click", (e) => {


    //페이번호 누르면 리스트 
    if (e.target.classList.contains("referrer")) {

        let page = e.target.getAttribute("data-page");
        let search = e.target.getAttribute("data-search");
        let kind = e.target.getAttribute("data-kind");


        fetch("./approval?page=" + page + "&search=" + search + "&kind=" + kind, {
            method: "GET"
        }).then(r => r.text())
            .then((r) => {

                am.innerHTML = r;

            })

    }

    //검색버튼 누르면 검색 리스트 
    if (e.target.classList.contains("ref-btn")) {
        // 선택한 값과 검색한 값을 가져오기
        const kind = document.getElementById("ref_kind").value;
        const search = document.getElementById("search").value;

        // AJAX 요청 보내기
        fetch("./approval?search=" + search + "&kind=" + kind, {
            method: "GET"
        }).then(r => r.text())
            .then((r) => {
                // AJAX 요청이 완료되고 결과를 처리하기
                am.innerHTML = r;
            });
    }

    //체크박스 체크하면 멤버ID 저장
    if (e.target.classList.contains("member_id")) {        
        if (e.target.checked) {
            //member id 값 배열에 저장              
            a_save.push(e.target.getAttribute("data-referrer-id"));
            a_save_name.push(e.target.getAttribute("data-member-name"));
            save_department_name.push(e.target.getAttribute("data-department-name"));
            
            console.log(a_save);

        } else {
            for (let i = 0; i < a_save.length; i++) {
                if (a_save[i] === e.target.getAttribute("data-referrer-id")) {
                    a_save.splice(i, 1);
                    a_save_name.splice(i, 1);
                    save_department_name.splice(i, 1);
                    i--;
                    console.log(a_save);

                    document.getElementById("sign_del").remove();
                    a_count--;

                }
            }
        }
    }
});


let a_idx = 0;
approval_update.addEventListener("click", function () {

    if (a_count >= a_max) {
        alert("결재자는 최대 3명입니다.")
        return;
    }
    a_count++;
    a_idx++;

    // "a_save" 배열의 길이만큼 span 요소 생성
    for (let i = 0; i < a_save.length; i++) {
        
        let signMemberWrap = document.createElement("span");
        signMemberWrap.className = "sign_member_wrap";
        signMemberWrap.id = "sign_del";

        let signMember = document.createElement("span");
        signMember.className = "sign_member";

        let signRankWrap = document.createElement("span");
        signRankWrap.className = "sign_rank_wrap";

        let signRank = document.createElement("span");
        signRank.className = "sign_rank";
        signRank.id = "approvla-department-name";
        signRank.textContent = save_department_name[i];

        let signWrap = document.createElement("span");
        signWrap.className = "sign_wrap";

        let signName = document.createElement("span");
        signName.className = "sign_name";
        signName.id = "approval-name";
        signName.textContent = a_save_name[i];

        let signDateWrap = document.createElement("span");
        signDateWrap.className = "sign_date_wrap";

        let signDate = document.createElement("span");
        signDate.className = "sign_date";
        signDate.textContent = "결재";

        // 생성한 요소들을 서로 연결
        signRankWrap.appendChild(signRank);
        signWrap.appendChild(signName);
        signDateWrap.appendChild(signDate);

        signMember.appendChild(signRankWrap);
        signMember.appendChild(signWrap);
        signMember.appendChild(signDateWrap);

        signMemberWrap.appendChild(signMember);
        // 생성한 span태그 자식으로 추가 
        approval_list.appendChild(signMemberWrap);
        
    }
    let string = a_save.join(",");
    let input = document.getElementById("approval-member-id");
    input.value = string;

});





