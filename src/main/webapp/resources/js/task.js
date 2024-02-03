const projectInfo = document.getElementsByClassName("projectInfo")[0];
const project_id = projectInfo.getAttribute("data-bs-projectId");
const projectMemberList = document.getElementById("projectMemberList");

function createCrewList(memberList) {
    let html = "";
    for (member of memberList) {
        html += `
                <div class="memberCard">
                    <div class="avatar">
                    </div>
                    <div class="info">
                        <div class="name">${member.name}</div>
                        <div class="role">${member.positionDTO.name}</div>
                    </div>
                </div>
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
                            <div class="role">${member.positionDTO.name}</div>
                        </div>
                    </div>
                </div>
            `;
    }
    return html;
}
async function loadCrewList() {
    const response = await fetch(`/projects/${project_id}/crews`);
    const data = await response.json();
    projectMemberList.innerHTML = createCrewList(data);
}
loadCrewList();

//멤버 추가
const addCrewButton = document.getElementById("addCrewButton");
const submitButton = document.getElementById("submitButton");
const settingProjectButton = document.getElementById("settingProjectButton");
addCrewButton.addEventListener("click", async function () {
    const response = await fetch(`/projects/${project_id}/crews/memberList`);
    const data = await response.json();
    const modalBody = document.getElementById("modalBody");
    let html = "<form id='frm'>";
    html += createMemberList(data);
    html += "</form>";
    modalBody.innerHTML = html;
});

submitButton.addEventListener("click", function () {
    const form = document.getElementById("frm");
    const formData = new FormData(form);
    fetch(`/projects/${project_id}/crews`, {
        method: "POST",
        body: formData,
    })
        .then((response) => response.json())
        .then((datas) => {
            console.log(datas);
            loadCrewList();
        });
});
