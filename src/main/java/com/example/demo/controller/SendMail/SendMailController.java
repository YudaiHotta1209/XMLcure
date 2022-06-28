package com.example.demo.controller.SendMail;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ContactForm.ContactForm;



@RestController
public class SendMailController {
    @Autowired
    private MailSender mailSender;

    @RequestMapping(value="/sendmail", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> sendmail(@RequestBody ContactForm form) {
        String body = "お名前: " + form.getName() + "\n" + 
                "メールアドレス: " + form.getEmail() + "\n" + 
                "メッセージ: \n" + form.getMessage();
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(form.getEmail());
        msg.setTo("xxx@gmail.com"); // 適宜変更してください
        msg.setSubject("お問い合わせがありました");
        msg.setText("お問い合わせは下記の通りです。\n\n---------------------------\n" + body + "\n---------------------------");
        mailSender.send(msg);
		return Arrays.asList("OK");
	}
}