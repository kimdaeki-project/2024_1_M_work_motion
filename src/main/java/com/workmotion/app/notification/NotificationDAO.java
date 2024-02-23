package com.workmotion.app.notification;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDAO {
    @Autowired
    private SqlSession sqlSession;
}
