package com.cdc.anniversary.model;

public class Guide {
    public Integer id;
    public String title;
    public String content;
    public String img;
    public String integration;

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", integration='" + integration + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }

    public String getIntegration() {
        return integration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }
}
