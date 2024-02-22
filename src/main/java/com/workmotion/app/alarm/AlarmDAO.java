package com.workmotion.app.alarm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmDAO {
    @Autowired
    private SqlSession sqlSession;
}
