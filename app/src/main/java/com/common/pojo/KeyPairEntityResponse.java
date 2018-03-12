package com.common.pojo;

import com.common.base.enums.KeyStateEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class KeyPairEntityResponse extends BaseEntityResponse {
    private Long userId;
    private String encPrivateKey;
    private String publicKey;
    private KeyStateEnum stateEnum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEncPrivateKey() {
        return encPrivateKey;
    }

    public void setEncPrivateKey(String encPrivateKey) {
        this.encPrivateKey = encPrivateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public KeyStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(KeyStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }
}
