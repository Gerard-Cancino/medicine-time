// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN =
            "your_auth_token";
    public static final String twilioNumber = "+12018014445";
    public static String text(String numberTexted, String sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+" + numberTexted), // to
                        new PhoneNumber(twilioNumber), // from
                        sms)
                .create();

        return(message.getSid());
    }
}