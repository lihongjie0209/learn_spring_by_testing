package cn.lihongjie.ioc.lifecycle.init.post;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@Component
public class BeanWithLiftCycle implements InitializingBean, DisposableBean {

	private static final Logger logger = getLogger(BeanWithLiftCycle.class);

	public BeanWithLiftCycle() {

		logger.info("start init ");

	}

	@Override
	public void afterPropertiesSet() throws Exception {


		logger.info("我是初始化回调函数");


	}

	@Override
	public void destroy() throws Exception {
		logger.info("我是终止回调函数");
	}
}
