package com.workmotion.app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/*")
public class ScheduleAPI {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("tasks/{task_id}/schedules")
    public ResponseEntity<List<ScheduleDTO>> getTaskSchedule(@PathVariable Long task_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setTask_id(task_id);
        List<ScheduleDTO> schedules = scheduleService.getSchedule(scheduleDTO);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("members/{member_id}/schedules")
    public ResponseEntity<List<ScheduleDTO>> getMemberSchedule(@PathVariable Long member_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setMember_id(member_id);
        List<ScheduleDTO> schedules = scheduleService.getSchedule(scheduleDTO);

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PostMapping("tasks/{task_id}/schedules")
    public ResponseEntity<?> createTaskSchedule(@PathVariable Long task_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setTask_id(task_id);
        int result = scheduleService.createSchedule(scheduleDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("members/{member_id}/schedules")
    public ResponseEntity<?> createMemberSchedule(@PathVariable Long member_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setMember_id(member_id);
        int result = scheduleService.createSchedule(scheduleDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("schedules/{schedule_id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long schedule_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setId(schedule_id);
        int result = scheduleService.deleteSchedule(scheduleDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("schedules/{schedule_id}")
    public ResponseEntity<?> updateSchedule(@PathVariable Long schedule_id, ScheduleDTO scheduleDTO) throws Exception {
        scheduleDTO.setId(schedule_id);
        int result = scheduleService.updateSchedule(scheduleDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
