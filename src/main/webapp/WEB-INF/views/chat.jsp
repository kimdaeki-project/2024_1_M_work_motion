<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #chat3 .form-control {
        border-color: transparent;
    }

    #chat3 .form-control:focus {
        border-color: transparent;
        box-shadow: inset 0px 0px 0px 1px transparent;
    }

    .badge-dot {
        border-radius: 50%;
        height: 10px;
        width: 10px;
        margin-left: 2.9rem;
        margin-top: -0.75rem;
    }
    li {
        list-style-type: none;
    }
</style>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Chat</title>
        <!-- Jquery -->
        <script
            src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"
        ></script>
        <!-- Socket -->
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

        <!-- Bootstrap CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
        <script
            src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"
        ></script>
    </head>
    <body>
        <section class="h-100">
            <div class="container h-100">
                <div class="row h-100">
                    <div class="col-md-12 h-100">
                        <div class="row h-100">
                            <div
                                class="col-md-12 col-lg-12 col-xl-12 d-flex flex-column h-100"
                            >
                                <!-- 대화 들어가는 곳 -->
                                <div
                                    class="pt-3 overflow-auto"
                                    data-mdb-perfect-scrollbar="true"
                                    style="
                                        position: relative;
                                        background-color: #e7e3ff;
                                        height: 100%;
                                    "
                                    id="messageBox"
                                ></div>

                                <div
                                    class="text-muted d-flex justify-content-start align-items-center pe-3 mt-2 mb-2"
                                >
                                    <!-- 메시지 타이핑 -->
                                    <input
                                        type="text"
                                        class="form-control form-control-lg"
                                        id="messageInput"
                                        placeholder="Type message"
                                    />
                                    <a class="ms-1 text-muted" href="#!"
                                        ><i class="fas fa-paperclip"></i
                                    ></a>
                                    <a class="ms-3 text-muted" href="#!"
                                        ><i class="fas fa-smile"></i
                                    ></a>
                                    <!-- 전송버튼 -->
                                    <a
                                        class="ms-3"
                                        href="javascript:void(0);"
                                        id="sendMessageButton"
                                        ><i class="fas fa-paper-plane"></i
                                    ></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type="text/javascript" src="/resources/js/chat.js"></script>
    </body>
</html>
