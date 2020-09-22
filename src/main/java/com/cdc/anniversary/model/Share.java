package com.cdc.anniversary.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Share {
    public Integer id;
    public Integer user_id;
    public String tag;
    public String content;
    public Integer favor_num = 0;
    public Integer collect_num = 0;
    public Integer comment_num = 0;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    public Date pubdate;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFavor_num() {
        return favor_num;
    }

    public void setFavor_num(Integer favor_num) {
        this.favor_num = favor_num;
    }

    public Integer getCollect_num() {
        return collect_num;
    }

    public void setCollect_num(Integer collect_num) {
        this.collect_num = collect_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }
}
