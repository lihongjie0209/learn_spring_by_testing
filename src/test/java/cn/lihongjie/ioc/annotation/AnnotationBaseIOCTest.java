package cn.lihongjie.ioc.annotation;

import cn.lihongjie.beans.BeanWithDependency;
import cn.lihongjie.beans.annotation.*;
import cn.lihongjie.beans.annotation.thirdParty.ExternalService;
import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 *
 * Autowired is fundamentally about type-driven injection with optional semantic qualifiers.
 * @author 982264618@qq.com
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AnnotationConfig.class})
public class AnnotationBaseIOCTest {

	static Logger logger = Logger.getLogger(AnnotationBaseIOCTest.class);

	/*
	spring context 是一个bean工厂, 负责项目中所有的对象创建
	 */
	@Autowired
	private ApplicationContext ioc;
	@Autowired
	private Service service;
	@Autowired
	private Component component;
	@Autowired
	private Controller controller;
	@Autowired
	private Repository repository;
	@Autowired
	@Qualifier("myBean")
	private CustomBeanName customBeanName;


	@Autowired
	ExternalService externalService;

	@Autowired
	private cn.lihongjie.beans.annotation.BeanWithDependency beanWithDependency;


	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 测试包扫描
	 * @throws Exception
	 */
	@Test
	public void testAnnotation() throws Exception {

		Assert.assertNotNull(service);
		Assert.assertNotNull(component);
		Assert.assertNotNull(controller);
		Assert.assertNotNull(repository);

	}


	/**
	 * 可以在注解中自定义扫描时添加名称
	 * @throws Exception
	 */
	@Test
	public void testBeanName() throws Exception {


		Assert.assertNotNull(customBeanName);

	}


	/**
	 * 当使用类型自动匹配时, 很有可能出现冲突, 为了在有多个匹配的实例中选择出合适的对象, 需要在注入的时候指定@Qualifier
	 *
	 * spring 自动加载的bean的@Qualifier 默认就是bean name
	 *
	 * @throws Exception
	 */
	@Test

	public void testAutoWireTypeConflict() throws Exception {



		Assert.assertNotNull(beanWithDependency);


	}



	/**
	 * 同步bean初始化顺序
	 * @throws Exception
	 */
	@Test
	@Ignore("目前没有发现怎么实现")
	public void testDependsOn() throws Exception {
		BeanWithDependency bean = ioc.getBean("beanWithDependencyDependOnGlobalDependency",
				BeanWithDependency.class);
		Assert.assertNotNull(bean);

	}

	/**
	 * 默认情况下单例
	 * @throws Exception
	 */
	@Test
	public void testSingleton() throws Exception {
		Component bean = ioc.getBean(Component.class);
		Component bean2 = ioc.getBean(Component.class);
		Assert.assertThat(bean, Is.is(bean2));



	}


	/**
	 * 创建非单例的bean, 可以使用注解来确定bena的scope
	 *
	 * @throws Exception
	 */
	@Test
	public void testNonSingleton() throws Exception {
		NonSingletonBean bean = ioc.getBean(NonSingletonBean.class);
		NonSingletonBean bean2 = ioc.getBean(NonSingletonBean.class);
		Assert.assertThat(bean, IsNot.not(bean2));


	}


	/**
	 * bean创建之后回调函数, 通过注解的方式
	 *
	 * @throws Exception
	 */
	@Test
	public void testInitializationCallbacks() throws Exception {

		BeanWithLifeCycle bean = ioc.getBean(BeanWithLifeCycle.class);

		Assert.assertThat(bean.isInit(), Is.is(true));

	}


	@Test
	public void testBeanConfig() throws Exception {


		Assert.assertNotNull(externalService);

		logger.info(externalService);


	}
}
