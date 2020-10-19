package com.entity.po.payOrder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TOrderInfo implements Serializable {
    /**
     * ID 主键
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 订单编号
     */
    @Column(name = "orderNo")
    private String orderNo;

    /**
     * 商品编号
     */
    @Column(name = "mdseNo")
    private String mdseNo;

    /**
     * 商品名称
     */
    @Transient
    private String mdseName;

    /**
     * 客户姓名
     */
    @Column(name = "custName")
    private String custName;

    /**
     * 手机号
     */
    @Column(name = "numberNo")
    private String numberNo;

    /**
     * 收货地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 订单金额
     */
    @Column(name = "orderAmount")
    private BigDecimal orderAmount;

    /**
     * 实付金额
     */
    @Column(name = "actPayAmount")
    private BigDecimal actPayAmount;

    /**
     * 优惠分类
     */
    @Column(name = "discountType")
    private String discountType;

    /**
     * 订单状态
     */
    @Column(name = "orderStatus")
    private String orderStatus;

    /**
     * 物流单号
     */
    @Column(name = "logisticsNo")
    private String logisticsNo;

    /**
     * 开票说明
     */
    @Column(name = "invoiceFlg")
    private String invoiceFlg;

    /**
     * 开票类型
     */
    @Column(name = "invoiceType")
    private String invoiceType;

    /**
     * 订单日期
     */
    @Column(name = "orderDate")
    private Date orderDate;

    /**
     * 订单渠道
     */
    @Column(name = "orderChannel")
    private String orderChannel;


    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMdseNo() {
        return mdseNo;
    }

    public void setMdseNo(String mdseNo) {
        this.mdseNo = mdseNo;
    }

    public String getMdseName() {
        return mdseName;
    }

    public void setMdseName(String mdseName) {
        this.mdseName = mdseName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNumberNo() {
        return numberNo;
    }

    public void setNumberNo(String numberNo) {
        this.numberNo = numberNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getActPayAmount() {
        return actPayAmount;
    }

    public void setActPayAmount(BigDecimal actPayAmount) {
        this.actPayAmount = actPayAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(String invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}