package com.util;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * <b>
 * </b><br><br><i>Description</i> :
 * <br> Author : dxl
 * <br> Date : 2019/1/9 11:08
 */
public class DxlFileUtil {
    static Logger LOGGER = LoggerFactory.getLogger(DxlFileUtil.class);
    private static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    /**
     * 单个文件上传
     * @param
     * @param fileName
     * @param filePath
     */
    public static void upFile(File uploadFile,String fileName,String filePath){

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        FileInputStream is = null;
        BufferedInputStream bis = null;
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        File f = new File(filePath+"/"+fileName);
        try {
            is = new FileInputStream(uploadFile);
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            byte[] bt = new byte[4096];
            int len;
            while((len = bis.read(bt))>0){
                bos.write(bt, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                if(null != bos){
                    bos.close();
                    bos = null;}
                if(null != fos){
                    fos.close();
                    fos= null;
                }
                if(null != is){
                    is.close();
                    is=null;
                }

                if (null != bis) {
                    bis.close();
                    bis = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 单个文件上传
     * @param is
     * @param fileName
     * @param filePath
     */
    public static void upFile(InputStream is,String fileName,String filePath){

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        File f = new File(filePath+"/"+fileName);
        try {
            Runtime.getRuntime().exec("chmod 777 "+filePath+"/"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            byte[] bt = new byte[4096];
            int len;
            while((len = bis.read(bt))>0){
                bos.write(bt, 0, len);
            }
        } catch (Exception e) {
          LOGGER.error("文件上传异常，异常信息[{}]",e);
        }finally {

            try {
                if(null != bos){
                    bos.close();
                    bos = null;}
                if(null != fos){
                    fos.close();
                    fos= null;
                }
                if(null != is){
                    is.close();
                    is=null;
                }

                if (null != bis) {
                    bis.close();
                    bis = null;
                }
            } catch (Exception e) {
                LOGGER.error("文件上传异常，异常信息[{}]",e);
            }
        }
    }

    /**
     * @param request
     * @param response
     * @param downloadFile 下载文件完整路径
     * @param fileName 下载文件名（带文件后缀）
     */
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFile, String fileName) {

        BufferedInputStream bis = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            File file=new File(downloadFile); //:文件的声明
            is = new FileInputStream(file);  //:文件流的声明
            os = response.getOutputStream(); // 重点突出
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);

            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
            } else {
                // 对文件名进行编码处理中文问题
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
                fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
            }

            response.reset(); // 重点突出
            response.setCharacterEncoding("UTF-8"); // 重点突出
            response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
            // inline在浏览器中直接显示，不提示用户下载
            // attachment弹出对话框，提示用户进行下载保存本地
            // 默认为inline方式
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            //  response.setHeader("Content-Disposition", "attachment; filename="+fileName); // 重点突出
            int bytesRead = 0;
            byte[] buffer = new byte[4096];// 4k或者8k
            while ((bytesRead = bis.read(buffer)) != -1){ //重点
                bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 特别重要
            // 1. 进行关闭是为了释放资源
            // 2. 进行关闭会自动执行flush方法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != bos) {
                    bos.close();
                    bos = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
                if (null != os) {
                    os.close();
                    os = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @param downloadFile 删除文件完整路径
     * @param fileName 文件名（带文件后缀）
     */
    public static boolean deleteFile(String downloadFile, String fileName) {
            File file=new File(downloadFile+"/"+fileName); //:文件的声明
            if (file.exists()) {
                file.delete();
                return  true;
            }else {
                return false;
            }
    }

    public static String downloadBase64Img(String pathname, String filename, String suffix){
        String result = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        try {
            File file=new File(pathname+"/"+filename); //:文件的声明
            is = new FileInputStream(file);  //:文件流的声明
            bis = new BufferedInputStream(is);
            result = convertImageStreamToByte(bis, suffix);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 特别重要
            // 1. 进行关闭是为了释放资源
            // 2. 进行关闭会自动执行flush方法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    };

    /**
     * 将图片流转换为BASE64加密字符串.
     * @param imageInputStream
     * @param format 图片格式.
     * @return
     */
    public static String convertImageStreamToByte(InputStream imageInputStream, String format) {
        BufferedImage bi = null;
        ByteArrayOutputStream baos = null;
        String result = null;
        try {
            bi = ImageIO.read(imageInputStream);
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, format == null ? "jpg" : format, baos);
            byte[] bytes = baos.toByteArray();
            result = encoder.encodeBuffer(bytes).trim();
            LOGGER.info("将图片流转换为BASE64加密字符串成功！");
        } catch (IOException e) {
            LOGGER.error("将图片流转换为 BASE64加密字符串失败: " + e);
        } finally {
            try {
                if(baos != null) {
                    baos.close();
                    baos = null;
                }
            } catch (Exception e) {
                LOGGER.error("关闭文件流发生异常: " + e);
            }
        }
        return result;
    }
    /**
     * 文件下载
     * @param response
     * @param downloadFile 文件的路径
     * @param showFileName 下载后显示的文件名称
     */
    public static void downloadFile(HttpServletResponse response, String downloadFile, String showFileName) {

        BufferedInputStream bis = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            File file=new File(downloadFile); //:文件的声明
            String fileName=file.getName();
            is = new FileInputStream(file);  //:文件流的声明
            os = response.getOutputStream(); // 重点突出
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            // 对文件名进行编码处理中文问题
            fileName = java.net.URLEncoder.encode(showFileName, "UTF-8");// 处理中文文件名的问题
            fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
            response.reset(); // 重点突出
            response.setCharacterEncoding("UTF-8"); // 重点突出
            response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
            // inline在浏览器中直接显示，不提示用户下载
            // attachment弹出对话框，提示用户进行下载保存本地
            // 默认为inline方式
            response.setHeader("Content-Disposition", "attachment; filename="+fileName); // 重点突出
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = bis.read(buffer)) != -1){ //重点
                bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        } finally {
            // 特别重要
            // 1. 进行关闭是为了释放资源
            // 2. 进行关闭会自动执行flush方法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != bos) {
                    bos.close();
                    bos = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
                if (null != os) {
                    os.close();
                    os = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

}