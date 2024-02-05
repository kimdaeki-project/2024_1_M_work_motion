package com.workmotion.app.project.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TaskDTO {
    private Long id;
    private Long project_id;
    private String name;
    private Date create_dt;
    private String content;
    private Long writer_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_dt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_dt;

    private Integer has_limit;

    private String charge;

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Date getStart_dt() {
        return start_dt;
    }

    public void setStart_dt(Date start_dt) {
        this.start_dt = start_dt;
    }

    public Date getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(Date end_dt) {
        this.end_dt = end_dt;
    }

    public Integer getHas_limit() {
        return has_limit;
    }

    public void setHas_limit(Integer has_limit) {
        this.has_limit = has_limit;
    }

    private MemberDTO writer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(Long writer_id) {
        this.writer_id = writer_id;
    }

    public MemberDTO getWriter() {
        return writer;
    }

    public void setWriter(MemberDTO writer) {
        this.writer = writer;
    }
}
