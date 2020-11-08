package com.entity.po.mdse;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_mdse_info
 * @author 
 */
public class TMdseInfo implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 商品编号
     */
    @Column(name = "mdseNo")
    private String mdseNo;

    /**
     * 商品名称
     */
    @Column(name = "mdseName")
    private String mdseName;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 颜色
     */
    @Column(name = "colour")
    private String colour;

    /**
     * 型号
     */
    @Column(name = "model")
    private String model;

    /**
     * 商品分类
     */
    @Column(name = "mdseCat")
    private String mdseCat;

    /**
     * 商品库存
     */
    @Column(name = "mdseSku")
    private Integer mdseSku;

    /**
     * 商品状态 0-待上市;1-已上市;2-已下市
     */
    @Column(name = "mdseStatus")
    private String mdseStatus;

    /**
     * 品牌
     */
    @Column(name = "brand")
    private String brand;

    /**
     * 系列
     */
    @Column(name = "series")
    private String series;

    /**
     * 卖点
     */
    @Column(name = "sellingPoint")
    private String sellingPoint;

    /**
     * 图片ID
     */
    @Column(name = "pictureId")
    private String pictureId;

    /**
     * 参数1
     */
    @Column(name = "parameter1")
    private String parameter1;

    /**
     * 参数2
     */
    @Column(name = "parameter2")
    private String parameter2;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updateTime;

    /**t_mdse_price */
    /**
     * 进货价
     */
    @Transient
    private Long priceId;
    /**
     * 进货价
     */
    @Transient
    private BigDecimal buyingPrice;

    /**
     * 零售指导价
     */
    @Transient
    private BigDecimal retailPrice;

    /**
     * 底价
     */
    @Transient
    private BigDecimal floorPrice;

    /**
     * 活动价
     */
    @Transient
    private BigDecimal tradePrice;

    /**
     * 利润
     */
    @Transient
    private BigDecimal profit;

    /**
     * 利润率
     */
    @Transient
    private String profitMargin;

    private static final long serialVersionUID = 1L;

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

    public String getMdseName() {
        return mdseName;
    }

    public void setMdseName(String mdseName) {
        this.mdseName = mdseName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMdseCat() {
        return mdseCat;
    }

    public void setMdseCat(String mdseCat) {
        this.mdseCat = mdseCat;
    }

    public Integer getMdseSku() {
        return mdseSku;
    }

    public void setMdseSku(Integer mdseSku) {
        this.mdseSku = mdseSku;
    }

    public String getMdseStatus() {
        return mdseStatus;
    }

    public void setMdseStatus(String mdseStatus) {
        this.mdseStatus = mdseStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
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

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
}