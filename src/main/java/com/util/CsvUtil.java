package com.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class CsvUtil {
    /**
     * 日志对象
     */
    static Logger LOGGER = LoggerFactory.getLogger(CsvUtil.class);

    /**
     * 解析csv文件并转成bean
     * @param file csv文件
     * @param clazz 类
     * @param <T> 泛型
     * @return 泛型bean集合
     */
    public <T> List<T> getCsvData(MultipartFile file, Class<T> clazz,String charsetName) throws Exception{
        InputStreamReader in;
        try {
            in = new InputStreamReader(file.getInputStream(), charsetName);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw  new Exception(e);
        }
        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy();
        strategy.setType(clazz);

        List<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withType(clazz)
                .withSeparator(',')
                .withSkipLines(1)
//					.withMappingStrategy(strategy) //
                .build()
                .parse();
        return csvToBean;
    }
}
