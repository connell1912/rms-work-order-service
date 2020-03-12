package com.rms.aspect;

import com.rms.driver.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/
 * @author 1912dec16 Java Fullstack Batch 
 * <br>
 * <br>
 * The AspectClass handles the scattering issue with our logger. This enables us to implement the logger
 * after certain controller methods are called and is achieved by using the point cut expression and JoinPoints. 
 * The After annotation is used so that the logger will log information after these methods.
 */
    
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
