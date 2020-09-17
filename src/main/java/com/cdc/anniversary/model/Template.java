package com.cdc.anniversary.model;

import java.util.List;

public class Template {
    private String touser;
    private String template_id;
    private List<TemplateParam> templateParamList;

    public String toJSON() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(String.format("\"touser\":\"%s\"", this.touser)).append(",");
        buffer.append(String.format("\"template_id\":\"%s\"", this.template_id)).append(",");
        buffer.append("\"data\":{");
        TemplateParam param = null;
        for (int i = 0; i < this.templateParamList.size(); i++) {
            param = templateParamList.get(i);
            // 判断是否追加逗号  
            if (i < this.templateParamList.size() - 1){
                buffer.append(String.format("\"%s\": {\"value\":\"%s\"},", param.getKey(), param.getValue()));
            }else{
                buffer.append(String.format("\"%s\": {\"value\":\"%s\"}", param.getKey(), param.getValue()));
            }
        }
        buffer.append("}");
        buffer.append("}");
        return buffer.toString();
    }

    @Override
    public String toString() {
        return "Template{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", templateParamList=" + templateParamList +
                '}';
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public List<TemplateParam> getTemplateParamList() {
        return templateParamList;
    }

    public void setTemplateParamList(List<TemplateParam> templateParamList) {
        this.templateParamList = templateParamList;
    }
}
