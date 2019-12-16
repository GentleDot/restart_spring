package net.gentledot.demospringcore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
//         서버 기동 없이 실행
//        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
//        SpringApplication.run(DemoApplication.class, args);
    }
}
