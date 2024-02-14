var socket = new SockJS("/websocket-example");
var stompClient = Stomp.over(socket);
const sendMessageButton = document.getElementById("sendMessageButton");

function chageDate(timestamp) {
    let date = new Date(timestamp);
    // 월을 약어 형식으로 변환
    var monthNames = [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec",
    ];
    var monthAbbreviation = monthNames[date.getMonth()];

    // 날짜와 시간을 AM/PM 형식으로 변환
    var hours = date.getHours();
    var ampm = hours >= 12 ? "PM" : "AM";
    hours = hours % 12;
    hours = hours ? hours : 12; // 0 시간을 12시로 표시
    var minutes = date.getMinutes();
    minutes = minutes < 10 ? "0" + minutes : minutes;

    // 결과 문자열 생성
    var result =
        hours +
        ":" +
        minutes +
        " " +
        ampm +
        " | " +
        monthAbbreviation +
        " " +
        date.getDate();
    return result;
}

sendMessageButton.addEventListener("click", function () {
    const messageInput = document.getElementById("messageInput");
    let message;

    message = {
        sender_id: 122,
        message: messageInput.value,
        time: new Date(),
        room_name: "110-122",
    };
    stompClient.send("/app/sendMessage", {}, JSON.stringify(message));
    messageInput.value = "";
});

stompClient.connect({}, function (frame) {
    console.log("Connected: " + frame);
    stompClient.subscribe("/chat/messages/110-122", function (outputMessage) {
        showMessage(JSON.parse(outputMessage.body));
    });
});

function showMessage(message) {
    const messageBox = document.getElementById("messageBox");
    var messageElement = document.createElement("li");
    message.time = chageDate(message.time);
    if (message.sender_id == 122) {
        messageElement.innerHTML = createSendMessage(message);
    } else {
        messageElement.innerHTML = createReceiveMessage(message);
    }
    messageBox.appendChild(messageElement);
}

function createSendMessage(message) {
    const html = `
    <div
        class="d-flex flex-row justify-content-end"
    >
        <div>
            <p
                class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary"
            >
                ${message.message}
            </p>
            <p
                class="small me-3 mb-1 rounded-3 text-muted"
            >
                ${message.time}
            </p>
        </div>
        <img
            src="https://bootdey.com/img/Content/avatar/avatar5.png"
            alt="avatar 1"
            style="width: 45px; height: 100%"
        />
    </div>
    `;
    return html;
}

function createReceiveMessage(message) {
    const html = `
    <div
        class="d-flex flex-row justify-content-start"
    >
        <img
            src="https://bootdey.com/img/Content/avatar/avatar5.png"
            alt="avatar 1"
            style="width: 45px; height: 100%"
        />
        <div>
            <p
                class="small p-2 ms-3 mb-1 rounded-3"
                style="
                    background-color: #f5f6f7;
                "
            >
                ${message.message}
            </p>
            <p
                class="small ms-3 mb-1 rounded-3 text-muted float-end"
            >
            ${message.time}
            </p>
        </div>
    </div>`;
    return html;
}
