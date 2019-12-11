package net.gentledot.demospringcore.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service

public class BookService {
/*
    // @Repository 로 등록하지 않은 BookRepository 를 의존성 주입 (DI) 할 때

    // 1. 생성자 주입 방식
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 실행 결과 : 에러 발생.

//    Description:
//    Parameter 0 of constructor in net.gentledot.demospringcore.demo.book.BookService required a bean of type 'net.gentledot.demospringcore.demo.book.BookRepository' that could not be found.
//
//    Action:
//    Consider defining a bean of type 'net.gentledot.demospringcore.demo.book.BookRepository' in your configuration.
*/

/*
    // 2. Setter 주입 방식
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 실행 결과 : 에러 발생.

//    Description:
//    Parameter 0 of constructor in net.gentledot.demospringcore.demo.book.BookService required a bean of type 'net.gentledot.demospringcore.demo.book.BookRepository' that could not be found.
//
//    Action:
//    Consider defining a bean of type 'net.gentledot.demospringcore.demo.book.BookRepository' in your configuration.


    // 2-1. Setter 주입 방식, @Autowired (required = false)
    private BookRepository bookRepository;

    @Autowired (required = false)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 실행 결과 : 실행 성공
    // @Service 인스턴스는 생성됨. 하지만 BookRepository 의존성은 주입되지 않았음.
*/

/*
    // 3. 필드 주입 방식
    @Autowired
    private BookRepository bookRepository;

    // 실행 결과 : 에러 발생.

//    Description:
//    Parameter 0 of constructor in net.gentledot.demospringcore.demo.book.BookService required a bean of type 'net.gentledot.demospringcore.demo.book.BookRepository' that could not be found.
//
//    Action:
//    Consider defining a bean of type 'net.gentledot.demospringcore.demo.book.BookRepository' in your configuration.

    // 3-1. 필드 주입 방식, @Autowired (required = false)
    @Autowired(required = false)
    private BookRepository bookRepository;

    // 실행 결과 : 실행 성공
    // @Service 인스턴스는 생성됨. 하지만 BookRepository 의존성은 주입되지 않았음.

*/

/*
    // @Repository 로 BookRepository interface를 구현한 MyBookRepository, AnotherBookRepository 를 의존성 주입 (DI) 할 때
    // 1. BookRepository 의존성 주입 시

    @Autowired
    BookRepository bookRepository;

    // 처리 결과 : 에러 발생
//    Description:
//    Field bookRepository in net.gentledot.demospringcore.demo.book.BookService required a single bean, but 2 were found:
//            - anotherBookRepository: defined in file [C:\workspace\study\restart_spring\learning_core\build\classes\java\main\net\gentledot\demospringcore\demo\book\AnotherBookRepository.class]
//            - myBookRepository: defined in file [C:\workspace\study\restart_spring\learning_core\build\classes\java\main\net\gentledot\demospringcore\demo\book\MyBookRepository.class]
//
//    Action:
//    Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

*/

/*
    @Autowired
    private  BookRepository bookRepository;

    public void printBookRepository() {
        System.out.println("========");
        System.out.println("출력결과 : ");
        System.out.println(bookRepository.getClass());
        System.out.println("========");
    }
*/

/*
    @Autowired
    private List<BookRepository> bookRepositories;

    public void printBookRepository() {
        System.out.println("========");
        System.out.println("출력결과 : ");
        this.bookRepositories.forEach(System.out::println);
        System.out.println("========");
    }
*/

/*
    @Autowired
    private  BookRepository myBookRepository;

    public void printBookRepository() {
        System.out.println("========");
        System.out.println("출력결과 : ");
        System.out.println(myBookRepository.getClass());
        System.out.println("========");
    }
*/


    // org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor 가 Bean을 찾아 주입시켜준다.
    // PostProcessBeforeInitialization 단계에서...
    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void printBookRepository() {
        System.out.println("========");
        System.out.println("출력결과 : ");
        System.out.println(bookRepository.getClass());
        System.out.println("========");
    }

}
