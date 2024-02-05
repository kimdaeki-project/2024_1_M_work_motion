// min 날짜 설정 및 스케줄 등록 관리
let sDate = new Date();
let minStr = sDate.toISOString().split("T")[0];
const inputDate = document.getElementsByClassName("inputDate");
for (let i = 0; i < inputDate.length; i++) {
    inputDate[i].setAttribute("min", minStr);
}
const has_limitButton = document.getElementById("has_limit");
const has_limitInput = document.getElementById("has_limitInput");
has_limitButton.addEventListener("change", (e) => {
    if (e.target.checked == true) {
        has_limitInput.value = 1;
    } else {
        has_limitInput.value = 0;
    }
});

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

const submitButton = document.getElementById("submitButton");

submitButton.addEventListener("click", function () {
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
