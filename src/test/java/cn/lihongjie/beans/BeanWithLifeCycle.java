package cn.lihongjie.beans;

import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
public class BeanWithLifeCycle {

	boolean init = false;

	private static final Logger logger = getLogger(BeanWithLifeCycle.class);
	public BeanWithLifeCycle() {
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



}
