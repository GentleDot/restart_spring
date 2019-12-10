# Spring Framework Core

## 목차
- [참고 자료](#출처)
- [학습 목표](#목표)

## 출처
- 강좌
    1. [스프링 프레임워크 핵심 기술 / 백기선](https://www.inflearn.com/course/spring-framework_core)
- 자료
    1. [Spring Framework Documentation - Core](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#spring-core)

## 목표
1. IoC(Inversion of Control), AOP(Aspect Oriented Programming), PSA(Portable Service Abstraction) 에 대한 이해
1. IoC Container 확인
1. Bean 과 DI(Dependency Injection) 에 대한 이해
1. Aspect 모듈화 방법
1. Spring Core 에서 제공되는 기능 확인


## IoC Container
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
     