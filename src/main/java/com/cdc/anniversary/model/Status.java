package com.cdc.anniversary.model;

public class Status {
    public Integer share_id;
    public Integer user_id;
    public boolean is_favor;
    public boolean is_collect;

    public Integer getShare_id() {
        return share_id;
    }

    public void setShare_id(Integer share_id) {
        this.share_id = share_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

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

    @Override
    public String toString() {
        return "Status{" +
                "share_id=" + share_id +
                ", user_id=" + user_id +
                ", is_favor=" + is_favor +
                ", is_collect=" + is_collect +
                '}';
    }
}
