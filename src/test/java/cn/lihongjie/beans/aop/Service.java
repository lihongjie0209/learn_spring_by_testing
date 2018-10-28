package cn.lihongjie.beans.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@Component
public class Service {

	private static final Logger logger = getLogger(Service.class);

	public boolean doThing() {

		logger.info("do.....");

		return true;

	}

	public boolean doThingWrong() {


		throw new IllegalStateException();

	}

}
