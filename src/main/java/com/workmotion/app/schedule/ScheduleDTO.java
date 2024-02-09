package com.workmotion.app.schedule;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.project.model.TaskDTO;

public class ScheduleDTO {
    private Long id;
    private String title;
    private String start_dt;
    private String end_dt;
    private Long task_id;
    private Long member_id;

    private TaskDTO task;
    private MemberDTO member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_dt() {
        return start_dt;
    }

    public void setStart_dt(String start_dt) {
        this.start_dt = start_dt;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }
}
