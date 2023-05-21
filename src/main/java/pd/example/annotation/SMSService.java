package pd.example.annotation;

import org.springframework.stereotype.Component;

@Component("smsService") // we can explicitly give a name ...
public class SMSService {
    public void sendMessage(String receiver, String message){
        System.out.println(message + " is sent to "+ receiver + " by SMS.");
    }
}
