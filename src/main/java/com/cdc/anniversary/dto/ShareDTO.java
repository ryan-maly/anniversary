package com.cdc.anniversary.dto;

import com.cdc.anniversary.model.Share;
import lombok.Data;

import java.util.List;

@Data
public class ShareDTO extends Share {
    public boolean is_favor;
    public boolean is_collect;
    public String img;

    @Override
    public String toString() {
        return "ShareDTO{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                ", favor_num=" + favor_num +
                ", collection_num=" + collect_num +
                ", comment_num=" + comment_num +
                ", date=" + date +
                ", is_favor=" + is_favor +
                ", is_collect=" + is_collect +
                ", img='" + img + '\'' +
                '}';
    }
}
