package com.util;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:通用copy工具 </p>
 * <p>Description:  </p>
 * <p>Copyright:  Copyright (c) 2017</p>
 * <p>Company:  </p>
 * @author:
 * @version 1.0
 */
public class CopyUtils {
    private  final static Logger LOGGER = LoggerFactory.getLogger(CopyUtils.class.getName());

    /**
     * 属性复制
     * @param fromObj 属性来源类
     * @param toObj 属性目标类
     */
    public  static void copyBean(Object fromObj, Object toObj){
        if(fromObj == null || toObj == null){
            return;
        }
        try {
            BeanUtils.copyBean(fromObj,toObj);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * bean转换成hashMap,key为属性名，value为属性值
     * @param fromObj
     * @param toObj
     */
    public  static void copyBean2Map(Object fromObj, HashMap<String,Object> toObj){
        if(fromObj == null || toObj == null){
            return;
        }
        BeanUtils.copyBean2Map(fromObj,toObj);
    }

    /**
     * hashMap转换成bean
     * @param fromObj
     * @param toObj
     */
    public  static void  copyMap2Bean(HashMap fromObj, Object toObj){
        if(fromObj == null || toObj == null){
            return;
        }
        BeanUtils.copyMap2Bean(fromObj,toObj);
    }

    /**
     * 将实体列表转换成hashMap数组，批量操作时使用
     * @param beans
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object>[] copyBeanList2Maps(List<T> beans){
        if(beans == null || beans.size() == 0){
            return  null;
        }
        HashMap<String,Object>[] maps = new HashMap[beans.size()];
        for (int i =0; i<beans.size(); i++){
            maps[i] = new HashMap<String, Object>(16);
            copyBean2Map(beans.get(i),maps[i]);
        }
        return  maps;
    }

    /**
     * copy list对象
     * @param fromObjList
     * @param toObjClass
     * @param <T>
     * @return
     */
    public  static  <T> List<T> copyList(List<?> fromObjList, Class<T> toObjClass){
        if(fromObjList == null || fromObjList.size() == 0){
            return null;
        }
        List<T> toObjList = new ArrayList<T>(fromObjList.size());
        for(int i=0; i< fromObjList.size(); i++){
            T toObj = null;
            try {
                toObj = toObjClass.newInstance();
                copyBean(fromObjList.get(i),toObj);
                toObjList.add(toObj);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return toObjList;
    }

    /**
     *
     * @param pageInfo
     * @param toObjClass
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> copyPageInfoList(PageInfo pageInfo, Class<T> toObjClass){
        List<T> list = copyList(pageInfo.getList(),toObjClass);
        pageInfo.setList(list);
        return pageInfo;
    }

}
