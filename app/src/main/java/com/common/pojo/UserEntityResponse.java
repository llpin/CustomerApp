package com.common.pojo;

/**
 * Created by linlipin on 18/3/1.
 */

public class UserEntityResponse extends BaseEntityResponse {
    private String globalId;
    private String username;
    private String password;
    private String doPassword;
    private PlatformMainTypeEntityResponse platformMainType;
    private KeyPairEntityResponse keyPair;

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDoPassword() {
        return doPassword;
    }

    public void setDoPassword(String doPassword) {
        this.doPassword = doPassword;
    }

    public PlatformMainTypeEntityResponse getPlatformMainType() {
        return platformMainType;
    }

    public void setPlatformMainType(PlatformMainTypeEntityResponse platformMainType) {
        this.platformMainType = platformMainType;
    }

    public KeyPairEntityResponse getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPairEntityResponse keyPair) {
        this.keyPair = keyPair;
    }
}
