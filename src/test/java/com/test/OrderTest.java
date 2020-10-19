package com.test;

import com.entity.po.payOrder.TOrderInfo;
import com.github.pagehelper.PageInfo;
import com.service.payOrder.IOrderInfoService;
import com.test.init.BaseTest;
import com.test.init.TestMenuTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(TestMenuTree.class);
    @Autowired
    private IOrderInfoService orderInfoService;
    @Test
    public void queryList(){
        List<TOrderInfo> list= null;
        try {
            list = orderInfoService.findOrderInfo(new TOrderInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("===========数据查询成功！userList={}",list);
    }

    @Test
    public void findOrderInfoPage(){
        TOrderInfo t = new TOrderInfo();
        PageInfo<TOrderInfo> list=null;
        try {
            list = orderInfoService.findOrderInfoPage(t,5,1,"","","2020-10-19","2020-10-19");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("===========数据查询成功！userList={}",list);
    }
    @Test
    public void insert(){
        TOrderInfo t = new TOrderInfo();
        t.setActPayAmount(new BigDecimal("999"));
        t.setAddress("黑龙江省鹤岗市");
        t.setCustName("李三");
        t.setInvoiceFlg("2");
        t.setLogisticsNo("12313");
        t.setMdseNo("1999991121");
        t.setNumberNo("13104008890");
        t.setOrderAmount(new BigDecimal("3101"));
        t.setOrderChannel("1");
        t.setOrderDate(new Date());
        t.setOrderNo("1232132131");
        t.setOrderStatus("3");
        t.setRemarks("备注");
        try {
            int c = orderInfoService.addOrderInfo(t);
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
