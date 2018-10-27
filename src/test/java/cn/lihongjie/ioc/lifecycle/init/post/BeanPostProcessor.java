package cn.lihongjie.ioc.lifecycle.init.post;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * bean post processor 是第一批创建的bean, 他们可以在其他bean创建之前和之后进行操作
 * @author 982264618@qq.com
 */
@Component
public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor{
	private static final Logger logger = getLogger(BeanPostProcessor.class);

	public BeanPostProcessor() {

		logger.info("bean post processor init");

	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info(beanName + "初始化回调之前");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		logger.info(beanName + "初始化回调之后");
		return bean;
	}
}
