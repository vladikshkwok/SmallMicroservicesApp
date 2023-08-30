package ru.vladikshk.notification;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import ru.vladikshk.amqp.RabbitMQMessageProducer;

@SpringBootApplication(
        scanBasePackages = {
                "ru.vladikshk.notification",
                "ru.vladikshk.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "ru.vladikshk.clients"
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

}
