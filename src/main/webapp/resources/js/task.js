const projectInfo = document.getElementsByClassName("projectInfo")[0];
const project_id = projectInfo.getAttribute("data-bs-projectId");
const crewList = document.getElementById("crewList");

function createCrewList(crewList) {
    let html = "";
    for (crew of crewList) {
        html += `
                    <button
                    class="list-group-item list-group-item-action"
                    data-bs-toggle="modal"
                    data-bs-target="#profileModal"
                    data-bs-memberId="${crew.id}"
                    onclick="createProfile(${crew.id})"
                    >
                        <div
                            class="d-flex align-items-center pb-1"
                            id="tooltips-container"
                        >
                            <img
                                src="https://bootdey.com/img/Content/avatar/avatar5.png"
                                class="rounded-circle img-fluid avatar-md img-thumbnail bg-transparent"
                                alt=""
                            />
                            <div class="w-100 ms-2">
                                <h5 class="mb-1">
                                    ${crew.name}<i
                                        class="mdi mdi-check-decagram text-info ms-1"
                                    ></i>
                                </h5>
                                <p
                                    class="mb-0 font-13 text-muted"
                                >
                                    ${crew.position.name}
                                </p>
                            </div>
                            <i
                                class="mdi mdi-chevron-right h2"
                            ></i>
                        </div>
                    </button>
            `;
    }
    return html;
}
function createMemberList(memberList) {
    let html = "";
    for (member of memberList) {
        html += `
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="member_id" value="${member.id}">
                    <div class="memberCard">
                        <div class="avatar">
                        </div>
                        <div class="info">
                            <div class="name">${member.name}</div>
                            <div class="role">${member.position.name}</div>
                        </div>
                    </div>
                </div>
            `;
    }
    return html;
}
async function loadCrewList() {
    const response = await fetch(`/v1/projects/${project_id}/crews`);
    const data = await response.json();
    crewList.innerHTML = createCrewList(data);
}
//loadCrewList();

//멤버 추가
const addCrewButton = document.getElementById("addCrewButton");
const submitButton = document.getElementById("submitButton");
const settingProjectButton = document.getElementById("settingProjectButton");
addCrewButton.addEventListener("click", async function () {
    const modalBody = document.getElementById("modalBody");
    modalBody.innerHTML = "";
    const response = await fetch(`/v1/projects/${project_id}/members`);
    const data = await response.json();

    let html = "<form id='frm'>";
    html += createMemberList(data);
    html += "</form>";
    modalBody.innerHTML = html;
});

submitButton.addEventListener("click", function () {
    const checked = document.querySelectorAll("input[type=checkbox]:checked");
    let addMembers = [];
    const formData = new FormData();
    for (let i = 0; i < checked.length; i++) {
        const member_id = checked[i].value;
        addMembers.push(member_id);
    }
    formData.append("member_ids", addMembers.join(","));
    fetch(`/v1/projects/${project_id}/crews`, {
        method: "POST",
        body: formData,
    })
        .then((response) => response.json())
        .then((datas) => {
            console.log(datas);
            loadCrewList();
        });
});

async function loadProfile(member_id) {
    const response = await fetch(
        `/v1/projects/${project_id}/crews/` + member_id
    );
    const data = await response.json();
    return data;
}

async function createProfile(member_id) {
    const profileBody = document.getElementById("profileBody");
    profileBody.innerHTML = "";
    const member = await loadProfile(member_id);
    profileBody.innerHTML = `
        <div class="card">
            <div class="card-body">
                <div class="d-flex align-items-start">
                    <img
                        src="https://bootdey.com/img/Content/avatar/avatar1.png"
                        class="rounded-circle avatar-lg img-thumbnail"
                        alt="profile-image"
                    />
                    <div class="w-100 ms-3">
                        <h4 class="my-0">${member.name}</h4>
                        <p class="text-muted">${member.position.name}</p>
                        <button
                            type="button"
                            class="btn btn-soft-success btn-xs waves-effect mb-2 waves-light"
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
