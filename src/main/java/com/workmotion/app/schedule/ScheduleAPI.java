package com.workmotion.app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/*")
public class ScheduleAPI {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("tasks/{task_id}/schedules")
    public ResponseEntity<List<ScheduleDTO>> getTaskSchedule(@PathVariable Long task_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setTask_id(task_id);
        List<ScheduleDTO> schedules = scheduleService.getTaskSchedule(scheduleDTO);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("members/{member_id}/schedules")
    public ResponseEntity<List<ScheduleDTO>> getMemberSchedule(@PathVariable Long member_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setMember_id(member_id);
        List<ScheduleDTO> schedules = scheduleService.getMemberSchedule(scheduleDTO);

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

}
