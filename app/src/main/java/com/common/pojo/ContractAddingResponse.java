package com.common.pojo;

/**
 * Created by linlipin on 18/3/8.
 */

public class ContractAddingResponse extends ResultResponseModel{
    private Long contractId;
    private String contractNo;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
}
