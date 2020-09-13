package com.cdc.anniversary.dto;

import com.cdc.anniversary.model.Share;

import java.util.List;


public class ShareDTO extends Share {
    public boolean is_favor;
    public boolean is_collect;
    public List<String> images;

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
