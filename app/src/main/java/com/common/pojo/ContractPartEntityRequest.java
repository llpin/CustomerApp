package com.common.pojo;

/**
 * Created by linlipin on 18/3/9.
 */

public class ContractPartEntityRequest {
    private Long userId;
    private Long contractId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
