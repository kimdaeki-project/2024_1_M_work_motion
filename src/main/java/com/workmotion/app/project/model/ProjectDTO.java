package com.workmotion.app.project.model;

import java.util.Date;

public class ProjectDTO {
    private Long id;
    private String name;
    private Date create_dt;
    private String info;
    private Long owner_id;
    private MemberDTO owner;

    public ProjectDTO() {
    }

    public ProjectDTO(Long projectId) {
        this.id = projectId;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_dt=" + create_dt +
                ", info='" + info + '\'' +
                ", owner_id=" + owner_id +
                ", owner=" + owner +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public MemberDTO getOwner() {
        return owner;
    }

    public void setOwner(MemberDTO owner) {
        this.owner = owner;
    }
}
