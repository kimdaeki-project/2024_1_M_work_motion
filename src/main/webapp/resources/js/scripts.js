const body = document.getElementsByTagName("body")[0];
const member_id = body.getAttribute("data-bs-memberId");
window.addEventListener("DOMContentLoaded", (event) => {
    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector("#sidebarToggle");
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener("click", (event) => {
            event.preventDefault();
            document.body.classList.toggle("sb-sidenav-toggled");
            localStorage.setItem(
                "sb|sidebar-toggle",
                document.body.classList.contains("sb-sidenav-toggled")
            );
        });
    }
});
const chat = document.getElementById("chat");
const messengerButton = document.getElementById("messengerButton");
messenger.classList.toggle("animate__slideOutDown");
messengerButton.addEventListener("click", (event) => {
    messenger.classList.remove("d-none");
    messenger.classList.toggle("animate__slideOutDown");
    messenger.classList.toggle("animate__slideInUp");
});

// const closeMessengerButton = document.getElementById("closeMessengerButton");
// closeMessengerButton.addEventListener("click", (event) => {
//     messenger.classList.remove("d-none");

//     messenger.classList.toggle("animate__slideInUp");

//     messenger.classList.toggle("animate__slideOutDown");
// });
loadMembers();
async function loadMembers() {
    console.log("Loading members...");
    const messengerMemberList = document.getElementById("messengerMemberList");
    const response = await fetch("/v1/projects/members");
    const data = await response.json();
    console.log(data);
    messengerMemberList.innerHTML = createChatMemberList(data);

    const memberList = document.getElementsByClassName("memberList");
    for (let i in memberList) {
        memberList[i].addEventListener("click", async function (event) {
            event.preventDefault();
            const memberId = this.getAttribute("data-bs-memberId");
            console.log(memberId, member_id);
            let room_name = "";
            if (Number(member_id) > Number(memberId)) {
                room_name = memberId + "-" + member_id;
            } else {
                room_name = member_id + "-" + memberId;
            }
            console.log(room_name);
            const response = await fetch("/chat/getRoom?name=" + room_name);
            const data = await response.json();
            if (response.status == 200) {
                var popupWidth = 400;
                var popupHeight = 700;

                var popupX = window.screen.width / 2 - popupWidth / 2;
                // 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

                var popupY = window.screen.height / 2 - popupHeight / 2;
                const popupWindow = window.open(
                    "/chat?name=" + room_name,
                    "",
                    `toolbar=no, menubar=no,scrollbars=no,resizable=no, width=${popupWidth}, height=${popupHeight}, left=${popupX},top=${popupY}`
                );
                popupWindow.resizeTo(popupWidth, popupHeight);
                popupWindow.onresize = (_) => {
                    popupWindow.resizeTo(popupWidth, popupHeight);
                };
            }
        });
    }
}

function createChatMemberList(members) {
    let html = "";
    for (let member of members) {
        html += `
            <li class="p-2 border-bottom d-flex flex-row justify-content-between memberList" data-bs-memberId="${
                member.id
            }">
                <a href="#!" class="d-flex flex-row  align-items-center">
                        <div class="d-flex flex-row w-100">
                            <img
                                src="${
                                    member.avatar != null
                                        ? member.avatar.name
                                        : "https://bootdey.com/img/Content/avatar/avatar5.png"
                                }"
                                alt="avatar" class="d-flex align-self-center me-3" width="60"
                            >
                            <span class="badge bg-success badge-dot"></span>
                            <div class="pt-1">
                                <p class="fw-bold mb-0">${member.name}</p>
                                <p class="small text-muted">${
                                    member.position.name
                                }</p>
                            </div>
                        </div>
                        <div class="p-4 flex-shrink-1">
                            <a class="ms-3 text-muted" href="#!">
                                <i class="fas fa-paper-plane"></i>
                            </a>
                        </div>
                    </div>
                </a>
            </li>
        `;
    }
    return html;
}
