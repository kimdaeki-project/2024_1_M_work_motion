package com.workmotion.app.notification;

import com.workmotion.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationService {
    @Autowired
    private NotificationDAO notificationDAO;

    public List<NotificationDTO> getNotification(MemberDTO memberDTO) throws Exception {
        return notificationDAO.getNotification(memberDTO);
    }

    public int addNotification(NotificationDTO notificationDTO) throws Exception {
        return notificationDAO.addNotification(notificationDTO);
    }

    public int updateNotification(NotificationDTO notificationDTO, String id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("notification", notificationDTO);
        return notificationDAO.updateNotification(map);
    }
}
