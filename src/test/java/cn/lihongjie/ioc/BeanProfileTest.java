package cn.lihongjie.ioc;

import cn.lihongjie.beans.profile.Service;
import cn.lihongjie.beans.profile.ServiceProImpl;
import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author 982264618@qq.com
 */
public class BeanProfileTest {

	static Logger logger = Logger.getLogger(AnnotationBaseIOCTest.class);

	/*
	spring context 是一个bean工厂, 负责项目中所有的对象创建
	 */
	private static AnnotationConfigApplicationContext ioc;

	@BeforeClass
	public static void setUp() throws Exception {
		// 使用基于注解的方式创建容器
		ioc = new AnnotationConfigApplicationContext();
		// 激活profile
		ioc.getEnvironment().setActiveProfiles("pro");
		ioc.register(AppProfileConfig.class);
		ioc.refresh();


		logger.info("ioc container is inited");
		// 查看日志发现, ioc容器会在初始化的时候就把对象创建好


		logger.info("\n" +
				String.join("\n", Arrays.asList(ioc.getBeanDefinitionNames())));

	}





	@Test
	public void testProfile() throws Exception {


		Service bean = ioc.getBean(Service.class);
		Assert.assertTrue(bean.getClass() == (ServiceProImpl.class));


	}
}
