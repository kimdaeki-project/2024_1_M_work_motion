package com.workmotion.app.chat;

import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {
    @Autowired
    private ChatDAO chatDAO;

    public int createRoom(RoomDTO room) throws Exception {
        int result = chatDAO.createRoom(room);
        Long id = room.getId();
        String[] members = room.getName().split("-");
        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        map.put("room_id", id);
        map.put("members", members);
        result = chatDAO.addMember(map);
        return result;
    }

    public int addMember(Map<String, Object> map) throws Exception {
        return chatDAO.addMember(map);
    }

    public int sendMessage(MessageDTO message) throws Exception {
        return chatDAO.sendMessage(message);
    }
}
