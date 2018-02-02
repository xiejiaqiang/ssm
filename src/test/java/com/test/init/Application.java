package com.test.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
        System.out.println("****************** Begin Start Service ******************");
        
        String[] configFiles = new String[]{"classpath*:applicationContext.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configFiles);

        System.out.println("****************** Start Service Complete ******************");
        
        context.start();      

		System.out.println("=========================================");
		System.out.println("应用服务启动.................");
		System.out.println("");
		System.out.println("退出服务按任意键：");
		System.out.println("=========================================");

        System.in.read();
    }

}
