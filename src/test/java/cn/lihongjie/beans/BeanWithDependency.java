package cn.lihongjie.beans;

import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
public class BeanWithDependency {

	private Dependency dependency1;
	private Dependency dependency2;


	private static final Logger logger = getLogger(BeanWithDependency.class);




	public BeanWithDependency(Dependency dependency1, Dependency dependency2) {



		this.dependency1 = Preconditions.checkNotNull(dependency1);
		this.dependency2 = Preconditions.checkNotNull(dependency2);
	}

	public BeanWithDependency() {

		logger.info("start init");
	}


	public void setDependency1(Dependency dependency1) {
		this.dependency1 = dependency1;
	}

	public void setDependency2(Dependency dependency2) {
		this.dependency2 = dependency2;
	}
}
