package cn.lihongjie.ioc.lifecycle.init.post;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@Component
public class BeanWithXAware implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware{

	public BeanWithXAware() {


		logger.info("我被初始化了");
	}

	private static final Logger logger = getLogger(BeanWithXAware.class);



	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {


		logger.info("class loader 是 : " + classLoader.toString());
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {


		logger.info("bean factory 是 : " + beanFactory.toString());

	}

	@Override
	public void setBeanName(String name) {

		logger.info("bean name 是 : " + name);


	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.info("context is "  + applicationContext.toString());
	}


}
