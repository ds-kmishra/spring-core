package pd.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pd.example.service.EmailService;

@Configuration
public class AppConfig {
    @Bean
    public EmailService emailService(){
        return new EmailService();
    }
}
