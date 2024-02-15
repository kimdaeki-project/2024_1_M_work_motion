package com.workmotion.app.chat;

import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import com.workmotion.app.chat.model.RoomInfoDTO;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.project.service.CrewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private CrewService crewService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @GetMapping("/chat")
    public String getChat(Model model, RoomDTO roomDTO, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        model.addAttribute("member", memberDTO);
        model.addAttribute("room", roomDTO);
        return "chat";
    }


    @GetMapping("/chat/createRoom")
    @ResponseBody
    public RoomDTO createRoom(RoomDTO room) throws Exception {
        int result = chatService.createRoom(room);
        return room;
    }

    @GetMapping("/chat/getRoom")
    @ResponseBody
    public String getRoom(RoomDTO room, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        System.out.println(room.getName());
        room = chatService.getRoom(room);

        if (room.getName() == null) {
            chatService.createRoom(room);
        } else {
            RoomInfoDTO roomInfoDTO = new RoomInfoDTO();
            roomInfoDTO.setRoom_name(room.getName());
            roomInfoDTO.setMember_id(memberDTO.getId());
            chatService.updateRoomInfo(roomInfoDTO);
        }
        ;
        return "success";
    }


    @MessageMapping("/sendMessage")
    public void sendMessage(MessageDTO message) throws Exception {
        int result = chatService.sendMessage(message);
        String destination = "/chat/messages/" + message.getRoom_name();
        simpMessagingTemplate.convertAndSend(destination, message);
    }
}
