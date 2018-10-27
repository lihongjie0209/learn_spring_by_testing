package cn.lihongjie.ioc.lifecycle.init.post;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * appcontext 会自动识别实现的postprocessor的接口类, 并注册到后置处理器汇中
 * @author 982264618@qq.com
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private static final Logger logger = getLogger(MyBeanFactoryPostProcessor.class);
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


		logger.info("my bean factory post processor init");





	}
}
