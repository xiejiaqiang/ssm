package com.config.util;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.beans.SimpleBeanInfo;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleBeanFieldConverter extends AbstractBeanField<SimpleBeanInfo> {
    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Field f = getField();
        if("date".equals(f.getName())){
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if("number".equals(f.getName())){
            return new Integer(value);
        }
        return null;
    }
}
