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

const closeMessengerButton = document.getElementById("closeMessengerButton");
closeMessengerButton.addEventListener("click", (event) => {
    messenger.classList.remove("d-none");

    messenger.classList.toggle("animate__slideInUp");

    messenger.classList.toggle("animate__slideOutDown");
});
loadMembers();
let clickedMember;
async function loadMembers() {
    const messengerMemberList = document.getElementById("messengerMemberList");
    const response = await fetch("/v1/projects/members");
    const data = await response.json();

    const groupedByDepartment = data.reduce((acc, cur) => {
        const deptName = cur.department.name;
        if (!acc[deptName]) {
            acc[deptName] = [];
        }
        acc[deptName].push(cur);
        return acc;
    }, {});
    console.log(groupedByDepartment);
    const sortedGroupedByDepartmentName =
        Object.keys(groupedByDepartment).sort();
    const sortedGroupedByDepartment = sortedGroupedByDepartmentName.map(
        (departmentName) => {
            return {
                department: departmentName,
                members: groupedByDepartment[departmentName],
            };
        }
    );
    console.log(sortedGroupedByDepartment);
    messengerMemberList.innerHTML = createChatMemberList(
        sortedGroupedByDepartment
    );

    //아코디언 이벤트
    var accordionExamples = document.querySelectorAll(
        `div[data-bs-parent="#accordionExample"]`
    );
    for (let i = 0; i < accordionExamples.length; i++) {
        accordionExamples[i].addEventListener("show.bs.collapse", function () {
            this.previousElementSibling
                .querySelector(".arrow-icon")
                .classList.add("fa-chevron-up");
            this.previousElementSibling
                .querySelector(".arrow-icon")
                .classList.remove("fa-chevron-down");
        });

        accordionExamples[i].addEventListener("hide.bs.collapse", function () {
            this.previousElementSibling
                .querySelector(".arrow-icon")
                .classList.remove("fa-chevron-up");
            this.previousElementSibling
                .querySelector(".arrow-icon")
                .classList.add("fa-chevron-down");
        });
    }

    const memberList = document.getElementsByClassName("memberList");
    for (let i = 0; i < memberList.length; i++) {
        const member = data[i];
        memberList[i].addEventListener("click", async function (event) {
            event.preventDefault();
            if (event.target.nodeName == "IMG") {
                const memberId = this.getAttribute("data-bs-memberId");
                createChatProfile(memberId);
                return;
            }
            const memberId = this.getAttribute("data-bs-memberId");
            const memberName = this.getAttribute("data-bs-memberName");
            if (clickedMember != memberId) {
                clickedMember = memberId;
                for (let i = 0; i < memberList.length; i++) {
                    memberList[i].classList.remove("selected");
                }
                memberList[i].classList.add("selected");
                return;
            }

            let room_name = "";
            if (Number(member_id) > Number(memberId)) {
                room_name = memberId + "-" + member_id;
            } else {
                room_name = member_id + "-" + memberId;
            }
            const response = await fetch(
                "/chat/getRoom?room_name=" +
                    room_name +
                    "&memberName=" +
                    memberName +
                    "&memberId=" +
                    memberId
            );
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
loadMessages();
async function loadMessages() {
    const response = await fetch("/chat/getRooms");
    const data = await response.json();
    const messageList = document.getElementById("messageList");
    messageList.innerHTML = createChatRoomList(data);
    const roomItems = document.getElementsByClassName("roomItem");
    for (let i = 0; i < roomItems.length; i++) {
        roomItems[i].addEventListener("click", async function (e) {
            const room_name = e.currentTarget.getAttribute("data-bs-roomname");
            const response = await fetch(
                "/chat/getRoom?room_name=" + room_name
            );
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

const messageTabButton = document.getElementById("messages-tab");
messageTabButton.addEventListener("click", function () {
    loadMessages();
});

function createChatRoomList(data) {
    let html = "";
    for (let room of data) {
        html += `
            <li class="p-2 border-bottom roomItem" data-bs-roomName=${
                room.room_name
            }>
                <a href="#!" class="d-flex justify-content-between">
                <div class="d-flex flex-row">
                    <div>
                    <img
                        src="${
                            room.sender.avatar != null
                                ? room.sender.avatar.name
                                : "https://bootdey.com/img/Content/avatar/avatar5.png"
                        }"
                        alt="avatar" class="d-flex align-self-center me-3" width="60">
                    <span class="badge bg-success badge-dot"></span>
                    </div>
                    <div class="pt-1">
                    <p class="fw-bold mb-0">${room.sender.name}</p>
                    ${
                        room.type == "message"
                            ? `<p class="small text-muted overflow-auto" style="width:20vh; text-overflow:ellipsis;">${room.message}</p>`
                            : "<p class='small text-muted overflow-auto' style='width:20vh; text-overflow:ellipsis;'>사진을 보냈습니다.</p>"
                    }
                    
                    </div>
                </div>
                <div class="pt-1">
                    <p class="small text-muted mb-1">${new Date(
                        room.time
                    ).toLocaleDateString("ko-KR")}</p>
                </div>
                </a>
            </li>
        `;
    }
    return html;
}

function createChatMemberList(groupedByDepartment) {
    let html = "";
    // groupedByDepartment 객체의 키와 값을 순회하여 출력하기
    for (const { department, members } of groupedByDepartment) {
        html += `
        <div class="" id="accordionExample">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <div class=" ps-3 pe-3">
                        <hr class="m-0"/>
                    </div>
                    <button class="accordion-button ps-3 pe-3 p-2 text-muted" type="button" data-bs-toggle="collapse" data-bs-target="#${department}" aria-expanded="true" aria-controls="${department}">
                        <div class="d-flex justify-content-between w-100">
                            <div>
                            ${department} ${members.length}
                            </div>
                            <i class="arrow-icon fa-solid fa-chevron-down"></i>
                        </div>
                    </button>
                </h2>
                <div id="${department}" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
        `;
        members.forEach((member) => {
            html += `
                        <li class="ps-4 pe-4  d-flex flex-row justify-content-between memberList" data-bs-memberEmail="${
                            member.email
                        }" data-bs-memberName="${
                member.name
            }" data-bs-memberId="${member.id}">
                            <a href="#!" class="d-flex flex-row  align-items-center">
                                <div class="d-flex flex-row w-100">
                                    <img
                                        src="${
                                            member.avatar != null
                                                ? member.avatar.name
                                                : "https://bootdey.com/img/Content/avatar/avatar5.png"
                                        }"
                                        alt="avatar" class="d-flex align-self-center me-3 rounded-4"
                                        width="40"
                                        height="40"
                                        data-bs-toggle="modal"
                                        data-bs-target="#profileModal"
                                    >
                                    <span class="badge bg-success badge-dot"></span>
                                    <div class="pt-1">
                                        <p class="fw-bold mb-0">${
                                            member.name
                                        }</p>
                                        <p class="small text-muted">${
                                            member.position.name
                                        }</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                    `;
        });
        html += `
        </div>
        </div>
        </div>`;
    }
    return html;
}

//멤버 정보 로딩
async function loadProfile(member_id) {
    const response = await fetch(`/v1/projects/members/` + member_id);
    const data = await response.json();
    return data;
}
//오너 정보 로딩
async function loadOwnerProfile() {
    const response = await fetch(`/v1/projects/${project_id}/owner`);
    const data = await response.json();
    return data;
}

//멤버 프로필 클릭시 프로필 모달창 데이터 로딩 및 마크업 생성
async function createChatProfile(member_id) {
    const profileBody = document.getElementById("profileBody");
    profileBody.innerHTML = "";
    // let member = null;
    // if (is_owner) {
    //     member = await loadOwnerProfile();
    // } else {
    member = await loadProfile(member_id);
    // }
    profileBody.innerHTML = `
        <div class="card">
            <div class="card-body">
                <div class="d-flex align-items-start">
                    <img
                        src="${
                            member.avatar != null
                                ? member.avatar.name
                                : "https://bootdey.com/img/Content/avatar/avatar5.png"
                        }"
                        class="rounded-circle "
                        width="60"
                        height="60"
                        alt="profile-image"
                    />
                    <div class="w-100 ms-3">
                        <h4 class="my-0">${member.name}</h4>
                        <p class="text-muted">${member.position.name}</p>
                        <button
                            type="button"
                            class="btn btn-soft-success btn-xs waves-effect mb-2 waves-light"
                            data-bs-memberId="${member.id}"
                            data-bs-memberName="${member.name}"
                            onclick="sendMessage(${member.id})"
                        >
                            메시지
                        </button>
                    </div>
                </div>
                <div class="mt-3">
                    <p class="text-muted mb-2 font-13">
                        <strong>전화번호 :</strong
                        ><span class="ms-2">${member.phone}</span>
                    </p>
                    <p class="text-muted mb-2 font-13">
                        <strong>이메일 :</strong>
                        <span class="ms-2">${member.email}</span>
                    </p>
                </div>
            </div>
        </div>
    `;
}
