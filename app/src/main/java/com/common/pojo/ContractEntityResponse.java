package com.common.pojo;

/**
 * Created by linlipin on 18/3/3.
 */

public class ContractEntityResponse extends BaseEntityResponse {
    private String enc_cno;
    private String cno;
    //    合同起草者
    private UserEntityResponse draftUser;
    private String title;
    private String encTitle;
    private String encContent;
    private String content;
    private String encSaveDate;
    private String abstractMD5;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnc_cno() {
        return enc_cno;
    }

    public void setEnc_cno(String enc_cno) {
        this.enc_cno = enc_cno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public UserEntityResponse getDraftUser() {
        return draftUser;
    }

    public void setDraftUser(UserEntityResponse draftUser) {
        this.draftUser = draftUser;
    }

    public String getEncTitle() {
        return encTitle;
    }

    public void setEncTitle(String encTitle) {
        this.encTitle = encTitle;
    }

    public String getEncContent() {
        return encContent;
    }

    public void setEncContent(String encContent) {
        this.encContent = encContent;
    }

    public String getEncSaveDate() {
        return encSaveDate;
    }

    public void setEncSaveDate(String encSaveDate) {
        this.encSaveDate = encSaveDate;
    }

    public String getAbstractMD5() {
        return abstractMD5;
    }

    public void setAbstractMD5(String abstractMD5) {
        this.abstractMD5 = abstractMD5;
    }
}
