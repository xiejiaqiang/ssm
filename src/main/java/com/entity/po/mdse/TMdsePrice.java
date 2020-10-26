package com.entity.po.mdse;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_mdse_price
 * @author 
 */
public class TMdsePrice implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品编号
     */
    private String mdseNo;

    /**
     * 进货价
     */
    private BigDecimal buyingPrice;

    /**
     * 零售指导价
     */
    private BigDecimal retailPrice;

    /**
     * 底价
     */
    private BigDecimal floorPrice;

    /**
     * 批发价
     */
    private BigDecimal tradePrice;

    /**
     * 利润
     */
    private BigDecimal profit;

    /**
     * 利润率
     */
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
}