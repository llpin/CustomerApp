package com.common.pojo;

/**
 * Created by linlipin on 18/3/1.
 */

public class OrganizationEntityResponse extends BaseEntityResponse{
    private String code;
    private String name;
    private String description;
    private String email;
    private String telephone;
    private String phone;
    private String address;
    private String postAddress;
    private OrganizationTypeEntityResponse organizationType;
    private IndividualEntityResponse representative;
    private UserEntityResponse user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public OrganizationTypeEntityResponse getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationTypeEntityResponse organizationType) {
        this.organizationType = organizationType;
    }

    public IndividualEntityResponse getRepresentative() {
        return representative;
    }

    public void setRepresentative(IndividualEntityResponse representative) {
        this.representative = representative;
    }

    public UserEntityResponse getUser() {
        return user;
    }

    public void setUser(UserEntityResponse user) {
        this.user = user;
    }
}
