package com.entity.vo.order;
import com.constant.OrderRelatedCode;
import com.entity.po.mdse.TMdseSales;
import com.opencsv.bean.CsvBindByPosition;
import com.service.mdse.IMdseInfoService;
import com.service.mdse.IMdseSalesService;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 京东导入订单
 */
public class JDSalesOrderVO {
    /**
     * 订单编号
     */
    @CsvBindByPosition(position=0)
    private String orderNo;
    /**
     * 商品编号
     */
    @CsvBindByPosition(position=1)
    private String mdseNo;
    /**
     * 商品名称
     */
    @CsvBindByPosition(position=2)
    private String mdseName;
    /**
     * 订单数量
     */
    @CsvBindByPosition(position=3)
    private String orderQuantity;
    /**
     * 支付方式
     */
    @CsvBindByPosition(position=4)
    private String payType;
    /**
     * 下单时间
     * yyyy-mm-dd HH:mm:ss
     */
    @CsvBindByPosition(position=5)
    private String lowerOrderTime;
    /**
     * 京东价
     */
    @CsvBindByPosition(position=6)
    private String jdPrice;
    /**
     * 订单金额
     */
    @CsvBindByPosition(position=7)
    private String orderAmount;
    /**
     * 实付金额
     */
    @CsvBindByPosition(position=8)
    private String actPayAmount;
    /**
     * 余额支付
     */
    @CsvBindByPosition(position=9)
    private String balancePay;
    /**
     * 应付金额
     */
    @CsvBindByPosition(position=10)
    private String amountsPay;
    /**
     * 订单状态
     */
    @CsvBindByPosition(position=11)
    private String orderStatus;
    /**
     * 订单类型
     */
    @CsvBindByPosition(position=12)
    private String orderType;
    /**
     * 下单帐号
     */
    @CsvBindByPosition(position=13)
    private String orderAccount;

    /**
     * 客户姓名
     */
    @CsvBindByPosition(position=14)
    private String custName;
    /**
     * 收货地址
     */
    @CsvBindByPosition(position=15)
    private String address;
    /**
     * 手机号
     */
    @CsvBindByPosition(position=16)
    private String numberNo;
    /**
     * 备注
     */
    @CsvBindByPosition(position=17)
    private String remarks;
    /**
     * 开票类型
     */
    @CsvBindByPosition(position=18)
    private String invoiceType;

    /**
     * 发票抬头
     */
    @CsvBindByPosition(position=19)
    private String invoice;
    /**
     * 发票内容
     */
    @CsvBindByPosition(position=20)
    private String invoiceInfo;
    /**
     * 纳税人识别号
     */
    @CsvBindByPosition(position=21)
    private String taxpayer;
    /**
     * 名称（个人）
     */
    @CsvBindByPosition(position=22)
    private String invoiceNamePerson;
    /**
     * 单位地址
     */
    @CsvBindByPosition(position=23)
    private String unitAddr;
    /**
     * 单位电话
     */
    @CsvBindByPosition(position=24)
    private String unitNumber;
    /**
     * 开户银行
     */
    @CsvBindByPosition(position=25)
    private String openBank;
    /**
     * 银行账号
     */
    @CsvBindByPosition(position=26)
    private String bankAccount;
    /**
     * 商家备注
     */
    @CsvBindByPosition(position=27)
    private String merChantNotes;
    /**
     * 商家备注等级（等级1-5为由高到低）
     */
    @CsvBindByPosition(position=28)
    private String merChantNotesLevel;
    /**
     * 运费金额
     */
    @CsvBindByPosition(position=29)
    private String shippingAmount;
    /**
     * 订单日期
     *
     */
    @CsvBindByPosition(position=30)
    private String orderDate;

    @CsvBindByPosition(position=31)
    private String header32;
    @CsvBindByPosition(position=32)
    private String header33;
    @CsvBindByPosition(position=33)
    private String header34;
    @CsvBindByPosition(position=34)
    private String header35;
    @CsvBindByPosition(position=35)
    private String header36;
    @CsvBindByPosition(position=36)
    private String header37;
    @CsvBindByPosition(position=37)
    private String header38;
    @CsvBindByPosition(position=38)
    private String header39;
    @CsvBindByPosition(position=39)
    private String header40;
    @CsvBindByPosition(position=40)
    private String header41;
    @CsvBindByPosition(position=41)
    private String header42;
    @CsvBindByPosition(position=42)
    private String header43;
    @CsvBindByPosition(position=43)
    private String header44;
    @CsvBindByPosition(position=44)
    private String header45;
    @CsvBindByPosition(position=45)
    private String header46;
    @CsvBindByPosition(position=46)
    private String header47;
    @CsvBindByPosition(position=47)
    private String header48;



    /**
     * 开票说明
     */
    private String invoiceFlg;

    private String orderChannel = OrderRelatedCode.ORDER_TYPE_2.getCode();

    private static String getOrderStatus(String orderTypeName){
        Map<String,String> map = new HashMap(){{
            put("等待付款", OrderRelatedCode.ORDER_STATUS_0.getCode());
            put("等待出库", OrderRelatedCode.ORDER_STATUS_1.getCode());
            put("等待确认收货", OrderRelatedCode.ORDER_STATUS_2.getCode());
            put("完成", OrderRelatedCode.ORDER_STATUS_3.getCode());
            put("(锁定)等待出库", OrderRelatedCode.ORDER_STATUS_4.getCode());
            put("锁定", OrderRelatedCode.ORDER_STATUS_4.getCode());
            put("(删除)等待出库", OrderRelatedCode.ORDER_STATUS_99.getCode());
            put("(删除)等待确认收货", OrderRelatedCode.ORDER_STATUS_99.getCode());
            put("(删除)等待付款", OrderRelatedCode.ORDER_STATUS_99.getCode());
            put("已取消", OrderRelatedCode.ORDER_STATUS_99.getCode());
        }};
        return map.get(orderTypeName);
    }
    private static String getInvoiceType(String invoiceTypeName){
        Map<String,String> map = new HashMap(){{
            put("普通发票", "1");
            put("增值税专用发票", "2");
            put("不开发票", "0");
        }};
        return map.get(invoiceTypeName);
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = getOrderStatus(orderStatus);
    }

    public String getMdseNo() {
        return mdseNo;
    }

    public void setMdseNo(String mdseNo) {

        this.mdseNo = mdseNo;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        String invoice = getInvoiceType(invoiceType.replaceAll("\r|\n|\t", ""));
        if("0".equals(invoice)){
            this.invoiceFlg = "2";//未开票
        }else {
            this.invoiceFlg = "1";//已开票
        }
        this.invoiceType = invoice;
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

    public String getMdseName() {
        return mdseName;
    }

    public void setMdseName(String mdseName) {
        this.mdseName = mdseName;
    }

    public Integer getOrderQuantity() {
        return Integer.valueOf(orderQuantity.replaceAll("\r|\n|\t", ""));
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getLowerOrderTime() {
        return lowerOrderTime;
    }

    public void setLowerOrderTime(String lowerOrderTime) {
        this.lowerOrderTime = lowerOrderTime;
    }

    public String getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(String jdPrice) {
        this.jdPrice = jdPrice;
    }

    public BigDecimal getOrderAmount() {
        return new BigDecimal(orderAmount.replaceAll("\r|\n|\t", ""));
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getActPayAmount() {
        return  new BigDecimal(actPayAmount.replaceAll("\r|\n|\t", ""));
    }

    public void setActPayAmount(String actPayAmount) {
        this.actPayAmount = actPayAmount;
    }

    public String getBalancePay() {
        return balancePay;
    }

    public void setBalancePay(String balancePay) {
        this.balancePay = balancePay;
    }

    public String getAmountsPay() {
        return amountsPay;
    }

    public void setAmountsPay(String amountsPay) {
        this.amountsPay = amountsPay;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberNo() {
        return numberNo;
    }

    public void setNumberNo(String numberNo) {
        this.numberNo = numberNo;
    }

    public String getRemarks() {
        return "客户备注:["+remarks+"],商家备注:["+merChantNotes+"]";
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(String invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(String invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public String getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(String taxpayer) {
        this.taxpayer = taxpayer;
    }


   public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }
}
