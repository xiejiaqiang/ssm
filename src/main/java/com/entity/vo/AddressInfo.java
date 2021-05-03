package com.entity.vo;

import com.opencsv.bean.CsvBindByPosition;

public class AddressInfo {
    /**
     * 国家
     */
    private String country;
    /**
     * 省/自治区/直辖市
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 城市等级
     */
    private String countryLevel;
    /**
     * 区
     */
    private String district;
    /**
     * 行政区划代码
     */
    private String adcode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryLevel() {
        return countryLevel;
    }

    public void setCountryLevel(String countryLevel) {
        this.countryLevel = countryLevel;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
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
}
