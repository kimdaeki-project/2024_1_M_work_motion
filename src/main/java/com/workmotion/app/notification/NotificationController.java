package com.workmotion.app.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workmotion.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/*")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notifications")
    public ResponseEntity<?> addNotification(NotificationDTO notificationDTO, NotificationMessage notificationMessage, HttpSession session) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        notificationDTO.setContent(mapper.writeValueAsString(notificationMessage));
        return ResponseEntity.ok().body(notificationService.addNotification(notificationDTO));
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDTO>> getNotifications(HttpSession session) throws Exception {
        return ResponseEntity.ok().body(notificationService.getNotification((MemberDTO) session.getAttribute("member")));
    }

    @PutMapping("/notifications/{id}")
    public ResponseEntity<?> updateNotification(NotificationDTO notificationDTO, HttpSession session, @PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(notificationService.updateNotification(notificationDTO, id));
    }

    @MessageMapping("/sendNotification")
    public void sendNotification(SimpMessageHeaderAccessor accessor) throws Exception {
        MemberDTO member = (MemberDTO) accessor.getSessionAttributes().get("member");
        List<NotificationDTO> notificationDTOs = notificationService.getNotification(member);

        String destination = "/notification/" + member.getId();
        simpMessagingTemplate.convertAndSend(destination, notificationDTOs);
    }

    @MessageMapping("/readNotification")
    public void readNotification(SimpMessageHeaderAccessor accessor) throws Exception {
        MemberDTO member = (MemberDTO) accessor.getSessionAttributes().get("member");

    }
}
