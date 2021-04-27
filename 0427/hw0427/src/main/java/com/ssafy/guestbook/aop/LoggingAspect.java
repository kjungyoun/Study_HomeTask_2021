package com.ssafy.guestbook.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// before는 메서드 호출 전에 수행하라, after는 메서드 호출 후 수행해라
	// around 는 메서드 실행 시작부터 끝 시간 사이를 의미한다.
	@Before(value ="execution(* com.ssafy.guestbook.model..*.*(..))")
	public void loggin(JoinPoint jp) {
		logger.debug("메서드 선언부 : {} 전달 파라미터 : {}",jp.getSignature(), Arrays.deepToString(jp.getArgs()));
	}
}
