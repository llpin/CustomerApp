package com.common.vo;

/**
 * Created by linlipin on 18/3/2.
 */

public class TypeVo<T> {
//    enum
    T em;
    String value;

    public TypeVo(T em, String value) {
        this.em = em;
        this.value = value;
    }

    public T getEm() {
        return em;
    }

    public void setEm(T em) {
        this.em = em;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
