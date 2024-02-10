package com.workmotion.app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleDAO scheduleDAO;

    public List<ScheduleDTO> getTaskSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return scheduleDAO.getTaskSchedule(scheduleDTO);
    }

    public List<ScheduleDTO> getMemberSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return scheduleDAO.getMemberSchedule(scheduleDTO);
    }

    public int createTaskSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return scheduleDAO.createTaskSchedule(scheduleDTO);
    }

    public int createMemberSchedule(ScheduleDTO scheduleDTO) throws Exception {
        return scheduleDAO.createMemberSchedule(scheduleDTO);
    }
}
