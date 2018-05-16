package com.cmh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cmh.service.EmailService;

@SpringBootApplication
@EnableScheduling
public class AliApplication {
//    implements CommandLineRunner
    @Autowired
    private EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(AliApplication.class, args);
	}
//	@Override
//	public void run(String... args) {
//	    emailService.mainSender("待跟进offer");
//	}
}
