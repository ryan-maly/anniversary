package com.cdc.anniversary.model;

public class Store {
    private Integer id;
    private Integer userId;
    private Integer shareId;

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", userId=" + userId +
                ", shareId=" + shareId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }
}
