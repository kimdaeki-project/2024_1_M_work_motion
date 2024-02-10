package com.workmotion.app.schedule;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.schedule.ScheduleDAO.";

    public List<ScheduleDTO> getTaskSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getTaskSchedule", scheduleDTO);
    }

    public List<ScheduleDTO> getMemberSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getMemberSchedule", scheduleDTO);
    }

    public int createTaskSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "createTaskSchedule", scheduleDTO);
    }

    public int createMemberSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "createMemberSchedule", scheduleDTO);
    }
}
