package cn.lihongjie.beans.annotation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@Component
public class BeanWithLifeCycle {

	boolean init = false;

	private static final Logger logger = getLogger(BeanWithLifeCycle.class);
	public BeanWithLifeCycle() {
		logger.info("constructor is called");
	}

	public boolean isInit() {
		return init;
	}

	@PostConstruct
	public void init() {
		logger.info("init is called");
		init = true;
	}

	@PreDestroy
	public void destroy() {

		logger.info("destroy is called");
		init = false;
	}



}
