package com.common.pojo;

import com.common.base.enums.OrganizationTypeEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class OrganizationTypeEntityResponse extends TypeEntityResponse {
    private OrganizationTypeEnum code;

    public OrganizationTypeEnum getCode() {
        return code;
    }

    public void setCode(OrganizationTypeEnum code) {
        this.code = code;
    }
}
