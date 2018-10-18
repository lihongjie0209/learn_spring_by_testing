package cn.lihongjie.ioc;

import cn.lihongjie.beans.aop.Logger;
import cn.lihongjie.beans.aop.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 982264618@qq.com
 */
@Configuration

@EnableAspectJAutoProxy // 开启aop

public class AppAOPConfig {




	@Bean
	public Logger getLogging() {

		return new Logger();

	}

	@Bean
	public Service getService() {

		return new Service();

	}


}
