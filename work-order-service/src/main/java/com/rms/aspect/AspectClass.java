package com.rms.aspect;

import com.rms.driver.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClass {

    @After("execution(* updateResolved(..))")
    public void adviceAfterResolution(JoinPoint jp) {
        Log4j.LOGGER.info("Work Order has been resolved");
    }

    @After("execution(* insert(..))")
    public void adviceAfterInsert(JoinPoint jp) {
        Log4j.LOGGER.info("Work Order has been submitted");
    }

}
