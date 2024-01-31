package com.akki.SpringMVCWithBoot.aop;

import com.akki.SpringMVCWithBoot.controller.AlienController;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlienController.class);

    @Before("execution (public java.util.List<com.akki.SpringMVCWithBoot.model.Alien> com.akki.SpringMVCWithBoot.controller.AlienController.getAliens())")
    public void logBefore() {
        LOGGER.info("AOP: getAlien() called");  // look like following
//        2024-01-31T13:53:02.143+05:30  INFO 2416 --- [nio-8080-exec-1] c.a.S.controller.AlienController         : AOP: getAlien() called
    }

//    on successful run
    @AfterReturning("execution (public java.util.List<com.akki.SpringMVCWithBoot.model.Alien> com.akki.SpringMVCWithBoot.controller.AlienController.getAliens())")
    public void logAfterReturning() {
        LOGGER.info("AOP: getAlien() executed");
    }

//    on error/exception
    @AfterThrowing("execution (public java.util.List<com.akki.SpringMVCWithBoot.model.Alien> com.akki.SpringMVCWithBoot.controller.AlienController.getAliens())")
    public void logAfterThrowing() {
        LOGGER.info("AOP: getAlien() threw some problem");
    }

//    @After is like finally() method it will print whatever happens.
    @After("execution (public * com.akki.SpringMVCWithBoot.controller.AlienController.getAliens())")    // use * if there's no overloading method. NOT RECOMMENDED.
    public void logAfter() {
        LOGGER.info("AOP: getAlien() executed**");
//        2024-01-31T13:53:02.384+05:30  INFO 2416 --- [nio-8080-exec-1] c.a.S.controller.AlienController         : AOP: getAlien() executed
    }

}
