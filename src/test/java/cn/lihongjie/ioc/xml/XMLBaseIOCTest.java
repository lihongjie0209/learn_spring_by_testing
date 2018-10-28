package cn.lihongjie.ioc.xml;

import cn.lihongjie.beans.*;
import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 982264618@qq.com
 */
public class XMLBaseIOCTest {

	static Logger logger = Logger.getLogger(XMLBaseIOCTest.class);

	/*
	spring context 是一个bean工厂, 负责项目中所有的对象创建
	 */
	private static ConfigurableApplicationContext ioc;

	@BeforeClass
	public static void setUp() throws Exception {
		// 使用基于xml的方式创建容器
		ioc = new ClassPathXmlApplicationContext("main.xml");
		logger.info("ioc container is inited");
		// 查看日志发现, ioc容器会在初始化的时候就把对象创建好
	}


	@AfterClass
	public static void tearDown() throws Exception {

		ioc.close();

	}


	/**
	 * xml 可以嵌套xml, 使用import标签
	 *
	 * 项目中的ioc配置文件应该分类, 便于管理
	 *
	 * 最终所有的ioc文件都应该有一个统一的入口 --> main.xml
	 * @throws Exception
	 */
	@Test
	public void testCompositionOfXML() throws Exception {


		BeanWithDefaultConstructor bean = ioc.getBean("beanWithDefaultConstructor", BeanWithDefaultConstructor.class);
		Assert.assertNotNull(bean);
	}


	/**
	 * 可以给bean起别名, 二者都指向同一个bean, 地址空间相同
	 * @throws Exception
	 */
	@Test
	public void testBeanAlias() throws Exception {


		BeanWithDefaultConstructor beanWithDefaultConstructor2 = ioc.getBean("beanWithDefaultConstructor2", BeanWithDefaultConstructor.class);
		BeanWithDefaultConstructor beanWithDefaultConstructor = ioc.getBean("beanWithDefaultConstructor", BeanWithDefaultConstructor.class);

	Assert.assertThat(beanWithDefaultConstructor, Is.is(beanWithDefaultConstructor2));
	}


	/**
	 * 可以通过静态工程方法创建bean
	 * @throws Exception
	 */
	@Test
	public void testStaticFactory() throws Exception {


		BeanWithDefaultConstructor bean = ioc.getBean("beanWithDefaultConstructorFromStaticFactory",
				BeanWithDefaultConstructor.class);
		Assert.assertNotNull(bean);
	}


	/**
	 * 可以通过工厂类方法创建bean
	 *
	 * @throws Exception
	 */
	@Test
	public void testFactory() throws Exception {


		BeanWithDefaultConstructor bean = ioc.getBean("beanWithDefaultConstructorFromFactory",
				BeanWithDefaultConstructor.class);
		Assert.assertNotNull(bean);
	}


	/**
	 * 通过构造函数注入依赖
	 *
	 * @throws Exception
	 */
	@Test
	public void testConstructorDI() throws Exception {
		BeanWithDependency bean = ioc.getBean("beanWithDependency",
				BeanWithDependency.class);
		Assert.assertNotNull(bean);


	}


	/**
	 * 通过setter注入依赖
	 *
	 * @throws Exception
	 */
	@Test
	public void testSetterDI() throws Exception {
		BeanWithDependency bean = ioc.getBean("beanWithDependency2",
				BeanWithDependency.class);
		Assert.assertNotNull(bean);

	}


	/**
	 * 同步bean初始化顺序
	 * @throws Exception
	 */
	@Test
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
		BeanWithDependency bean = ioc.getBean("beanWithDependencyDependOnGlobalDependency",
				BeanWithDependency.class);
		BeanWithDependency bean2 = ioc.getBean("beanWithDependencyDependOnGlobalDependency",
				BeanWithDependency.class);
		Assert.assertThat(bean, Is.is(bean2));



	}


	/**
	 * 创建非单例的bean
	 *
	 * @throws Exception
	 */
	@Test
	public void testNonSingleton() throws Exception {
		GlobalDependency bean = ioc.getBean("globalDependencyNonSingleton",
				GlobalDependency.class);
		GlobalDependency bean2 = ioc.getBean("globalDependencyNonSingleton",
				GlobalDependency.class);
		Assert.assertThat(bean, IsNot.not(bean2));


	}


	/**
	 * bean创建之后回调函数
	 *
	 * @throws Exception
	 */
	@Test
	public void testInitializationCallbacks() throws Exception {

		BeanWithLifeCycle bean = ioc.getBean(BeanWithLifeCycle.class);

		Assert.assertThat(bean.isInit(), Is.is(true));

	}


	/**
	 * bean在容器销毁之后的回调函数
	 *
	 * @throws Exception
	 */
	@Test
	public void testDestructionCallbacks() throws Exception {

		BeanWithLifeCycle bean = ioc.getBean(BeanWithLifeCycle.class);



	}

	/**
	 * bean在容器销毁之后的回调函数
	 *
	 * @throws Exception
	 */
	@Test
	public void testSpringLifeCycleInBeans() throws Exception {

		BeanWithSpringLifeCycle bean = ioc.getBean(BeanWithSpringLifeCycle.class);




	}

	@Test
	public void testListIoc() throws Exception {


		List list = ioc.getBean("list", List.class);

		Assert.assertThat(list.size(), Is.is(4));
	}
}
