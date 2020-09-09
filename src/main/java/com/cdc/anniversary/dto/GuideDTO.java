package com.cdc.anniversary.dto;

import com.cdc.anniversary.model.Guide;

public class GuideDTO extends Guide {
    public Integer user_id;
    public Integer guide_id;

    @Override
    public String toString() {
        return "GuideDTO{" +
                ", user_id=" + user_id +
                ", guide_id=" + guide_id +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", integration='" + integration + '\'' +
                '}';
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(Integer guide_id) {
        this.guide_id = guide_id;
    }
}
