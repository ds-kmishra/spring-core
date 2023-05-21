package pd.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import pd.example.annotation.SMSService;
import pd.example.config.AppConfig;
import pd.example.service.EmailService;

public class App 
{
    public static void main( String[] args )
    {
        // --- WITHOUT IOC ---
        //EmailService emailService = new EmailService();

        // --- WITH IOC ---
        // 1 . With Bean Factory -->

        // Here we need to get the bean factory to provide the bean
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        // --- Here we need to downcast ---
        //EmailService emailService1 = (EmailService) beanFactory.getBean("emailService");
        // --- Here we don't ---
        //EmailService emailService1 = beanFactory.getBean("emailService", EmailService.class);
        //emailService1.sendEmail("test@gmail.com", "Hello from Miss Xing!");


        // 2. With ClassPathXmlApplicationContext Implementation
        // ClassPathXmlApplicationContext return Application Context
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
        //EmailService emailService = beanFactory.getBean("emailService", EmailService.class);


        // 3. By using ApplicationContext -> ApplicationContext extends BeanFactory so it has all the features
        // of BeanFactory - More Recommended
        // It is necessary to have the xml - spring.xml file under the project
        // We can use new FileSystemXmlApplicationContext() - mention the file path, not necessary to be in the  project folder

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //EmailService emailService = context.getBean("emailService", EmailService.class);

        // 4. With the help of Annotation Config Application Context - Skipping the XML
        // I- Create a package called config
        // II- and a AppConfig Class having annotation

        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService emailService = applicationContext.getBean("emailService", EmailService.class);
        emailService.sendEmail("test@gmail.com", "Hello from Miss Xing!");
        System.out.println(emailService);*/

        // -- For AppConfig.class
        // ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // -- For spring-annotations.xml - component scan
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        SMSService emailService = context.getBean("smsService", SMSService.class);
        emailService.sendMessage("Tina@gmail.com", "Hi...");

    }
}


