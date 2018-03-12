package com.common.pojo;

import com.common.base.enums.ProductCodeStateEnum;

/**
 * Created by linlipin on 18/3/3.
 */

public class ProductCodeEntityResponse extends BaseEntityResponse {
    private String code;
    private String lawfirmPKCode;
    private String factoryVKSign;
    private CodeOrderEntityResponse order;
    private ContractEntityResponse contract;
    private ProductCodeStateEnum stateEnum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLawfirmPKCode() {
        return lawfirmPKCode;
    }

    public void setLawfirmPKCode(String lawfirmPKCode) {
        this.lawfirmPKCode = lawfirmPKCode;
    }

    public String getFactoryVKSign() {
        return factoryVKSign;
    }

    public void setFactoryVKSign(String factoryVKSign) {
        this.factoryVKSign = factoryVKSign;
    }

    public CodeOrderEntityResponse getOrder() {
        return order;
    }

    public void setOrder(CodeOrderEntityResponse order) {
        this.order = order;
    }

    public ContractEntityResponse getContract() {
        return contract;
    }

    public void setContract(ContractEntityResponse contract) {
        this.contract = contract;
    }

    public ProductCodeStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(ProductCodeStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }
}
