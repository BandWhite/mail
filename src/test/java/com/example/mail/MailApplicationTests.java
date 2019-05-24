package com.example.mail;

import com.example.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.util.Locale;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSimpleMail(){
        mailService.sendSimpleMail("18261196912@163.com","test simple mail","hello mail");
    }

    @Test
    public void testMimeMail(){
        String content="<html><body><h3>hello world ! 这是一封Html邮件!</h3></body></html>";
        mailService.sendHtmlMail("18261196912@163.com","test simple mail",content);

    }

    @Test
    public void testAttachmentMail(){
        mailService.sendAttachmentsMail("18261196912@163.com","test simple mail","attachment mail", "111.txt");
    }

    @Test
    public void testResourcesMail(){
        String rscId = "p1";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "p1.png";

        mailService.sendInlineResourceMai("18261196912@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


}
