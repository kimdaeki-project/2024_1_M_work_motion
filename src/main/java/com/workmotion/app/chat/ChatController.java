package com.workmotion.app.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import com.workmotion.app.chat.model.RoomInfoDTO;
import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.notification.NotificationDTO;
import com.workmotion.app.notification.NotificationMessage;
import com.workmotion.app.notification.NotificationService;
import com.workmotion.app.project.service.CrewService;
import com.workmotion.app.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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

    @Autowired
    private NotificationService notificationService;

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


    @GetMapping("/chat/getRoom")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getRoom(RoomInfoDTO room, HttpSession session, String memberName, String memberId) throws Exception {
        Map<String, Object> response = new HashMap<>();

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        if (memberName == null) {
            room = chatService.getRoom(room);
        } else {
            room = chatService.getRoom(room, memberName, memberId, memberDTO);

        }

        response.put("room", room);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/chat/getRooms")
    @ResponseBody
    public ResponseEntity<List<MessageDTO>> getUserRoom(RoomDTO room, HttpSession session) throws Exception {

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        List<MessageDTO> messageDTOS = chatService.getUserRoom(memberDTO);

        return ResponseEntity.ok().body(messageDTOS);
    }


    @MessageMapping("/sendMessage")
    public void sendMessage(MessageDTO message, SimpMessageHeaderAccessor accessor) throws Exception {
        MemberDTO sender = (MemberDTO) accessor.getSessionAttributes().get("member");
        RoomInfoDTO roomInfoDTO = new RoomInfoDTO();
        roomInfoDTO.setMember_id(sender.getId());
        roomInfoDTO.setRoom_name(message.getRoom_name());
        List<MemberDTO> memberList = chatService.getRoomUsers(roomInfoDTO);
        NotificationMessage notificationMessage = new NotificationMessage();
        NotificationDTO notificationDTO = new NotificationDTO();

        notificationMessage.setSender(sender.getName());
        if (message.getType().equals("image")) notificationMessage.setMessage("이미지");
        else notificationMessage.setMessage(message.getMessage());
        notificationMessage.setTargetRoom(message.getRoom_name());
        notificationDTO.setType_name("MESSAGE");
        int result = chatService.sendMessage(message);
        message.setSender(sender);
        String destination = "/chat/messages/" + message.getRoom_name();
        simpMessagingTemplate.convertAndSend(destination, message);
        for (MemberDTO memberDTO : memberList) {
            notificationDTO.setMember_id(memberDTO.getId());
            destination = "/notification/messages/" + memberDTO.getId();
            ObjectMapper mapper = new ObjectMapper();
            notificationDTO.setContent(mapper.writeValueAsString(notificationMessage));
            notificationService.addNotification(notificationDTO);
            simpMessagingTemplate.convertAndSend(destination, notificationDTO);
        }
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
