package com.cdc.anniversary.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    public Integer id;
    public Integer share_id;
    public Integer user_id;
    public Integer parent_id;
    public String content;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    public Date pubdate;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", share_id=" + share_id +
                ", user_id=" + user_id +
                ", parent_id=" + parent_id +
                ", content='" + content + '\'' +
                ", date=" + pubdate +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShare_id(Integer share_id) {
        this.share_id = share_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.pubdate = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getShare_id() {
        return share_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return pubdate;
    }
}
