const saveButton = document.getElementById("saveButton");
const deleteButton = document.getElementById("deleteButton");
const pillsMember = document.querySelector("[aria-controls=pills-member]");
const container = document.getElementById("container");
const project_id = container.getAttribute("data-bs-projectId");
const memberList = document.getElementById("memberList");
const deleteProjectButton = document.getElementById("deleteProjectButton");

deleteProjectButton.addEventListener("click", () => {
    if (confirm("정말 삭제하시겠습니까?")) {
        const form = document.createElement("form");
        const input = document.createElement("input");
        input.setAttribute("name", "id");
        input.setAttribute("value", project_id);
        form.appendChild(input);
        form.setAttribute("method", "POST");
        form.setAttribute("action", "/projects/delete");
        document.body.appendChild(form);
        form.submit();
    }
});
pillsMember.addEventListener("click", () => {
    console.log("Project");
});

function createCrewList(memberList) {
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
    memberList.innerHTML = createCrewList(data);
}
//loadCrewList();

async function deleteCrew(members) {}

deleteButton.addEventListener("click", async function () {
    const checked = document.querySelectorAll("input[type=checkbox]:checked");
    let deleteMembers = [];
    for (let i = 0; i < checked.length; i++) {
        const member_id = checked[i].value;
        deleteMembers.push(member_id);
    }
    console.log(deleteMembers);
    const response = await fetch(
        `/v1/projects/${project_id}/crews/` + deleteMembers.join(","),
        {
            method: "DELETE",
        }
    );

    const data = await response.json();
    loadCrewList();
});
