package com.cmh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
*@author: Menghui Chen
*@version: 2018年5月16日上午11:18:35
**/
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    
    public void mainSender(String state) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chenmenghui1991@163.com");
        message.setTo("chenmenghui1994@163.com");
        message.setSubject(state);
        message.setText("等了这么久看看结果吧");
        mailSender.send(message);
        System.out.println("已发送邮件======");
    }
}
