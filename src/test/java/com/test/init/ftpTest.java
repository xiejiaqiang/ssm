package com.test.init;

import com.util.FtpUtils;
import org.testng.annotations.Test;

public class ftpTest  extends BaseTest {
    @Test
    public void test(){
        FtpUtils ftp = new FtpUtils();
        //ftp.uploadFile("ftpFile/data", "123.docx", "E://123.docx");
        //ftp.downloadFile("ftpFile/data", "123.docx", "F://");
        ftp.uploadFile("/img", "123.docx", "D:/ssm.war");
        System.out.println("ok");
    }
}
