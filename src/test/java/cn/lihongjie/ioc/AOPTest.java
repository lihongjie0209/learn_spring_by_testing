package cn.lihongjie.ioc;

import cn.lihongjie.beans.aop.Service;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author 982264618@qq.com
 */
public class AOPTest {


	static Logger logger = Logger.getLogger(JavaBaseIOCTest.class);

	/*
	spring context 是一个bean工厂, 负责项目中所有的对象创建
	 */
	private static ApplicationContext ioc;

	@BeforeClass
	public static void setUp() throws Exception {
		// 使用基于注解的方式创建容器
		ioc = new AnnotationConfigApplicationContext(AppAOPConfig.class);
		logger.info("ioc container is inited");
		// 查看日志发现, ioc容器会在初始化的时候就把对象创建好


		logger.info("\n" +
				String.join("\n", Arrays.asList(ioc.getBeanDefinitionNames())));

	}


	@AfterClass
	public static void tearDown() throws Exception {

	}


	@Test(expected = IllegalStateException.class)
	public void testBefore() throws Exception {


		Service bean = ioc.getBean(Service.class);

		bean.doThing();
		bean.doThingWrong();


	}
}
