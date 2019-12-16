package net.gentledot.demospringcore.demo.book;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {


//    @Around("execution(* net.gentledot..*.EventService.*(..))")
    @Around("@annotation(PerLogging)")
    public Object logPerf(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return returnValue;
    }
}
