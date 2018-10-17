package cn.lihongjie.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
public class BeanWithSpringLifeCycle implements InitializingBean, DisposableBean {

	boolean init = false;

	private static final Logger logger = getLogger(BeanWithSpringLifeCycle.class);
	public BeanWithSpringLifeCycle() {
		logger.info("constructor is called");
	}

	public boolean isInit() {
		return init;
	}

	public void init() {
		logger.info("init is called");
		init = true;
	}


	public void destroy() {

		logger.info("destroy is called");
		init = false;
	}


	public void afterPropertiesSet() throws Exception {
		init();
	}
}
