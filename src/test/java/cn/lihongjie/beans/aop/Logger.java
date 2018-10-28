package cn.lihongjie.beans.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */


@Aspect
@Component
public class Logger {


	private static final org.apache.log4j.Logger logger = getLogger(Logger.class);

	@Before(value = "within(cn.lihongjie.beans.aop.Service)")
	public void logBefore() {


		logger.info("before exec");


	}


	@AfterThrowing(pointcut = "within(cn.lihongjie.beans.aop.Service)", throwing = "ex")
	public void logException(Throwable ex) {

		logger.error("after throw", ex);

	}

	@AfterReturning(pointcut = "within(cn.lihongjie.beans.aop.Service)", returning = "ret")
	public void logReturn(Object ret) {

		logger.info(String.format("after exec, return value is : %s", String.valueOf(ret)));

	}


	@Around("within(cn.lihongjie.beans.aop.Service)")
	public Object log(ProceedingJoinPoint pjp) {

		logger.info(String.format("%s method is called", pjp.getTarget().toString()));
		logger.info(String.format("method args is %s", Arrays.toString(pjp.getArgs())));

		Object ret = null;
		try {
			ret = pjp.proceed(pjp.getArgs());

			logger.info(String.format("method return value  is %s", String.valueOf(ret)));

		} catch (Throwable throwable) {
			logger.info("after throw");
		} finally {

			logger.info("finally");

		}

		return ret;

	}


}
