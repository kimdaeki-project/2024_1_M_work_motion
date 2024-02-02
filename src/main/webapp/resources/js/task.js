const projectInfo = document.getElementsByClassName("projectInfo")[0];
const project_id = projectInfo.getAttribute("data-bs-projectId");
const projectMemberList = document.getElementById("projectMemberList");

function createMemberList(memberList) {
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

fetch(`/projects/${project_id}/crews`, {})
    .then((response) => response.json())
    .then((datas) => {
        console.log(datas);
        projectMemberList.innerHTML = createMemberList(datas);
    });
