package com.entity.vo;

import com.entity.po.mdse.TMdsePrice;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class MdseInfoVO  implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品编号
     */
    private String mdseNo;

    /**
     * 商品名称
     */
    private String mdseName;

    /**
     * 标题
     */
    private String title;

    /**
     * 颜色
     */
    private String colour;

    /**
     * 型号
     */
    private String model;

    /**
     * 商品分类
     */
    private String mdseCat;

    /**
     * 商品库存
     */
    private Byte mdseSku;

    /**
     * 商品状态 0-待上市;1-已上市;2-已下市
     */
    private String mdseStatus;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 系列
     */
    private String series;

    /**
     * 卖点
     */
    private String sellingPoint;

    /**
     * 图片ID
     */
    private String pictureId;

    /**
     * 参数1
     */
    private String parameter1;

    /**
     * 参数2
     */
    private String parameter2;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private TMdsePrice mdsePrice;

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

    public Byte getMdseSku() {
        return mdseSku;
    }

    public void setMdseSku(Byte mdseSku) {
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

    public TMdsePrice getMdsePrice() {
        return mdsePrice;
    }

    public void setMdsePrice(TMdsePrice mdsePrice) {
        this.mdsePrice = mdsePrice;
    }
}
