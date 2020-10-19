package com.entity.vo;

import java.io.Serializable;
import java.util.List;

public class BathInsertResultVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总条数
     */
    private Integer countSize;
    /**
     * 成功条数
     */
    private Integer successSize;
    /**
     * 失败条数
     */
    private Integer failSize;

    private List<FailInfoVo> failInfoVoList;

    public static class FailInfoVo implements Serializable {
        private static final long serialVersionUID = 1L;
        /**
         * 订单号
         */
        private String orderNo;
        /**
         * 失败原因
         */
        private String failMsg;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getFailMsg() {
            return failMsg;
        }

        public void setFailMsg(String failMsg) {
            this.failMsg = failMsg;
        }
    }

    public Integer getCountSize() {
        return countSize;
    }

    public void setCountSize(Integer countSize) {
        this.countSize = countSize;
    }

    public Integer getSuccessSize() {
        return successSize;
    }

    public void setSuccessSize(Integer successSize) {
        this.successSize = successSize;
    }

    public Integer getFailSize() {
        return failSize;
    }

    public void setFailSize(Integer failSize) {
        this.failSize = failSize;
    }

    public List<FailInfoVo> getFailInfoVoList() {
        return failInfoVoList;
    }

    public void setFailInfoVoList(List<FailInfoVo> failInfoVoList) {
        this.failInfoVoList = failInfoVoList;
    }
}

