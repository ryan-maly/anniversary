package com.cdc.anniversary.model;

public class Guide {
    public Integer id;
    public String title;
    public String guideContent;
    public String img;
    public String integration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuideContent() {
        return guideContent;
    }

    public void setGuideContent(String guideContent) {
        this.guideContent = guideContent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }
}
