package com.entity.po.mdse;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_mdse_sales
 * @author 
 */
public class TMdseSales implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 销售平台id
     */
    @Column(name = "platformId")
    private String platformId;

    /**
     * 商品编号
     */
    @Column(name = "mdseNo")
    private String mdseNo;

    /**
     * 销售渠道 1-天猫 2-京东 3-淘宝 4-拼多多
     */
    @Column(name = "salesChannel")
    private String salesChannel;

    /**
     * 日常售价
     */
    @Column(name = "dailyPrice")
    private BigDecimal dailyPrice;

    /**
     * 在售价
     */
    @Column(name = "inPrice")
    private BigDecimal inPrice;

    /**
     * 活动价
     */
    @Column(name = "activityPrice")
    private BigDecimal activityPrice;

    /**
     * 大销价
     */
    @Column(name = "promotionPrice")
    private BigDecimal promotionPrice;

    /**
     * 优惠金额
     */
    @Column(name = "preferentialAmount")
    private BigDecimal preferentialAmount;

    /**
     * 优惠方式 0-优惠券 2-满减 3-预售立减 4-限时秒杀
     */
    @Column(name = "preferentialType")
    private String preferentialType;

    /**
     * 配额
     */
    @Column(name = "salesSku")
    private Long salesSku;

    /**
     * 销售状态0-待上架 1-已上架 2-已售罄 3-已下架
     */
    @Column(name = "salesStatus")
    private String salesStatus;


    /**
     * 商品链接
     */
    @Column(name = "mdseUrl")
    private String mdseUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMdseNo() {
        return mdseNo;
    }

    public void setMdseNo(String mdseNo) {
        this.mdseNo = mdseNo;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public BigDecimal getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(BigDecimal dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public BigDecimal getPreferentialAmount() {
        return preferentialAmount;
    }

    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    public String getPreferentialType() {
        return preferentialType;
    }

    public void setPreferentialType(String preferentialType) {
        this.preferentialType = preferentialType;
    }

    public void setSalesSku(Long salesSku) {
        this.salesSku = salesSku;
    }

    public Long getSalesSku() {
        return salesSku;
    }

    public String getMdseUrl() {
        return mdseUrl;
    }

    public void setMdseUrl(String mdseUrl) {
        this.mdseUrl = mdseUrl;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    private static final long serialVersionUID = 1L;
}