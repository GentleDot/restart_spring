package net.gentledot.demospringcore.demo.config;

import org.springframework.context.event.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class MyEventHandler {

    @EventListener
    @Async
    public void eventHandle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler 에서 이벤트 받음. 받은 데이터는 " + event.getData());
    }

    @EventListener
    @Async
    public void eventHandle(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler_ContextRefreshedEvent");
        System.out.println("Source는 " + event.getSource());
        System.out.println("context : " + event.getApplicationContext());
    }

    @EventListener
    @Async
    public void eventHandle(ContextStartedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler_ContextStartedEvent");
        System.out.println("Source는 " + event.getSource());
        System.out.println("context : " + event.getApplicationContext());
    }

    @EventListener
    @Async
    public void eventHandle(ContextStoppedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler_ContextStoppedEvent");
        System.out.println("Source는 " + event.getSource());
        System.out.println("context : " + event.getApplicationContext());
    }

    @EventListener
    @Async
    public void eventHandle(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler_ContextClosedEvent");
        System.out.println("Source는 " + event.getSource());
        System.out.println("context : " + event.getApplicationContext());
    }

    @EventListener
    @Async
    public void eventHandle(RequestHandledEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler_RequestHandledEvent");
        System.out.println("Source는 " + event.getSource());
//        System.out.println("context : " + event.getApplicationContext());
    }
}


// Spring 4.2 이전 버전에서의 EventListener
/*
public class MyEventHandler implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("이벤트 받음. 받은 데이터는 " + event.getData());
    }
}
*/
