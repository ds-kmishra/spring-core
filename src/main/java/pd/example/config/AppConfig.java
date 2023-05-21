package pd.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pd.example.service.EmailService;

@Configuration
@ComponentScan({"pd.example"}) /// under the packages and its subpackages we have some component based annotations
// for those classes we want spring to manage the beans for us.
public class AppConfig {
    /*@Bean
    public EmailService emailService(){
        return new EmailService();
    }*/

}
