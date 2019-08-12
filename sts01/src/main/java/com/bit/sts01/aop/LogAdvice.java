package com.bit.sts01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Before("execution(* com.bit.sts01.model.TestDbDao.*(..))")
	public void logAround() {
		logger.debug("@Before...");
	}
//	@Around("execution(* com.bit.sts01.model.TestDbDao.*(..))")
//	public Object logAround(ProceedingJoinPoint joinPoint) {
//		Object obj=null;
//		logger.debug("before...");
//		try {
//			obj=joinPoint.proceed();
//		} catch (Throwable e) {
//			logger.debug("throws err...");
//		}
//		logger.debug("after...");
//		return obj;
//		
//	}
}
