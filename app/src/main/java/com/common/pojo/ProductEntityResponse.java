package com.common.pojo;

/**
 * Created by linlipin on 18/3/3.
 */

public class ProductEntityResponse extends BaseEntityResponse{
    private String name;
    private String function;
    private String description;
    private ProductPromiseEntityResponse promise;
    private Long organizationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductPromiseEntityResponse getPromise() {
        return promise;
    }

    public void setPromise(ProductPromiseEntityResponse promise) {
        this.promise = promise;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
