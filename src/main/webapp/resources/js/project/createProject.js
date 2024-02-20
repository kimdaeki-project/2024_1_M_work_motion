const saveButton = document.getElementById("saveButton");
const addButton = document.getElementById("addButton");

const deleteButton = document.getElementById("deleteButton");
const pillsMember = document.querySelector("[aria-controls=pills-member]");
const container = document.getElementById("container");
const project_id = container.getAttribute("data-bs-projectId");
const memberList = document.getElementById("memberList");
const crewList = document.getElementById("crewList");
const deleteProjectButton = document.getElementById("deleteProjectButton");
const crewInput = document.getElementById("crewInput");

saveButton.addEventListener("click", function () {
    if (checkInput()) {
        const frm = document.getElementById("frm");
        frm.submit();
    }
});

function checkInput() {
    const projectName = document.getElementById("projectName");
    if (projectName.value == "") {
        projectName.classList.add("is-invalid");
        alert("프로젝트 이름을 적어주세요.");
        return false;
    } else {
        projectName.classList.remove("is-invalid");
        return true;
    }
}

pillsMember.addEventListener("click", () => {
    console.log("Project");
});

function createMemberList(memberList) {
    let html = "";
    for (member of memberList) {
        if (member.selected == true) continue;
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

function createCrewList(memberList) {
    let html = "";
    for (member of memberList) {
        if (member.selected != true) continue;
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

async function loadMemberList() {
    const response = await fetch(`/v1/projects/members`);
    const data = await response.json();
    memberList.innerHTML = createMemberList(data);
    members = data;
}
loadMemberList();

async function deleteCrew(members) {}

let crews = [];
let members = [];

addButton.addEventListener("click", function () {
    const checked = document.querySelectorAll(
        "#memberList input[type=checkbox]:checked"
    );
    for (let i = 0; i < checked.length; i++) {
        const member_id = checked[i].value;
        const index = members.findIndex((member) => member.id == member_id);
        members[index].selected = true;
    }
    refreshPage();
});

deleteButton.addEventListener("click", function () {
    const checked = document.querySelectorAll(
        "#crewList input[type=checkbox]:checked"
    );
    for (let i = 0; i < checked.length; i++) {
        const member_id = checked[i].value;
        const index = members.findIndex((member) => member.id == member_id);
        members[index].selected = false;
    }
    refreshPage();
});

function refreshPage() {
    memberList.innerHTML = createMemberList(members);
    crewList.innerHTML = createCrewList(members);
    crewInput.value = members
        .filter((member) => member.selected == true)
        .map((member) => member.id)
        .join(",");
    console.log(crewInput.value);
}
