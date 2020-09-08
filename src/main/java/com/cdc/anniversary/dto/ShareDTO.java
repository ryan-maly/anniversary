package com.cdc.anniversary.dto;

import com.cdc.anniversary.model.Share;


public class ShareDTO extends Share {
    public boolean is_favor;
    public boolean is_collect;
    public String img;

    public boolean isIs_favor() {
        return is_favor;
    }

    public void setIs_favor(boolean is_favor) {
        this.is_favor = is_favor;
    }

    public boolean isIs_collect() {
        return is_collect;
    }

    public void setIs_collect(boolean is_collect) {
        this.is_collect = is_collect;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ShareDTO{" +
                "is_favor=" + is_favor +
                ", is_collect=" + is_collect +
                ", img='" + img + '\'' +
                ", id=" + id +
                ", user_id=" + user_id +
                ", tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                ", favor_num=" + favor_num +
                ", collect_num=" + collect_num +
                ", comment_num=" + comment_num +
                ", date=" + date +
                '}';
    }
}
