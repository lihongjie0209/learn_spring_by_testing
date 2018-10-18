package cn.lihongjie.ioc;

import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * @author 982264618@qq.com
 */
public class ProfileSourceTest {

	static Logger logger = Logger.getLogger(JavaBaseIOCTest.class);

	/*
	spring context 是一个bean工厂, 负责项目中所有的对象创建
	 */
	private static ApplicationContext ioc;

	@BeforeClass
	public static void setUp() throws Exception {
		// 使用基于注解的方式创建容器
		ioc = new AnnotationConfigApplicationContext(AppPropertySourceConfig.class);
		logger.info("ioc container is inited");
		// 查看日志发现, ioc容器会在初始化的时候就把对象创建好


		logger.info("\n" +
				String.join("\n", Arrays.asList(ioc.getBeanDefinitionNames())));

	}


	@AfterClass
	public static void tearDown() throws Exception {

	}




	@Test
	public void testProperty() throws Exception {

		Environment env = ioc.getBean(Environment.class);

		Assert.assertThat(env.getProperty("key1"), Is.is("value1"));
		Assert.assertThat(env.getProperty("key2"), Is.is("value2"));


	}
}
