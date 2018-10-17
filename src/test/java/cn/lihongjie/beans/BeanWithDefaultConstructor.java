package cn.lihongjie.beans;

import java.util.logging.Logger;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
public class BeanWithDefaultConstructor {

	private static final org.apache.log4j.Logger logger = getLogger(BeanWithDefaultConstructor.class);



	public static BeanWithDefaultConstructor get() {
		return new BeanWithDefaultConstructor();
	}


	public BeanWithDefaultConstructor() {
		logger.info(getClass().getName() + " is constructing");

	}
}
