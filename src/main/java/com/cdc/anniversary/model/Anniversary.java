package com.cdc.anniversary.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Anniversary {
    private Integer id;
    private Integer user_id;
    private String title;
    private Integer icon;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date pubdate;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date remind_Date;
    private String note;
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Date getRemind_Date() {
        return remind_Date;
    }

    public void setRemind_Date(Date remind_Date) {
        this.remind_Date = remind_Date;
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
