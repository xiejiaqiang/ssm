package com.entity.po.mdse;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * t_mdse_region
 * @author 
 */

public class TMdseRegion implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 省份
     */
    @Column(name = "province")
    private String province;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 区
     */
    @Column(name = "area")
    private String area;

    /**
     * 商品编号
     */
    @Column(name = "mdseNo")
    private String mdseNo;

    /**
     * 商品分类
     */
    @Column(name = "mdseCat")
    private String mdseCat;

    /**
     * 数量
     */
    @Column(name = "number")
    private Long number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMdseNo() {
        return mdseNo;
    }

    public void setMdseNo(String mdseNo) {
        this.mdseNo = mdseNo;
    }

    public String getMdseCat() {
        return mdseCat;
    }

    public void setMdseCat(String mdseCat) {
        this.mdseCat = mdseCat;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    private static final long serialVersionUID = 1L;
}