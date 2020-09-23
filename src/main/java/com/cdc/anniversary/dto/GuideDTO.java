package com.cdc.anniversary.dto;

import com.cdc.anniversary.model.Guide;

public class GuideDTO extends Guide {
    public Integer user_id;

    public boolean exchange;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public boolean isExchange() {
        return exchange;
    }

    public void setExchange(boolean exchange) {
        this.exchange = exchange;
    }
}
