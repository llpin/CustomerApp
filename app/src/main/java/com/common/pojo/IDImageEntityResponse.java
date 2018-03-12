package com.common.pojo;

import com.common.base.enums.DirectionTypeEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class IDImageEntityResponse extends BaseEntityResponse {
    private String name;
    private String MD5;
    private String urlPath;
    private DirectionTypeEnum directionType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public DirectionTypeEnum getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionTypeEnum directionType) {
        this.directionType = directionType;
    }
}
