package com.workmotion.app.notification;

import com.workmotion.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/*")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDTO>> getNotifications(HttpSession session) throws Exception {
        return ResponseEntity.ok().body(notificationService.getNotification((MemberDTO) session.getAttribute("member")));
    }

    @PutMapping("/notifications/{id}")
    public ResponseEntity<?> updateNotification(NotificationDTO notificationDTO, HttpSession session, @PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(notificationService.updateNotification(notificationDTO, id));
    }
}
