package com.common.pojo;

import com.common.base.enums.EmployeeLevelEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class EmployeeTypeEntityResponse extends TypeEntityResponse {
    private String code;
    private OrganizationTypeEntityResponse organizationType;
    private EmployeeLevelEnum employeeLevel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OrganizationTypeEntityResponse getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationTypeEntityResponse organizationType) {
        this.organizationType = organizationType;
    }

    public EmployeeLevelEnum getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevelEnum employeeLevel) {
        this.employeeLevel = employeeLevel;
    }
}
