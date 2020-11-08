package com.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.util.Properties;

public class FtpUtils {
    //ftp服务器地址
    static Logger LOGGER = LoggerFactory.getLogger(FtpUtils.class);
    public String hostname;
    //ftp服务器端口号默认为21
    public Integer port;
    //ftp登录账号
    public String username;
    //ftp登录密码
    public String password;
    private static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    public FTPClient ftpClient = null;
    public FtpUtils(){
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream  bufferedReader = this.getClass().getResourceAsStream("/conf/config/ftp.properties");
            // 使用properties对象加载输入流
            try {
                properties.load(bufferedReader);
                //获取key对应的value值
                hostname = properties.getProperty("hostname");
                port = Integer.valueOf(properties.getProperty("port"));
                username = properties.getProperty("username");
                password = properties.getProperty("password");

            } catch (IOException e) {
                LOGGER.error("加载properties配置失败[{}]",e);
            }

    }
    /**
     * 初始化ftp服务器
     */
    public void initFtpClient() {
        ftpClient = new FTPClient();
        ftpClient.setBufferSize(32*1024*1024);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setControlEncoding("utf-8");
        try {
            LOGGER.info("connecting...ftp服务器:"+this.hostname+":"+this.port);
            ftpClient.connect(hostname, port); //连接ftp服务器
            ftpClient.login(username, password); //登录ftp服务器
            int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
            if(!FTPReply.isPositiveCompletion(replyCode)){
                LOGGER.info("connect failed...ftp服务器:"+this.hostname+":"+this.port);
            }
            LOGGER.info("connect successfu...ftp服务器:"+this.hostname+":"+this.port);
        }catch (MalformedURLException e) {
            LOGGER.error("连接ftp失败[{}]",e);
        }catch (IOException e) {
            LOGGER.error("连接ftp失败[{}]",e);
        }
    }

    /**
     * 上传文件
     * @param pathname ftp服务保存地址
     * @param fileName 上传到ftp的文件名
     *  @param originfilename 待上传文件的名称（绝对地址） *
     * @return
     */
    public boolean uploadFile( String pathname, String fileName,String originfilename){
        boolean flag = false;
        InputStream inputStream = null;
        try{
            LOGGER.info("开始上传文件");
            inputStream = new FileInputStream(new File(originfilename));
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathname);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            LOGGER.info("上传文件成功");
        }catch (Exception e) {
            LOGGER.error("上传文件失败[{}]",e);
        }finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    /**
     * 上传文件
     * @param pathname ftp服务保存地址
     * @param fileName 上传到ftp的文件名
     * @param inputStream 输入文件流
     * @return
     */
    public  boolean uploadFile(String pathname, String fileName, InputStream inputStream){
        boolean flag = false;
        try{
            LOGGER.info("开始上传文件");
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathname);
            boolean makeDirectory = ftpClient.makeDirectory(pathname);
            LOGGER.info("makeDirectory"+makeDirectory);
            boolean changeWorkingDirectory = ftpClient.changeWorkingDirectory(pathname);
            LOGGER.info("changeWorkingDirectory"+changeWorkingDirectory);
            BufferedInputStream in = new BufferedInputStream(inputStream);
            boolean storeFile = ftpClient.storeFile(pathname+"/"+fileName, in);
            LOGGER.info("storeFile"+storeFile);
            inputStream.close();
            in.close();
            ftpClient.logout();
            flag = true;
            LOGGER.info("上传文件成功");
        }catch (Exception e) {
            LOGGER.error("上传文件失败[{}]",e);
            e.printStackTrace();
        }finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    //改变目录路径
    public boolean changeWorkingDirectory(String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                LOGGER.info("进入文件夹" + directory + " 成功！");

            } else {
                LOGGER.info("进入文件夹" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public boolean CreateDirecroty(String remote) throws IOException {
        boolean success = true;
        String directory = remote + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        LOGGER.info("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //判断ftp服务器文件是否存在
    public boolean existFile(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }
    //创建目录
    public boolean makeDirectory(String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                LOGGER.info("创建文件夹" + dir + " 成功！");

            } else {
                LOGGER.info("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /** * 下载文件 *
     * @param pathname FTP服务器文件目录 *
     * @param filename 文件名称 *
     * @param localpath 下载后的文件路径 *
     * @return */
    public  boolean downloadFile(String pathname, String filename, String localpath){
        boolean flag = false;
        OutputStream os=null;
        try {
            LOGGER.info("开始下载文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for(FTPFile file : ftpFiles){
                if(filename.equalsIgnoreCase(file.getName())){
                    File localFile = new File(localpath + "/" + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            LOGGER.info("下载文件成功");
        } catch (Exception e) {
            LOGGER.error("下载文件失败[{}]",e);
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public  String downloadBase64Img(String pathname, String filename, String suffix){
        InputStream inputStream = null;
        String re=null;
        try {
            LOGGER.info("开始下载文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for(FTPFile file : ftpFiles){
                if(filename.equalsIgnoreCase(file.getName())){
                    byte[] bytes=file.getName().getBytes("iso-8859-1");
                    String fileName=new String(bytes,"utf-8");
                    inputStream = ftpClient.retrieveFileStream(fileName);
                }
            }
            if (inputStream != null) {
                re = convertImageStreamToByte(inputStream, suffix);
            }
            ftpClient.logout();
            LOGGER.info("下载文件成功");
        } catch (Exception e) {
            LOGGER.error("下载文件失败[{}]",e);
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return re;
    };

    /**
     * 将图片流转换为BASE64加密字符串.
     * @param imageInputStream
     * @param format 图片格式.
     * @return
     */
    public String convertImageStreamToByte(InputStream imageInputStream, String format) {
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
    /** * 删除文件 *
     * @param pathname FTP服务器保存目录 *
     * @param filename 要删除的文件名称 *
     * @return */
    public boolean deleteFile(String pathname, String filename){
        boolean flag = false;
        try {
            LOGGER.info("开始删除文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
            LOGGER.info("删除文件成功");
        } catch (Exception e) {
            LOGGER.error("删除文件失败");
        } finally {
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        FtpUtils ftp = new FtpUtils();
        //ftp.uploadFile("ftpFile/data", "123.docx", "E://123.docx");
        //ftp.downloadFile("ftpFile/data", "123.docx", "F://");
        ftp.deleteFile("ftpFile/data", "123.docx");
        LOGGER.info("ok");
    }
}
