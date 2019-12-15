package net.gentledot.demospringcore.demo.config;

import net.gentledot.demospringcore.demo.DemoApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {

    @Bean
    public MessageSource messageSource() {
         ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
         // message property 파일의 위치와 이름 지정
         source.setBasename("classpath:/messages");
         // 기본 인코딩을 지정
         source.setDefaultEncoding("UTF-8");
         // property 파일의 변경을 감지할 시간 간격을 지정 (초 단위)
         source.setCacheSeconds(10);
         // 없는 메시지는 예외 발생하는 대신 코드를 기본 메시지로 함.
         source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}
