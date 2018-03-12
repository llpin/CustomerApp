package com.common.pojo;

import com.common.base.enums.PlatformMainTypeEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class PlatformMainTypeEntityResponse extends TypeEntityResponse {
    private PlatformMainTypeEnum code;

    public PlatformMainTypeEnum getCode() {
        return code;
    }

    public void setCode(PlatformMainTypeEnum code) {
        this.code = code;
    }
}
