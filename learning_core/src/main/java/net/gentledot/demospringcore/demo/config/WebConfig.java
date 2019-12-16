package net.gentledot.demospringcore.demo.config;

import net.gentledot.demospringcore.demo.Conversion.EventConverter;
import net.gentledot.demospringcore.demo.Conversion.EventFommter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new EventConverter.StringToEventConverter());
        registry.addFormatter(new EventFommter());
    }
}
