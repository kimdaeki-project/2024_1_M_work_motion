package com.workmotion.app.chat;

import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @GetMapping("/chat")
    public String getChat(Model model) throws Exception {
        return "chat";
    }

    @GetMapping("/chat/createRoom")
    @ResponseBody
    public RoomDTO createRoom(RoomDTO room) throws Exception {
        int result = chatService.createRoom(room);
        return room;
    }


    @MessageMapping("/sendMessage")
    public void sendMessage(MessageDTO message) throws Exception {
        int result = chatService.sendMessage(message);
        String destination = "/chat/messages/" + message.getRoom_name();
        simpMessagingTemplate.convertAndSend(destination, message);
    }
}
