package net.gentledot.demospringcore.demo.book;

import net.gentledot.demospringcore.demo.config.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    ResourceLoader resourceLoader;

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
        System.out.println("====== event Publishing ======");
        eventPublisher.publishEvent(new MyEvent(this, 100));
        System.out.println("====== Resource ======");
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resource.exists());
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        // readString 은 java 11 버전
        System.out.println(Files.readString(Path.of(resource.getURI())));
    }
}
