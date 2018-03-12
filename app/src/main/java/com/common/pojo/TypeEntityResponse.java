package com.common.pojo;

/**
 * Created by linlipin on 18/3/1.
 */

public class TypeEntityResponse extends BaseEntityResponse {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
