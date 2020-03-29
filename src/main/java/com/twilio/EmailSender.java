package com.twilio;//still need to import send grid

//https://app.sendgrid.com/guide/integrate/langs/java

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;

import java.io.IOException;

public class EmailSender {

  private static final SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
  private static final String emailFrom = "test@example.com";

  public static void sendMail(String emailTo, String message) throws IOException {
    Email from = new Email(emailFrom);
    String subject = "Reminder to take your medicine";
    Email to = new Email(emailTo);
    Content content = new Content("text/plain", message);
    Mail mail = new Mail(from, subject, to, content);


    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}