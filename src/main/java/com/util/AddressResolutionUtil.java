package com.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressResolutionUtil {

    /**
     * 解析地址
     * @author lin
     * @param address
     * @return
     */
    public static List<Map<String,String>> addressResolution(String address) {
        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<String, String>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            town = m.group("town");
            row.put("town", town == null ? "" : town.trim());
            village = m.group("village");
            row.put("village", village == null ? "" : village.trim());
            table.add(row);
        }
        return table;
    }

    //地址转换
    public static String proinceZh(String str){
        List<String> list = new ArrayList<String>();
        list.add("北京");
        list.add("天津");
        list.add("上海");
        list.add("重庆");
        list.add("河北");
        list.add("河南");
        list.add("云南");
        list.add("辽宁");
        list.add("黑龙江");
        list.add("湖南");
        list.add("安徽");
        list.add("山东");
        list.add("新疆");
        list.add("江苏");
        list.add("浙江");
        list.add("江西");
        list.add("湖北");
        list.add("广西");
        list.add("甘肃");
        list.add("山西");
        list.add("内蒙古");
        list.add("陕西");
        list.add("吉林");
        list.add("福建");
        list.add("贵州");
        list.add("广东");
        list.add("青海");
        list.add("西藏");
        list.add("四川");
        list.add("宁夏");
        list.add("海南");
        list.add("台湾");
        list.add("香港");
        list.add("澳门");
        for (int i=0;i<list.size();i++){
            if(str.indexOf(list.get(i))!=-1){
                return list.get(i);
            }
        }
        if(str.indexOf("省")>0|str.indexOf("市")>0){
            return str.substring(0,str.length()-1);
        }else if(str.indexOf("区")>0){
            return str.substring(0,str.length()-3);
        }
        return str;
    }

}
