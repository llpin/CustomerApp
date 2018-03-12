package com.common.pojo;

import com.common.base.enums.DataStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linlipin on 18/3/1.
 */

public class BaseEntityResponse implements Serializable {
    private Long id;
    private DataStatusEnum dataStatus;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DataStatusEnum getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(DataStatusEnum dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
