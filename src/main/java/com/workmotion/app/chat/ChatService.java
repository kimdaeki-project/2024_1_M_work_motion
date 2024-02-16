package com.workmotion.app.chat;

import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import com.workmotion.app.chat.model.RoomInfoDTO;
import com.workmotion.app.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {
    @Autowired
    private ChatDAO chatDAO;

    public int createRoom(RoomDTO room) throws Exception {
        int result = chatDAO.createRoom(room);
        String[] members = room.getName().split("-");
        Map<String, Object> map = new HashMap<>();
        System.out.println("addMember");
        map.put("room_name", room.getName());
        map.put("members", members);

        result = chatDAO.addMember(map);

        return result;
    }

    public RoomDTO getRoom(RoomDTO room) throws Exception {
        RoomDTO resultRoom = chatDAO.getRoom(room);
        if (resultRoom == null) {
            createRoom(room);
            return room;
        }
        return resultRoom;
    }

    public int addMember(Map<String, Object> map) throws Exception {
        return chatDAO.addMember(map);
    }

    public int sendMessage(MessageDTO message) throws Exception {
        return chatDAO.sendMessage(message);
    }

    public int updateRoomInfo(RoomInfoDTO roomInfoDTO) {
        return chatDAO.updateRoomInfo(roomInfoDTO);
    }

    public List<MessageDTO> getMessage(RoomInfoDTO roomInfoDTO, Pager pager) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        pager.setLastNum(pager.getPage() * 10);
        pager.setStartNum(pager.getLastNum() - 9);
        map.put("roomInfo", roomInfoDTO);
        map.put("pager", pager);
        return chatDAO.getMessage(map);
    }

    public RoomInfoDTO getRoomInfo(RoomInfoDTO roomInfoDTO) throws Exception {
        return chatDAO.getRoomInfo(roomInfoDTO);
    }
}
