package net.gentledot.demospringcore.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class BookServiceRunner implements ApplicationRunner {

    @Autowired
    BookService bookService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = applicationContext.getBean(AutowiredAnnotationBeanPostProcessor.class);
        System.out.println(beanPostProcessor);
    }

//     1.
//     @Repository @Primary
//     public class MyBookRepository

//    ========
//    출력결과 :
//    class net.gentledot.demospringcore.demo.book.MyBookRepository
//    ========

//    2.
//    @Repository(value = "myBook")
//    public class MyBookRepository
//    이고
//    @Autowired @Qualifier(value = "myBook")
//    private BookRepository bookRepository;
//    *** 만약 @Repository 에 따로 value가 없다면 myBookRepository 가 기본 Bean 명칭이 된다.

//    3.
//    @Autowired
//    private List<BookRepository> bookRepositories;
//
//    public void printBookRepository() {
//        System.out.println("========");
//        System.out.println("출력결과 : ");
//        this.bookRepositories.forEach(System.out::println);
//        System.out.println("========");
//    }

//    ========
//    출력결과 :
//    net.gentledot.demospringcore.demo.book.AnotherBookRepository@7832dcfd
//    net.gentledot.demospringcore.demo.book.MyBookRepository@496224d0
//    ========

//    4.
//    @Autowired
//    private  BookRepository myBookRepository;
//
//    public void printBookRepository() {
//        System.out.println("========");
//        System.out.println("출력결과 : ");
//        System.out.println(myBookRepository.getClass());
//        System.out.println("========");
//    }
}
