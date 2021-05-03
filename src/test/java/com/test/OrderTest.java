package com.test;

import com.entity.po.mdse.TMdseInfo;
import com.entity.po.mdse.TMdseRegion;
import com.entity.po.order.TOrderInfo;
import com.entity.vo.AddressInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageInfo;
import com.service.mdse.IMdseInfoService;
import com.service.mdse.IMdseRegionService;
import com.service.order.IOrderInfoService;
import com.test.init.BaseTest;
import com.test.init.TestMenuTree;
import com.util.AddressResolutionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(TestMenuTree.class);
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    IMdseRegionService mdseRegionService;
    @Autowired
    IMdseInfoService mdseInfoService;
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

    /**
     * 更新地区
     */
    @Test
    public void test(){
        try {
         List<TOrderInfo> orderInfos = orderInfoService.findOrderInfo(new TOrderInfo());
            for (TOrderInfo t: orderInfos) {
                try {
                    //解析地址
                    AddressInfo addressInfo = AddressResolutionUtil.getAddressComponent(t.getAddress());
                    TMdseRegion mdseRegion = new TMdseRegion();
                    mdseRegion.setMdseNo(t.getMdseNo());
                    mdseRegion.setCity(addressInfo.getCity());
                    List<TMdseRegion> mdseRegions = mdseRegionService.findMdseRegion(mdseRegion);
                    if(mdseRegions !=null && mdseRegions.size()>0){
                        mdseRegion = mdseRegions.get(0);
                        if (!mdseRegion.getArea().contains(addressInfo.getDistrict())){
                            mdseRegion.setArea(mdseRegion.getArea()+addressInfo.getDistrict()+"|");
                        }
                        mdseRegion.setNumber(mdseRegion.getNumber()+Long.valueOf(t.getOrderQuantity()));
                        mdseRegionService.updateMdseRegion(mdseRegion);
                    }else {
                        mdseRegion = new TMdseRegion();
                        mdseRegion.setMdseNo(t.getMdseNo());
                        TMdseInfo mdseInfo = mdseInfoService.findMdseInfoByMdseNo(t.getMdseNo());
                        mdseRegion.setMdseCat(mdseInfo.getMdseCat());
                        //解析地址
                        mdseRegion.setProvince(AddressResolutionUtil.proinceZh(addressInfo.getProvince()));
                        mdseRegion.setCity(addressInfo.getCity());
                        mdseRegion.setArea(addressInfo.getDistrict()+"|");

                        mdseRegion.setNumber(Long.valueOf(t.getOrderQuantity()));
                        mdseRegionService.addMdseRegion(mdseRegion);
                    }
                }catch (Exception e){
                    TOrderInfo s = t;
                    System.out.println("失败"+t);
                    List<Map<String,String>> lists = AddressResolutionUtil.addressResolution(s.getAddress());
                    System.out.println(s);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
