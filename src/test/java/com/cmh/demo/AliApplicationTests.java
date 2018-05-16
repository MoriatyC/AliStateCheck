package com.cmh.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
*@author: Menghui Chen
*@version: 2018年5月16日下午2:33:39
**/

@RunWith(SpringRunner.class)
@SpringBootTest
public class AliApplicationTests {
    @Autowired
    private JavaMailSender mailSender;
//    @Test
//    public void test() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        
//        message.setFrom("chenmenghui1991@163.com");//发送者.
//        message.setTo("119889525@qq.com");//接收者.
//        message.setSubject("测试邮件（邮件主题）");//邮件主题.
//        message.setText("这是邮件内容");//邮件内容.
//       
//        mailSender.send(message);//发送邮件
//    }
    @Test
    public void testLog() {
        Logger loger = LoggerFactory.getLogger(AliApplicationTests.class);
        loger.info("1111111111111111111111111111111111");
        System.out.println(123);
    }
}
