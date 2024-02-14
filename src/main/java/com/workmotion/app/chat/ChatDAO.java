package com.workmotion.app.chat;

import com.workmotion.app.chat.model.MessageDTO;
import com.workmotion.app.chat.model.RoomDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ChatDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.chat.ChatDAO.";

    public int createRoom(RoomDTO room) throws Exception {
        return sqlSession.insert(NAMESPACE + "createRoom", room);
    }

    public int addMember(Map<String, Object> map) throws Exception {
        return sqlSession.insert(NAMESPACE + "addMember", map);
    }

    public int sendMessage(MessageDTO message) throws Exception {
        return sqlSession.insert(NAMESPACE + "sendMessage", message);
    }
}
