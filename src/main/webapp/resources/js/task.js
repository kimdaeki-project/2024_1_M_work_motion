const projectInfo = document.getElementsByClassName("projectInfo")[0];
const project_id = projectInfo.getAttribute("data-bs-projectId");
console.log(project_id);
fetch(`/projects/${project_id}/crews`, {})
    .then((response) => response.json())
    .then((datas) => {
        console.log(datas);
    });
