package com.cdc.anniversary.dto;

import com.cdc.anniversary.model.Comment;

public class CommentDTO extends Comment {
    private String cusername;

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }
}
