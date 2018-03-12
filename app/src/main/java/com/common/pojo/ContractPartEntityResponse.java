package com.common.pojo;

import java.util.Date;

/**
 * Created by linlipin on 18/3/9.
 */

public class ContractPartEntityResponse extends BaseEntityResponse {
    private ContractEntityResponse contract;
    private Long userId;
    private String encUserId;
    private String vkSign;
    private String vkSaveDate;
    private Date saveDate;
    private String pkShareKey;


    public ContractEntityResponse getContract() {
        return contract;
    }

    public void setContract(ContractEntityResponse contract) {
        this.contract = contract;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEncUserId() {
        return encUserId;
    }

    public void setEncUserId(String encUserId) {
        this.encUserId = encUserId;
    }

    public String getVkSign() {
        return vkSign;
    }

    public void setVkSign(String vkSign) {
        this.vkSign = vkSign;
    }

    public String getVkSaveDate() {
        return vkSaveDate;
    }

    public void setVkSaveDate(String vkSaveDate) {
        this.vkSaveDate = vkSaveDate;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public String getPkShareKey() {
        return pkShareKey;
    }

    public void setPkShareKey(String pkShareKey) {
        this.pkShareKey = pkShareKey;
    }
}
