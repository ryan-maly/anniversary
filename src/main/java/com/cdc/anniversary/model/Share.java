package com.cdc.anniversary.model;

import lombok.Data;

import java.util.Date;

@Data
public class Share {
    public Integer id;
    public Integer user_id;
    public String tag;
    public String content;
    public Integer favor_num;
    public Integer collect_num;
    public Integer comment_num;
    public Date date;
}
