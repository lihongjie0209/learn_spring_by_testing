package cn.lihongjie.beans;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
public class BeanWithDefaultConstructorFactory {

	private static final org.apache.log4j.Logger logger = getLogger(BeanWithDefaultConstructorFactory.class);



	public BeanWithDefaultConstructor get() {
		return new BeanWithDefaultConstructor();
	}



}
