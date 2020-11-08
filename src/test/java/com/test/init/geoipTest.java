package com.test.init;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class geoipTest {
    public static void main(String[] args) throws IOException{
        // 创建 GeoLite2 数据库
        File database = new File("\\GeoLite2-City.mmdb");
        // 读取数据库内容
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        InetAddress ipAddress = InetAddress.getByName("171.108.233.157");

        // 获取查询结果
        CityResponse response = null;
        try {
            try {
                response = reader.city(ipAddress);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 获取国家信息
            Country country = response.getCountry();
            System.out.println(country.getIsoCode());               // 'CN'
            System.out.println(country.getName());                  // 'China'
            System.out.println(country.getNames().get("zh-CN"));    // '中国'

            // 获取省份
            Subdivision subdivision = response.getMostSpecificSubdivision();
            System.out.println(subdivision.getName());   // 'Guangxi Zhuangzu Zizhiqu'
            System.out.println(subdivision.getIsoCode()); // '45'
            System.out.println(subdivision.getNames().get("zh-CN")); // '广西壮族自治区'

            // 获取城市
            City city = response.getCity();
            System.out.println(city.getName()); // 'Nanning'
            Postal postal = response.getPostal();
            System.out.println(postal.getCode()); // 'null'
            System.out.println(city.getNames().get("zh-CN")); // '南宁'
            Location location = response.getLocation();
            System.out.println(location.getLatitude());  // 22.8167
            System.out.println(location.getLongitude()); // 108.3167
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }


    }
}
