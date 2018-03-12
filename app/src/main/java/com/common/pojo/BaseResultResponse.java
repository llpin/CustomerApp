package com.common.pojo;

import java.io.Serializable;

/**
 * Created by linlipin on 18/3/1.
 */

public class BaseResultResponse<T> extends ResultResponseModel implements Serializable{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
