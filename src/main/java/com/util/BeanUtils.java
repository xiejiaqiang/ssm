package com.util;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

//import java.util.HashMap;

public class BeanUtils {


    public static  void copyBean(Object fromObj, Object toObj)
    {
        BeanCopier beanCopier = BeanCopier.create(fromObj.getClass(), toObj.getClass(), false);
        beanCopier.copy(fromObj, toObj, null);
        beanCopier = null;
    }

    public static void copyBeanNotNull(Object fromObj, Object toObj)
    {
        HashMap<String, Object> notNullMap = new HashMap<String, Object>(16);
        copyBean2MapNotNull(fromObj, notNullMap);
        copyMap2Bean(notNullMap, toObj);
        notNullMap = null;
    }

    /**
     * 建议方法内最好不用静态变量
     *
     * @param fromObj
     * @param toObj
     * @author Jonson Hu
     */
    public static void copyBean2Map(Object fromObj, HashMap<String, Object> toObj)
    {
        BeanMap beanMap = BeanMap.create(fromObj);

        @SuppressWarnings("rawtypes")
        Set keySet = beanMap.keySet();

        for (Object key : keySet)
        {
            toObj.put(key.toString(), beanMap.get(key));
        }
        keySet = null;
        beanMap = null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void copyBean2MapNotNull(Object fromObj, HashMap toObj)
    {
        BeanMap beanMap = BeanMap.create(fromObj);
        Set<String> keySet = beanMap.keySet();

        Object value = null;
        for (Object key : keySet)
        {
            value = beanMap.get(key);
            if (value != null) {
                toObj.put(key.toString(), value);
            }
        }
        keySet = null;
        beanMap = null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void copyBean2MapNull2ZeroString(Object fromObj, HashMap toObj)
    {
        BeanMap beanMap = BeanMap.create(fromObj);
        Set<String> keySet = beanMap.keySet();

        Object value = null;
        for (Object key : keySet)
        {
            value = beanMap.get(key);
            if (value == null) {
                value = "";
            }
            toObj.put(key.toString(), value);
        }
        keySet = null;
        beanMap = null;
    }

    @SuppressWarnings("rawtypes")
    public static void copyMap2Bean(HashMap fromObj, Object toObj)
    {
        BeanMap beanMap = BeanMap.create(toObj);
        beanMap.putAll(fromObj);
        beanMap = null;
    }

    @SuppressWarnings("rawtypes")
    public static void copyMap2BeanNotNull(HashMap fromObj, Object toObj)
    {
        BeanMap beanMap = BeanMap.create(toObj);
        HashMap<String, Object> srcMap = new HashMap<String, Object>(16);

        Set keySet = fromObj.keySet();
        Object value = null;
        for (Object key : keySet)
        {
            value = fromObj.get(key);
            if (value != null)
            {
                srcMap.put((String) key, value);
            }
        }

        beanMap.putAll(srcMap);
        keySet = null;
        beanMap = null;
    }

    @SuppressWarnings("rawtypes")
    public static void copyMap2Bean(HashMap fromObj, Object toObj, boolean isConvert)
    {
        if (isConvert == false)
        {
            copyMap2Bean(fromObj, toObj);
        }
        else
        {
            HashMap<String, Object> tempMap = new HashMap<String, Object>(16);
            HashMap<String, String> beanFieldType = reflectBeanFieldType(toObj.getClass());

            Set keySet = fromObj.keySet();
            Object rawValue;
            Object targetValue;
            for (Object key : keySet)
            {
                rawValue = fromObj.get(key);
                if (rawValue != null)
                {
                    targetValue = convert(rawValue, beanFieldType.get(key));
                    if (targetValue != null) {
                        tempMap.put(key.toString(), targetValue);
                    }
                }
            }
            BeanMap beanMap = BeanMap.create(toObj);
            beanMap.putAll(tempMap);
            keySet = null;
            beanMap = null;
        }
    }

    private static HashMap<String, String> reflectBeanFieldType(Class<? extends Object> clazz)
    {
        HashMap<String, String> fieldTypeMap = new HashMap<String, String>(16);

        Field[] fieldList = clazz.getDeclaredFields();

        String fieldName;
        String fieldType;

        for (Field field : fieldList)
        {
            fieldName = field.getName();
            fieldType = field.getType().toString();
            fieldTypeMap.put(fieldName, fieldType);

        }

        return fieldTypeMap;
    }

    private static Object convert(Object rawValue, String fieldType) {
        Object returnValue = null;

        if (rawValue != null && fieldType != null) {
            if (StringUtils.contains(fieldType, "Date")) {
                // returnValue = CalendarUtil.stringToDate(rawValue.toString());
                returnValue = rawValue.toString();

            } else if (StringUtils.contains(fieldType, "BigDecimal")) {
                returnValue = new BigDecimal(rawValue.toString());
            } else if (StringUtils.contains(fieldType, "Long")) {
                returnValue = new Long(rawValue.toString());
            } else if (StringUtils.contains(fieldType, "Integer")) {
                returnValue = new Integer(rawValue.toString());
            } else if (StringUtils.contains(fieldType, "Timestamp")) {
                returnValue = rawValue;
            } else {
                returnValue = rawValue.toString();
            }
        }

        return returnValue;
    }
}
