package org.springframework.samples.petclinic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AspectExample {
    private Logger log = LoggerFactory.getLogger(this.getClass());
//    private Log log = LogFactory.getLog(this.getClass());

    @Pointcut("execution(* org.springframework.samples.petclinic.owner.OwnerController.*(..))")
    private void loggingOperation(){
    }

    /*
    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method {}() begins with {} ", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

    // execution(모든 수정자.모든 클래스.모든 메서드(인수가 몇 개라도 상관 없음))
//    @After("execution(* *.*(..))")
//    public void logAfter(JoinPoint joinPoint) {
//        log.info("The method {}() ends", joinPoint.getSignature().getName());
//    }

    @AfterReturning(
        pointcut = "execution(* *.*(..))",
        returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
        pointcut = "execution(* *.*(..))",
        throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
        log.error("Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
    }
    */

    @Around("loggingOperation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            log.info("The method {}() ends with ", joinPoint.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()) , joinPoint.getSignature().getName());
            throw e;
        }
    }

}
