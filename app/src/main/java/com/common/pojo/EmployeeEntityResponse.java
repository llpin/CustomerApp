package com.common.pojo;

import com.common.base.enums.GenderTypeEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class EmployeeEntityResponse extends BaseEntityResponse {
    private String name;
    private GenderTypeEnum genderType;
    private String email;
    private String telephone;
    private String phone;
    private String innerId;
    private EmployeeTypeEntityResponse employeeType;
    private Long EmployeeTypeId;
    UserEntityResponse user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderTypeEnum getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderTypeEnum genderType) {
        this.genderType = genderType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInnerId() {
        return innerId;
    }

    public void setInnerId(String innerId) {
        this.innerId = innerId;
    }

    public EmployeeTypeEntityResponse getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeTypeEntityResponse employeeType) {
        this.employeeType = employeeType;
    }

    public Long getEmployeeTypeId() {
        return EmployeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        EmployeeTypeId = employeeTypeId;
    }

    public UserEntityResponse getUser() {
        return user;
    }

    public void setUser(UserEntityResponse user) {
        this.user = user;
    }
}
