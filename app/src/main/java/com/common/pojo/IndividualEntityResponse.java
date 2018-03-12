package com.common.pojo;

import com.common.base.enums.GenderTypeEnum;

/**
 * Created by linlipin on 18/3/1.
 */

public class IndividualEntityResponse extends BaseEntityResponse {

    private String name;
    private UserEntityResponse user;
    private GenderTypeEnum genderType;

    private String email;
    private String telephone;
    private String phone;
    private String address;
    private String postAddress;
    private String idNumber;
    private IDImageEntityResponse frontIDImage;
    private IDImageEntityResponse backIDImage;
    private Long backIDImageId;
    private IndividualTypeEntityResponse individualType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntityResponse getUser() {
        return user;
    }

    public void setUser(UserEntityResponse user) {
        this.user = user;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public IDImageEntityResponse getFrontIDImage() {
        return frontIDImage;
    }

    public void setFrontIDImage(IDImageEntityResponse frontIDImage) {
        this.frontIDImage = frontIDImage;
    }

    public IDImageEntityResponse getBackIDImage() {
        return backIDImage;
    }

    public void setBackIDImage(IDImageEntityResponse backIDImage) {
        this.backIDImage = backIDImage;
    }

    public Long getBackIDImageId() {
        return backIDImageId;
    }

    public void setBackIDImageId(Long backIDImageId) {
        this.backIDImageId = backIDImageId;
    }

    public IndividualTypeEntityResponse getIndividualType() {
        return individualType;
    }

    public void setIndividualType(IndividualTypeEntityResponse individualType) {
        this.individualType = individualType;
    }
}
