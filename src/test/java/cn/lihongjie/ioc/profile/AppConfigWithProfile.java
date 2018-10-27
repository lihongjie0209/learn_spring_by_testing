package cn.lihongjie.ioc.profile;

import cn.lihongjie.beans.profile.Profile;
import cn.lihongjie.beans.profile.Service;
import cn.lihongjie.beans.profile.ServiceDevImpl;
import cn.lihongjie.beans.profile.ServiceProImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 982264618@qq.com
 */

@Configuration
public class AppConfigWithProfile {



	@Bean
	@org.springframework.context.annotation.Profile("dev")
	public Service devService() {
		return new ServiceDevImpl();
	}


	@Bean
	@org.springframework.context.annotation.Profile("pro")
	public Service prodService() {
		return new ServiceProImpl();
	}





}
