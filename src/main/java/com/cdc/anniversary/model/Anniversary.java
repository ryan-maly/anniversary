package com.cdc.anniversary.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Anniversary {
    private Integer id;
    private Integer userId;
    private String title;
    private Integer icon;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pubdate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date remindDate;
    private String note;
    private String img;

    @Override
    public String toString() {
        return "Anniversary{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", icon=" + icon +
                ", pubdate=" + pubdate +
                ", remindDate=" + remindDate +
                ", note='" + note + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
