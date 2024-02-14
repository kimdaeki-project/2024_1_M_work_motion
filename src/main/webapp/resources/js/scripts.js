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
const chatButton = document.getElementById("chatButton");
chat.classList.toggle("animate__slideOutDown");
chatButton.addEventListener("click", (event) => {
    // chat.classList.remove("d-none");
    // chat.classList.toggle("animate__slideOutDown");
    // chat.classList.toggle("animate__slideInUp");
    var popupWidth = 400;
    var popupHeight = 700;

    var popupX = window.screen.width / 2 - popupWidth / 2;
    // 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

    var popupY = window.screen.height / 2 - popupHeight / 2;
    const popupWindow = window.open(
        "/chat",
        "",
        `toolbar=no, menubar=no,scrollbars=no,resizable=no, width=${popupWidth}, height=${popupHeight}, left=${popupX},top=${popupY}`
    );
    popupWindow.resizeTo(popupWidth, popupHeight);
    popupWindow.onresize = (_) => {
        popupWindow.resizeTo(popupWidth, popupHeight);
    };
});

const closeChatButton = document.getElementById("closeChatButton");
closeChatButton.addEventListener("click", (event) => {
    chat.classList.remove("d-none");

    chat.classList.toggle("animate__slideInUp");

    chat.classList.toggle("animate__slideOutDown");
});
