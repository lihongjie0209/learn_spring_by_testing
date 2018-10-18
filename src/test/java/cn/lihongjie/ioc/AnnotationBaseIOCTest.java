package cn.lihongjie.ioc;

import cn.lihongjie.beans.BeanWithDependency;
import cn.lihongjie.beans.aop.*;
import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 *
 * Autowired is fundamentally about type-driven injection with optional semantic qualifiers.
 * @author 982264618@qq.com
 */
public class AnnotationBaseIOCTest {

	static Logger logger = Logger.getLogger(AnnotationBaseIOCTest.class);

	/*
	spring context 是一个bean工厂, 负责项目中所有的对象创建
	 */
	private static ApplicationContext ioc;

	@BeforeClass
	public static void setUp() throws Exception {
		// 使用基于注解的方式创建容器
		ioc = new ClassPathXmlApplicationContext("aop.xml");
		logger.info("ioc container is inited");
		// 查看日志发现, ioc容器会在初始化的时候就把对象创建好


		logger.info("\n"  +
				String.join("\n", Arrays.asList(ioc.getBeanDefinitionNames())));

	}


	@AfterClass
	public static void tearDown() throws Exception {

	}


	/**
	 * 测试包扫描
	 * @throws Exception
	 */
	@Test
	public void testAnnotation() throws Exception {

		Assert.assertNotNull(ioc.getBean(Service.class));
		Assert.assertNotNull(ioc.getBean(Component.class));
		Assert.assertNotNull(ioc.getBean(Controller.class));
		Assert.assertNotNull(ioc.getBean(Repository.class));

	}


	/**
	 * 可以在注解中自定义扫描时添加名称
	 * @throws Exception
	 */
	@Test
	public void testBeanName() throws Exception {


		CustomBeanName myBean = ioc.getBean("myBean", CustomBeanName.class);
		Assert.assertNotNull(myBean);

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


		cn.lihongjie.beans.aop.BeanWithDependency bean = ioc.getBean(cn.lihongjie.beans.aop.BeanWithDependency.class);

		Assert.assertNotNull(bean);


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

		cn.lihongjie.beans.aop.BeanWithLifeCycle bean = ioc.getBean(cn.lihongjie.beans.aop.BeanWithLifeCycle.class);

		Assert.assertThat(bean.isInit(), Is.is(true));

	}





}
