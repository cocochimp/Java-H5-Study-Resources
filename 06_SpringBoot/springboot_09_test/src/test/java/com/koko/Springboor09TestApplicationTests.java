package com.koko;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboor09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        //邮件设置1：一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("1、简单的邮件");
        message.setText("helloworld");

        message.setTo("2427886409@qq.com");
        message.setFrom("2427886409@qq.com");
        mailSender.send(message);
    }

    @Test
    public void contextLoads2() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("2、复杂的邮件");
        helper.setText("<b style='color:red'>helloworld</b>",true);

        //发送附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\koko\\Desktop\\蜡笔小新.ico"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\koko\\Desktop\\蜡笔小新.ico"));

        helper.setTo("2427886409@qq.com");
        helper.setFrom("2427886409@qq.com");

        mailSender.send(mimeMessage);
    }

}
