package com.cmh.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
*@author: Menghui Chen
*@version: 2018年5月16日上午11:31:44
**/
@Service
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private EmailService emailService;
    @Scheduled(cron = "0 40/2 * * * ?")
    public void checkWebSite() {
        log.info("查看状态.....{}", dateFormat.format(new Date()));
        String state = stateCheck();
        if (!state.equals("面试中")) {
            emailService.mainSender(state);
        }
    }

    public String stateCheck() {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://campus.alibaba.com/myJobApply.htm/";
        HttpGet request = new HttpGet(url);
        request.addHeader("cookie", "你的cookie");
        CloseableHttpResponse response = null;
        String html = null;
        try {
            response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                html = EntityUtils.toString(entity, "UTF-8");
                Document doc = Jsoup.parse(html);
                Elements content = doc.getElementsByClass("state-name");
                return content.get(0).text();
            }
           
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
