const addScheduleInput = document.getElementById("addScheduleInput");
const has_limitInput = document.getElementById("has_limitInput");

if (addScheduleInput.value == 1) {
    const scheduleCheckbox = document.getElementById("scheduleCheckbox");
    scheduleCheckbox.checked = true;
}
if (has_limitInput.value == 1) {
    const hasLimitCheckbox = document.getElementById("has_limit");
    hasLimitCheckbox.checked = true;
    const dataInputContainer = document.getElementById("dataInputContainer");
    dataInputContainer.style.display = "block";
    const inputDate = document.getElementsByClassName("inputDate");
}

//일정 추가 토글
const has_limitButton = document.getElementById("has_limit");
has_limitButton.addEventListener("change", (e) => {
    const dataInputContainer = document.getElementById("dataInputContainer");
    if (e.target.checked == true) {
        dataInputContainer.style.display = "block";
        has_limitInput.value = 1;
    } else {
        has_limitInput.value = 0;
        addScheduleInput.value = 0;
        dataInputContainer.style.display = "none";
    }
});

//스케줄 등록
const scheduleCheckbox = document.getElementById("scheduleCheckbox");
scheduleCheckbox.addEventListener("change", (e) => {
    if (e.target.checked == true) {
        addScheduleInput.value = 1;
    } else {
        addScheduleInput.value = 0;
    }
});

//제출 버튼 클릭시 이벤트
const submitButton = document.getElementById("submitButton");

submitButton.addEventListener("click", function () {
    if (checkInput()) {
        const frm = document.getElementById("frm");
        frm.submit();
    }
});

function checkInput() {
    const name = document.getElementById("name");
    const has_limit = document.getElementById("has_limit");
    const inputDate = document.getElementsByClassName("inputDate");

    if (name.value == "") {
        name.classList.add("is-invalid");
        alert("업무 이름을 적어주세요.");
        return false;
    } else {
        name.classList.remove("is-invalid");
    }
    if (has_limit.checked) {
        for (let i = 0; i < inputDate.length; i++) {
            if (inputDate[i].value == "") {
                alert("일정을 입력해주세요.");
                return false;
            }
        }
    }
    return true;
}

function createMemberList() {
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

async function loadCrewList(projectId) {
    const response = await fetch(`/v1/projects/${projectId}/crews`);
    const data = await response.json();
    memberList = data;
    return data;
}
let tagify;
let memberList = [];
document.addEventListener("DOMContentLoaded", async function () {
    const project_id = document.getElementById("projectId").value;
    const modalBody = document.getElementById("modalBody");
    const crewList = await loadCrewList(project_id);
    modalBody.innerHTML = createMemberList(crewList);

    //Tagify
    const input = document.querySelector("input[name=basic]");
    tagify = new Tagify(input, {
        enforceWhitelist: true,
        whitelist: memberList.map(
            (member) => member.name + "(" + member.email + ")"
        ), // 화이트리스트 배열

        dropdown: {
            classname: "tags-look", // 드롭다운 메뉴 엘리먼트 클래스 이름. 이걸로 css 선택자로 쓰면 된다.
            enabled: 1, // 단어 몇글자 입력했을떄 추천 드롭다운 메뉴가 나타날지
            closeOnSelect: true, // 드롭다운 메뉴에서 태그 선택하면 자동으로 꺼지는지 안꺼지는지
        },
    }); // initialize Tagify

    //기존 맴버 추가
    let member_ids = document.getElementById("member_id").value;
    member_ids = member_ids.trim().split(/\s+/);

    if (member_ids[0] != "") {
        for (let i = 0; i < member_ids.length; i++) {
            const member_id = member_ids[i];
            const index = memberList.findIndex(
                (member) => member.id == member_id
            );
            memberList[index].selected = true;
            const member = memberList[index];
            tagify.addTags(member.name + "(" + member.email + ")");
        }
        refreshPage();
    }

    tagify.on("remove", function (e) {
        const deleteTag = e.detail.data.value;
        for (idx in memberList) {
            if (
                memberList[idx].name + "(" + memberList[idx].email + ")" ==
                deleteTag
            ) {
                memberList[idx].selected = false;
            }
        }
        refreshPage();
    });

    tagify.on("dropdown:select", function (e) {
        const deleteTag = e.detail.data.value;
        for (idx in memberList) {
            if (
                memberList[idx].name + "(" + memberList[idx].email + ")" ==
                deleteTag
            ) {
                memberList[idx].selected = true;
            }
        }
        refreshPage();
    });

    tagify.on("add", function (e) {
        const deleteTag = e.detail.data.value;
        for (idx in memberList) {
            if (
                memberList[idx].name + "(" + memberList[idx].email + ")" ==
                deleteTag
            ) {
                memberList[idx].selected = true;
            }
        }
        refreshPage();
    });
});

//멤버 추가 버튼 클릭시 이벤트
const addMemberButton = document.getElementById("addMemberButton");

addMemberButton.addEventListener("click", function () {
    const checked = document.querySelectorAll(
        "#modalBody input[type=checkbox]:checked"
    );
    for (let i = 0; i < checked.length; i++) {
        const member_id = checked[i].value;
        const index = memberList.findIndex((member) => member.id == member_id);
        memberList[index].selected = true;
        const member = memberList[index];
        tagify.addTags(member.name + "(" + member.email + ")");
    }
    refreshPage();
});

function refreshPage() {
    const modalBody = document.getElementById("modalBody");
    modalBody.innerHTML = createMemberList(memberList);

    const charge = document.getElementById("charge");
    const memberIdList = [];
    tagify.value.forEach((value) => {
        for (idx in memberList) {
            if (
                memberList[idx].name + "(" + memberList[idx].email + ")" ==
                value.value
            ) {
                memberIdList.push(memberList[idx].id);
            }
        }
    });
    charge.value = memberIdList.join(",");
    console.log(memberIdList);
}

//summernote init
$("#summernote").summernote({
    placeholder: "내용을 입력해주세요.",
    tabsize: 4,
    height: 400,
    toolbar: [
        ["style", ["style"]],
        ["font", ["bold", "underline", "clear"]],
        ["color", ["color"]],
        ["para", ["ul", "ol", "paragraph"]],
        ["table", ["table"]],
        ["insert", ["link", "picture", "video"]],
    ],
});
const content = document.getElementById("content").value;
$("#summernote").summernote("code", content);
