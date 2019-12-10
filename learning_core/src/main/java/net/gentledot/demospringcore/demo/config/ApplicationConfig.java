package net.gentledot.demospringcore.demo.config;

import net.gentledot.demospringcore.demo.DemoApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {

//    @Bean
//    public BookRepository bookRepository() {
//        return new BookRepository();
//    }
//
//    @Bean
//    public BookService bookService() {
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository());
//    }

}
