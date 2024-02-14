//높이 리사이즈
// const projectList = document.getElementById("projectList");
// const firstHeight = window.innerHeight;
// projectList.style.height = firstHeight - 125 + "px";

// let currentProject = null;

// window.addEventListener("resize", () => {
//     const afterHeight = window.innerHeight;
//     const diff = afterHeight - firstHeight;
//     const parent = document.getElementById("projectList").parentElement;
//     projectList.style.height = firstHeight + diff - 125 + "px";
// });

//테스크 리스트 로드
async function loadTask(project_id) {
    if (currentProject != project_id) {
        try {
            const response = await fetch(`/projects/${project_id}/tasks`);
            const datas = await response.json();
            console.log(datas);
            const taskList = document.getElementById("taskList");
            const taskDetail = document.getElementById("taskDetail");
            taskList.innerHTML = "";
            taskDetail.innerHTML = "";
            for (data of datas) {
                taskList.innerHTML += `
                <a onclick="loadTaskDetail(${data.project_id},${data.id})" href="#" id="taskCard">
                    <div class="card mb-3">
                        <div class="card-body">
                            <h5 class="card-title">${data.name}</h5>
                            <p class="card-text">${data.content}</p>
                        </div>
                    </div>
                </a>
                `;
            }
            currentProject = project_id;
        } catch (error) {
            console.error(new Error(error.message));
        }
    }
}
//테스크 디테일 로드
async function loadTaskDetail(project_id, task_id) {
    try {
        const response = await fetch(
            `/projects/${project_id}/tasks/${task_id}`
        );
        const data = await response.json();
        const taskDetail = document.getElementById("taskDetail");

        taskDetail.innerHTML = `
                    <div class="card mb-3">
                        <div class="card-body">
                            <h5 class="card-title">${data.name}</h5>
                            <p class="card-text">${data.content}</p>
                        </div>
                    </div>
                `;
    } catch (error) {
        console.error(new Error(error.message));
    }
}
// $("#projectToggle").click(function () {
//     const style = {
//         hideProject: {
//             projectList: "col-lg-0 col-md-0 col-sm-0 col-xs-0",
//             taskList: "col-lg-12 col-md-4 col-sm-4 col-xs-0",
//             taskDetail: "col-lg-0 col-md-8 col-sm-8 col-xs-12",
//         },
//         showProject: {
//             projectList: "col-lg-0 col-md-0 col-sm-0 col-xs-0",
//             taskList: "col-lg-12 col-md-4 col-sm-4 col-xs-0",
//             taskDetail: "col-lg-0 col-md-8 col-sm-8 col-xs-12",
//         },
//     };
//     $("#projectList").toggle();
//     $("#taskList").class().
// });
