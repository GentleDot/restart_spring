package net.gentledot.demospringcore.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    MessageSource messageSource;

    @Autowired(required = false)
    BookRepository bookRepository;

    @Value("${app.about}")
    String appAbout;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(environment.getProperty("app.about"));
        System.out.println(appAbout);
        System.out.println("====== 인삿말 ======");
        System.out.println(Locale.getDefault());
        System.out.println(messageSource.getClass());
        System.out.println(messageSource.getMessage("greeting", new String[]{"Spring"}, Locale.KOREA));
        System.out.println(messageSource.getMessage("greeting", new String[]{"HTML"}, Locale.US));
    }
}
