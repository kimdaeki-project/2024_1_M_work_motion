package com.workmotion.app.chat.model;

import java.util.Date;

public class MessageDTO {
    private Long id;
    private Long sender_id;
    private String message;
    private Date time;
    private Long room_id;
    private String room_name;

    public MessageDTO() {
    }

    public MessageDTO(Long sender_id, String message, Date time, String room_name) {
        this.sender_id = sender_id;
        this.message = message;
        this.time = time;
        this.room_name = room_name;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }
}
