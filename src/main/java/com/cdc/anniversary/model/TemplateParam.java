package com.cdc.anniversary.model;


public class TemplateParam {
    private String key;
    private String value;

    public TemplateParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TemplateParam{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
