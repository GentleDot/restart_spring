package net.gentledot.demospringcore.demo.config;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    @Async
    public void eventHandle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("AnotherHandler 에서 이벤트 받음. 받은 데이터는 " + event.getData());
    }
}
