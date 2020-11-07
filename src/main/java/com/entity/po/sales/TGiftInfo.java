package com.entity.po.sales;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_gift_info
 * @author 
 */
public class TGiftInfo implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 礼品编号
     */
    @Column(name = "giftNo")
    private String giftNo;

    /**
     * 礼品名称
     */
    @Column(name = "giftName")
    private String giftName;

    /**
     * 礼品链接
     */
    @Column(name = "giftLink")
    private String giftLink;

    /**
     * 礼品金额
     */
    @Column(name = "giftAmount")
    private BigDecimal giftAmount;

    /**
     * 进货渠道
     */
    @Column(name = "channel")
    private String channel;

    /**
     * 礼品图片
     */
    @Column(name = "giftImg")
    private String giftImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftNo() {
        return giftNo;
    }

    public void setGiftNo(String giftNo) {
        this.giftNo = giftNo;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftLink() {
        return giftLink;
    }

    public void setGiftLink(String giftLink) {
        this.giftLink = giftLink;
    }

    public BigDecimal getGiftAmount() {
        return giftAmount;
    }

    public void setGiftAmount(BigDecimal giftAmount) {
        this.giftAmount = giftAmount;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getGiftImg() {
        return giftImg;
    }

    public void setGiftImg(String giftImg) {
        this.giftImg = giftImg;
    }

    private static final long serialVersionUID = 1L;
}