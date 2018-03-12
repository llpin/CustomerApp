package com.common.pojo;

import com.common.base.enums.IndividualTypeEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class IndividualTypeEntityResponse extends TypeEntityResponse {
    private IndividualTypeEnum code;

    public IndividualTypeEnum getCode() {
        return code;
    }

    public void setCode(IndividualTypeEnum code) {
        this.code = code;
    }
}
