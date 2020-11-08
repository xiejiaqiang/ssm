package com.constant;

import java.util.HashMap;
import java.util.Map;

public class ProvinceMaping {
    private static final Map<String,String> jvectormapCn = new HashMap<String, String>(){
        {
            put("江苏","CN-32");
            put("贵州","CN-52");
            put("云南","CN-53");
            put("重庆","CN-50");
            put("四川","CN-51");
            put("上海","CN-31");
            put("西藏","CN-54");
            put("浙江","CN-33");
            put("内蒙古","CN-15");
            put("山西","CN-14");
            put("福建","CN-47");
            put("天津","CN-12");
            put("河北","CN-13");
            put("北京","CN-11");
            put("安徽","CN-34");
            put("江西","CN-36");
            put("山东","CN-37");
            put("河南","CN-41");
            put("湖南","CN-43");
            put("湖北","CN-42");
            put("广西","CN-45");
            put("广东","CN-44");
            put("新疆","CN-46");
            put("宁夏","CN-64");
            put("青海","CN-63");
            put("甘肃","CN-62");
            put("陕西","CN-61");
            put("黑龙江","CN-23");
            put("吉林","CN-22");
            put("辽宁","CN-21");
            put("台湾","CN-48");
            put("钓鱼岛","CN-49");
        }
    };
    //根据省份获取JvectormapCn CODE
    public static String getJvectormapCn(String province){
        return jvectormapCn.get(province);
    };

}
