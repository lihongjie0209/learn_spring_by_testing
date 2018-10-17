package cn.lihongjie.beans;

import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
public class GlobalDependency {

	private static final Logger logger = getLogger(GlobalDependency.class);
	public GlobalDependency() throws InterruptedException {

		Thread.sleep(100);

		logger.info("global dependency is inited");


	}
}
