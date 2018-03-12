package com.common.pojo;

import com.common.base.enums.AuditStateEnum;

/**
 * Created by linlipin on 18/3/3.
 */

public class CodeOrderEntityResponse extends BaseEntityResponse{
    private String code;
    private ProductEntityResponse product;
    private Long productId;
    private Long count;
    //    工厂->购买方
    private OrganizationEntityResponse factory;
    private String factorySign;
    private OrganizationEntityResponse lawfirm;
    private String lawfirmSign;
    private AuditStateEnum stateEnum = AuditStateEnum.NORMAL;
    private String auditContent;
    private EmployeeEntityResponse centerEmployee;
    private Long centerEmployeeId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProductEntityResponse getProduct() {
        return product;
    }

    public void setProduct(ProductEntityResponse product) {
        this.product = product;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public OrganizationEntityResponse getFactory() {
        return factory;
    }

    public void setFactory(OrganizationEntityResponse factory) {
        this.factory = factory;
    }

    public String getFactorySign() {
        return factorySign;
    }

    public void setFactorySign(String factorySign) {
        this.factorySign = factorySign;
    }

    public OrganizationEntityResponse getLawfirm() {
        return lawfirm;
    }

    public void setLawfirm(OrganizationEntityResponse lawfirm) {
        this.lawfirm = lawfirm;
    }

    public String getLawfirmSign() {
        return lawfirmSign;
    }

    public void setLawfirmSign(String lawfirmSign) {
        this.lawfirmSign = lawfirmSign;
    }

    public AuditStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(AuditStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public EmployeeEntityResponse getCenterEmployee() {
        return centerEmployee;
    }

    public void setCenterEmployee(EmployeeEntityResponse centerEmployee) {
        this.centerEmployee = centerEmployee;
    }

    public Long getCenterEmployeeId() {
        return centerEmployeeId;
    }

    public void setCenterEmployeeId(Long centerEmployeeId) {
        this.centerEmployeeId = centerEmployeeId;
    }
}
