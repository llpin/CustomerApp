package com.common.pojo;

import java.io.Serializable;

/**
 * Created by linlipin on 18/3/1.
 */

public class UserVoResponse implements Serializable{

    private UserEntityResponse user;
    private OrganizationEntityResponse organization;
    private IndividualEntityResponse individual;
    private EmployeeEntityResponse employee;

    public UserEntityResponse getUser() {
        return user;
    }

    public void setUser(UserEntityResponse user) {
        this.user = user;
    }

    public OrganizationEntityResponse getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntityResponse organization) {
        this.organization = organization;
    }

    public IndividualEntityResponse getIndividual() {
        return individual;
    }

    public void setIndividual(IndividualEntityResponse individual) {
        this.individual = individual;
    }

    public EmployeeEntityResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntityResponse employee) {
        this.employee = employee;
    }
}
