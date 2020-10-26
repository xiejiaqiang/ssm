package com.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtils {
    public static <T> void exportExcel(String title, String[] headers, Collection<T> dataset, HttpServletResponse response, String pattern){
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        sheet.setDefaultColumnWidth((short)15);
        // 生成一个样式
        HSSFCellStyle style= workbook. createCellStyle();
        //设置这些样式
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.SKY_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        //生成一个字体
        HSSFFont font= workbook.createFont();
        font.setColor(HSSFColor.HSSFColorPredefined.VIOLET.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        // 设置填充模式，模式为全部前景色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
       /* // 设置前景色为绿色
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREEN.getColor().getIndex());
        // 设置背景色，如果填充模式为其它填充模式，这个前景和背景色将相互交映显示
        style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.RED.getColor().getIndex());*/
        //把字体应用到当前的样式
        style.setFont(font);
        //生成并设置另一个样式
        HSSFCellStyle style2= workbook. createCellStyle();
        //设置这些样式
        style2.setFillForegroundColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setBorderRight(BorderStyle.THIN);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setVerticalAlignment(VerticalAlignment.forInt(1));
        //生成另外一个字体
        HSSFFont font2= workbook.createFont();
        font.setBold(true);
        //把字体应用到当前的样式
        style2.setFont(font2);
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        /*// 定义注释的大小和位置
        HSSFComment comment = patriarch.createComment(new HSSFChildAnchor(0,0,0,0));
        //设置注释内容
        comment.setString(new HSSFRichTextString("注释"));
        comment.setAuthor("佳一电子");*/
        //产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i=0;i< headers.length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //遍历集合 产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()){
            index ++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            //反射 根据javabean先后顺序 动态调用get方法得到值
            Field[] fields = t.getClass().getDeclaredFields();
            short sellnum = 0;
            for (short i=0;i<fields.length;i++){
                HSSFCell cell = row.createCell(sellnum);
                sellnum ++;
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String  getMethodName = "get" + fieldName.substring(0,1).toUpperCase() +fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    String textValue = null;
                    if (value ==null || "".equals(value)){
                        textValue = null;
                    }else if (value instanceof Date){
                        Date date = (Date)value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    }else if (value instanceof  byte[]){
                        row.setHeightInPoints(60);
                        sheet.setColumnWidth(i,35*80);
                        byte[] bsValue = (byte[])value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0,0,1023,255,(short) 6,index,(short)6, index);
                        anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                        textValue = String.valueOf(value);
                    }
                    if (textValue !=null){
                        cell.setCellValue(textValue);
                    }
                } catch (Exception e){
                }
            }

        }
    try {
        OutputStream out = null;
        out = response.getOutputStream();
        response.reset();
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(title,"UTF-8"));
        response.setCharacterEncoding("UTF-8");
        //让服务器告诉浏览器它发送的数据属于什么文件类型
        response.setHeader("content-Type", "application/vnd.ms-excel");
        //当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(title, "UTF-8"));
        workbook.write(out);
        workbook.close();
    }catch (IOException e) {
    }

    }
}
