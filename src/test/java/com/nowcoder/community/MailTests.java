package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)

public class MailTests {


    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;


    @Test
    public void testMail() {
        mailClient.sendMail("1768982986@qq.com","Test","hello");

    }

    @Test
    public void testHTMLMail(){
        Context context = new Context();
        context.setVariable("username", "zhangsan");

        String content = templateEngine.process("/mail/demo", context);

        System.out.println(content);
        mailClient.sendMail("1768982986@qq.com","Test",content);

    }
}
