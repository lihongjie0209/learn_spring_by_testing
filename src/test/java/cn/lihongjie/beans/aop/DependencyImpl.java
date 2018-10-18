package cn.lihongjie.beans.aop;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@Component
@Qualifier("dependency1")
public class DependencyImpl implements Dependency {

	private static final Logger logger = getLogger(DependencyImpl.class);
	public DependencyImpl() {

	}
}
