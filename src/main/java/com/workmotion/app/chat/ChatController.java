package com.workmotion.app.chat;

import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import com.workmotion.app.chat.model.RoomInfoDTO;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.project.service.CrewService;
import com.workmotion.app.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/chat/getMessage")
    @ResponseBody
    public ResponseEntity<?> getMessage(Model model, RoomInfoDTO roomInfoDTO, Pager pager, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        roomInfoDTO.setMember_id(memberDTO.getId());
        List<MessageDTO> messageList = chatService.getMessage(roomInfoDTO, pager);

        RoomInfoDTO room = chatService.getRoomInfo(roomInfoDTO);
        chatService.updateRoomInfo(roomInfoDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("messages", messageList);
        response.put("room", room);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/chat/createRoom")
    @ResponseBody
    public RoomDTO createRoom(RoomDTO room) throws Exception {
        int result = chatService.createRoom(room);
        return room;
    }

    @GetMapping("/chat/getRoom")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getRoom(RoomDTO room, HttpSession session) throws Exception {
        Map<String, Object> response = new HashMap<>();

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        room = chatService.getRoom(room);
        List<MessageDTO> messageList = null;
        if (room.getName() == null) {
            chatService.createRoom(room);
        }
        ;
        response.put("room", room);
        return ResponseEntity.ok().body(response);
    }


    @MessageMapping("/sendMessage")
    public void sendMessage(MessageDTO message) throws Exception {
        int result = chatService.sendMessage(message);
        String destination = "/chat/messages/" + message.getRoom_name();
        simpMessagingTemplate.convertAndSend(destination, message);
    }

    @MessageMapping("/readMessage")
    public void readMessage(MessageDTO message) throws Exception {
        RoomInfoDTO roomInfoDTO = new RoomInfoDTO();
        roomInfoDTO.setRoom_name(message.getRoom_name());
        roomInfoDTO.setMember_id(message.getSender_id());
        chatService.updateRoomInfo(roomInfoDTO);
    }

    @GetMapping("/chat/members/{member_id}")
    @ResponseBody
    public void getProfile() throws Exception {

    }
}
