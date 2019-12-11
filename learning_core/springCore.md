# Spring Framework Core

## 목차
- [참고 자료](#출처)
- [학습 목표](#목표)
- 학습 내용
    - [IoC Container](#IoC-Container)

## 출처
- 강좌
    1. [스프링 프레임워크 핵심 기술 / 백기선](https://www.inflearn.com/course/spring-framework_core)
- 문서
    1. [Spring Framework Documentation - Core](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#spring-core)
- 도서
    1. 스프링 4 입문 - 웹 애플리케이션의 기초부터 클라우드 네이티브 입문까지 / 하세가와 유이치, 오오노 와타루, 토키 코헤이 (옮긴이 : 권은철, 전민수, 펴낸이 : 김태현) - 한빛미디어 

## 목표
1. IoC(Inversion of Control), AOP(Aspect Oriented Programming), PSA(Portable Service Abstraction) 에 대한 이해
1. IoC Container 확인
1. Bean 과 DI(Dependency Injection) 에 대한 이해
1. Aspect 모듈화 방법
1. Spring Core 에서 제공되는 기능 확인


## 학습 내용

### IoC Container
출처 : [스프링 프레임워크 핵심 기술 / 백기선](https://www.inflearn.com/course/spring-framework_core)
> Inversion of Control: 의존 관계 주입(Dependency Injection)이라고도 하며, 어떤 객체가
  사용하는 의존 객체를 직접 만들어 사용하는게 아니라, 주입 받아 사용하는 방법을 말 함.

- Spring IoC Container ?
    1. Application Component 의 중앙 저장소
    1. Bean 설정 소스로부터 빈 정의를 읽어들이고 빈을 구성, 제공
    1. Class
        - BeanFactory
        - ApplicationContext
        
- Bean
    - IoC Container가 관리하는 객체
    - 의존성 관리
    - 객체의 Scope 설정 (default : Singleton)
        - Singleton : 변하지 않는 하나, 런타임 시 성능 개선 도움 
        - Prototype : 객체 생성마다 다른 객체 (다른 메모리 주소)
        - ...
    - Lifecycle interface  
    
        출처: [Interface BeanFactory](https://docs.spring.io/spring-framework/docs/5.0.8.RELEASE/javadoc-api/org/springframework/beans/factory/BeanFactory.html)  
       > Bean factory implementations should support the standard bean lifecycle interfaces as far as possible. The full set of initialization methods and their standard order is:
       
            1. BeanNameAware's setBeanName                                                                                                                                                                                                 
            2. BeanClassLoaderAware's setBeanClassLoader  
            3. BeanFactoryAware's setBeanFactory  
            4. EnvironmentAware's setEnvironment  
            5. EmbeddedValueResolverAware's setEmbeddedValueResolver  
            6. ResourceLoaderAware's setResourceLoader (only applicable when running in an application context)  
            7. ApplicationEventPublisherAware's setApplicationEventPublisher (only applicable when running in an application context)  
            8. MessageSourceAware's setMessageSource (only applicable when running in an application context)  
            9. ApplicationContextAware's setApplicationContext (only applicable when running in an application context)  
            10. ServletContextAware's setServletContext (only applicable when running in a web application context)  
            11. postProcessBeforeInitialization methods of BeanPostProcessors  
            12. InitializingBean's afterPropertiesSet  
            13. a custom init-method definition  
            14. postProcessAfterInitialization methods of BeanPostProcessors  
              
       > On shutdown of a bean factory, the following lifecycle methods apply:  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
            1. postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors  
            2. DisposableBean's destroy  
            3. a custom destroy-method definition  
 
    - Application의 lifecycle과 Bean의 lifecycle
        
        Lifecycle of Application  
        
        | cycle | 내용 |
        |:---|---|
        | Initialization(초기화) | 이용하기 위해서 Application을 생성함.  시스템 리소스를 확보. |
        | Use(이용) | Application 에서 이용되는 과정 |
        | Destruction(종료) | 종료 처리.  시스템의 리소스를 돌려줌.  Application은 Garbage collection 의 대상이 됨. |
    
        - Initialization (BeanPostProcessor, InitializingBean interface)
            - Bean 정의 로드(설정)
            - Bean 생성 및 초기화
            - BeanPostProcessor.postProcessBeforeInitialization()  
            -> InitializingBean.afterPropertiesSet()   
            -> BeanPostProcessor.postProcessAfterInitialization()   
        - Use
            - ApplicationContext(BeanFactory)_getBean()
        - Destruction
            - Bean 제거 메소드
            - Bean이 사용한 리소스 반환
            - Container 종료

    - lifecycle 관리  
        1. org.springframework.beans.factory.InitializingBean 인터페이스 구현
        1. annotation
            
            > 출처 : 스프링 4 입문 - 웹 애플리케이션의 기초부터 클라우드 네이티브 입문까지 / 하세가와 유이치, 오오노 와타루, 토키 코헤이 (옮긴이 : 권은철, 전민수, 펴낸이 : 김태현) - 한빛미디어 p99, 표2-6
            
            | annotation | 설명 | 
            |:---|---|
            | @PostConstruct | 초기 처리를 하는 메서드 선언. 메서드 이름은 임의로 설정 가능.  단 메서드와 인수 없이 반환형은 void 형으로 해야 함 |
            | @preDestroy | 종료 처리를 하는 메서드 선언. 메서드 이름은 임의.  단, 메서드 인수 없이 반환형은 void 형으로 해야 한다. |
            
        - @PostConstruct는 IoC container에 의해 인스턴스 변수에 무언가 injection 된 다음 호출. 즉, injection 된 값으로 초기 처리할 때 사용.  
        (다른 방법으론 생성자에서 초기 처리를 하면 된다고 함)
            ```
                @PostConstruct
                public void postConstruct(){
                    System.out.println("===================");
                    System.out.println("Hello SpringBoot");
                    System.out.println("===================");
                }
            ```   
        - @PreDestroy는 종료 처리 시 사용. (Java에는 소멸자가 없음.)
            ```
               @PreDestroy
               public void stop(){
                   System.out.println("===================");
                   System.out.println("goodBye SpringBoot");
                   System.out.println("===================");
               }
            ```

- ApplicationContext와 Bean 설정 방법
    - 설정 (application.xml)
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
        <bean id="bookService" class="net.gentledot.demospringcore.demo.book.BookService">
            <property name="bookRepository" ref="bookRepository" />
        </bean>
        
        <bean id="bookRepository" class="net.gentledot.demospringcore.demo.book.BookRepository"></bean>
        
    </beans>
    
    ```
    - 설정 (@Configuration, @Bean)
    ```
    package net.gentledot.demospringcore.demo.config;
    
    import net.gentledot.demospringcore.demo.book.BookRepository;
    import net.gentledot.demospringcore.demo.book.BookService;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    public class ApplicationConfig {
    
        @Bean
        public BookRepository bookRepository() {
            return new BookRepository();
        }
        
        @Bean
        public BookService bookService() {
            BookService bookService = new BookService();
            bookService.setBookRepository(bookRepository());
        }
    }
    ```
  
    - bean 꺼내기 (xml : ClassPathXmlApplicationContext)
    ```
    public cass DemoApplication(){
        public static void main(String[] args) {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));
            BookService bookService = (BookService) applicationContext.getBean("bookService");
            System.out.println(bookService.bookRepository != null);
        }
    }
    ```
  
    - bean 꺼내기 (@annotation : AnnotationConfigApplicationContext)
    ```
    public cass DemoApplication(){
        public static void main(String[] args) {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        }
    }
    ```

- component-scan
    - 설정 (application.xml)
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
        
        <context:component-scan base-package="net.gentledot.demospringcore.demo"/>
    
    </beans>
    ```
    - 설정 (@ComponentScan)
    ```
    package net.gentledot.demospringcore.demo.config;
    
    import net.gentledot.demospringcore.demo.DemoApplication;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    @ComponentScan(basePackageClasses = DemoApplication.class)
    public class ApplicationConfig {
    }
    ```
  
    - Bean 등록 (특정 패키지 이하의 모든 클래스 중 @Component annotation을 사용한 클래스를 Bean으로 자동 등록)
    ```
    @Component
    public class BookService {
    }
    ```
      
- @Autowired
    - 사용할 수 있는 위치
        - Constructor (Spring 4.3 이후부터는 하나만 있는 생성자에 @Autowire 생략 가능)
            ```
            private final BookRepository bookRepository;
            
            @Autowired // Spring 4.3 이상이면 생략 가능
            public BookService(BookRepository bookRepository) {
                this.bookRepository = bookRepository;
            }
            ```
        - Field
            ```
            // @Autowired (required = false) 라면 의존성 주입이 필수가 아니어도 인스턴스 생성됨.
            @Autowired
            private BookRepository bookRepository;
            ```
        - Setter
            ```
            private BookRepository bookRepository;
                
            // @Autowired (required = false) 라면 의존성 주입이 필수가 아니어도 인스턴스 생성됨.
            @Autowired
            public void setBookRepository(BookRepository bookRepository) {
                this.bookRepository = bookRepository;
            }
            ```
    
    - Bean 등록의 경우의 수
        1. 해당 타입의 Bean이 없는 경우
        1. 해당 타입의 Bean이 한 개인 경우
        1. 해당 타입의 Bean이 여러 개인 경우
            - 여러 Bean 중 하나만 사용해야 할 경우
                - 사용하지 않는 Bean은 제거 하거나
                - 해당하는 객체와 같은 이름의 Bean 찾으면 해당 Bean 사용
                - 못 찾으면 실패
            - 여러 Bean 중 여러 개를 사용해야 할 경우
                - 대표 객체는 @Primary로 설정
                - 이외에 사용해야할 객체는 @Qualifier 로 Bean을 찾아 사용
        
    - 같은 타입의 Bean이 여러개일 때
        > Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
        - @Primary
        - 모두 주입 받기 (일괄적인 동작을 설정해야 할 경우)
        - @Qualifier
    
    - AutowiredAnnotationBeanPostProcessor extends BeanPostProcessor
        > 스프링이 제공하는 @Autowired와 @Value annotation 그리고 JSR-330의
          @Inject annotation 지원하는 annotation 처리기.
