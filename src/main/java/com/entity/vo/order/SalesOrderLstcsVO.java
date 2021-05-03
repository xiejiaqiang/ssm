package com.entity.vo.order;
import com.constant.OrderRelatedCode;
import com.opencsv.bean.CsvBindByPosition;
import com.service.mdse.IMdseSalesService;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 物流单号
 */
public class SalesOrderLstcsVO {
    /**
     * 订单编号
     */
    @CsvBindByPosition(position=0)
    private String orderNo;
    /**
     * 快递公司
     */
    @CsvBindByPosition(position=1)
    private String logisticsFirm;
    /**
     * 快递单号
     */
    @CsvBindByPosition(position=2)
    private String logisticsNo;
    /**
     * 订单渠道
     */
    @CsvBindByPosition(position=3)
    private String orderChannel;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLogisticsFirm() {
        return logisticsFirm;
    }

    public void setLogisticsFirm(String logisticsFirm) {
        this.logisticsFirm = logisticsFirm;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }
}
