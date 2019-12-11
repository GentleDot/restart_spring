package net.gentledot.demospringcore.demo;

import net.gentledot.demospringcore.out.OutsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    OutsiderService outsiderService;

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        SpringApplication thisApp = new SpringApplication(DemoApplication.class);

        // Ramda 변환 전 코드
        /*
        thisApp.addInitializers(new ApplicationContextInitializer<GenericApplicationContext>() {
            @Override
            public void initialize(GenericApplicationContext appCtx) {
                // 패키지 밖 범위의 서비스를 Bean에 등록
                appCtx.registerBean(OutsiderService.class);
            }
        });
        */
        /*
        appCtx.registerBean(ApplicationRunner.class, new Supplier<ApplicationRunner>() {
            @Override
            public ApplicationRunner get() {
                return args1 -> {
                    System.out.println("======");
                    System.out.println("Functional Bean Definition!!");
                    System.out.println("======");
                };
            }
        });
        */

        // ConfigurableApplicationContext -> GenericApplicationContext
        thisApp.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) appCtx -> {
            // 패키지 밖 범위의 서비스를 Bean에 등록
            appCtx.registerBean(OutsiderService.class);
            appCtx.registerBean(ApplicationRunner.class, () -> args1 -> {
                System.out.println("======");
                System.out.println("Functional Bean Definition!!");
                System.out.println("======");
            });
        });
        thisApp.run(args);
    }

//    @Bean
//    public OutsiderService outsiderService() {
//        System.out.println("======");
//        System.out.println("Functional Bean Definition!!");
//        System.out.println("======");
//        return new OutsiderService();
//    }

}
