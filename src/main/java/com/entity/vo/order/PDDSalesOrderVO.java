package com.entity.vo.order;
import com.config.util.SimpleBeanFieldConverter;
import com.constant.OrderRelatedCode;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.util.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 拼多多导入订单
 */
public class PDDSalesOrderVO {
    /**
     * 商品
     */
    @CsvBindByPosition(position=0)
    private String mdse;
    /**
     * 订单号
     */
    @CsvBindByPosition(position=1)
    private String orderNo;
    /**
     * 订单状态
     */
    @CsvBindByPosition(position=2)
    private String orderStatus;
    /**
     * 订单金额
     */
    @CsvBindByPosition(position=3)
    private String orderAmount;
    /**
     * 店铺优惠折扣(元)
     */
    @CsvBindByPosition(position=4)
    private String header5;
    /**
     * 平台优惠折扣(元)
     */
    @CsvBindByPosition(position=5)
    private String header6;
    /**
     * 用户实付金额(元)
     */
    @CsvBindByPosition(position=6)
    private String header7;

    /**
     * 实付金额
     */
    @CsvBindByPosition(position=7)
    private String actPayAmount;

    /**
     * 订单数量
     */
    @CsvBindByPosition(position=8)
    private String orderQuantity;

    /**
     * 发货时间
     */
    @CsvBindByPosition(position=9)
    private String header10;
    /**
     * 确认收货时间
     * yyyy-mm-dd HH:mm:ss
     */
    @CsvBindByPosition(position=10)
    private String header11;

    /**
     * 商品编号
     */
    @CsvBindByPosition(position=11)
    private String mdseNo;

    /**
     * 商品规格
     */
    @CsvBindByPosition(position=12)
    private String header12;

    /**
     * 样式ID
     */
    @CsvBindByPosition(position=13)
    private String header13;

    /**
     * 备注
     */
    @CsvBindByPosition(position=14)
    private String remarks;

    /**
     * 售后状态
     */
    @CsvBindByPosition(position=15)
    private String header14;
    /**
     * 快递单号
     */
    @CsvBindByPosition(position=16)
    private String logisticsNo;
    /**
     * 快递公司
     */
    @CsvBindByPosition(position=17)
    private String logisticsFirm;
    /**
     * 订单日期
     *
     */
    @CsvBindByPosition(position=18)
    private String orderDate;

    /**
     * 开票说明
     */
    private String invoiceFlg = "2";

    private String orderChannel = OrderRelatedCode.ORDER_TYPE_4.getCode();

    public String getOrderStatus(){
        Map<String,String> map = new HashMap(){{
            put("待支付", OrderRelatedCode.ORDER_STATUS_0.getCode());
            put("待发货", OrderRelatedCode.ORDER_STATUS_1.getCode());
            put("已发货，待签收", OrderRelatedCode.ORDER_STATUS_2.getCode());
            put("已签收", OrderRelatedCode.ORDER_STATUS_3.getCode());
            put("未发货，退款成功", OrderRelatedCode.ORDER_STATUS_5.getCode());
            put("已发货，退款成功", OrderRelatedCode.ORDER_STATUS_5.getCode());
            put("已取消", OrderRelatedCode.ORDER_STATUS_99.getCode());
        }};
        return map.get(orderStatus);
    }

    public Date getOrderDate() {
        try {
            return DateUtil.ParseTime(orderDate.replaceAll("\r|\n|\t", ""),"yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            return null;
        }
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMdse() {
        return mdse;
    }

    public void setMdse(String mdse) {
        this.mdse = mdse;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderAmount() {
        return new BigDecimal(orderAmount.replaceAll("\r|\n|\t", ""));
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getHeader5() {
        return header5;
    }

    public void setHeader5(String header5) {
        this.header5 = header5;
    }

    public String getHeader6() {
        return header6;
    }

    public void setHeader6(String header6) {
        this.header6 = header6;
    }

    public String getHeader7() {
        return header7;
    }

    public void setHeader7(String header7) {
        this.header7 = header7;
    }

    public BigDecimal getActPayAmount() {
        return new BigDecimal(actPayAmount.replaceAll("\r|\n|\t", ""));
    }

    public void setActPayAmount(String actPayAmount) {
        this.actPayAmount = actPayAmount;
    }

    public Integer getOrderQuantity() {
        try {
            return Integer.valueOf(orderQuantity.replaceAll("\r|\n|\t", ""));
        }catch (Exception e){
            return null;
        }
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getHeader10() {
        return header10;
    }

    public void setHeader10(String header10) {
        this.header10 = header10;
    }

    public String getHeader11() {
        return header11;
    }

    public void setHeader11(String header11) {
        this.header11 = header11;
    }

    public String getMdseNo() {
        return mdseNo;
    }

    public void setMdseNo(String mdseNo) {
        this.mdseNo = mdseNo;
    }

    public String getHeader12() {
        return header12;
    }

    public void setHeader12(String header12) {
        this.header12 = header12;
    }

    public String getHeader13() {
        return header13;
    }

    public void setHeader13(String header13) {
        this.header13 = header13;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getHeader14() {
        return header14;
    }

    public void setHeader14(String header14) {
        this.header14 = header14;
    }

    public String getLogisticsNo() {
        return this.logisticsFirm+":"+logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getLogisticsFirm() {
        return logisticsFirm;
    }

    public void setLogisticsFirm(String logisticsFirm) {
        this.logisticsFirm = logisticsFirm;
    }

    public String getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(String invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }
}
