package cn.lihongjie.ioc.annotation;

import cn.lihongjie.beans.annotation.Service;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.lihongjie.beans.annotation.AnnoBeans;
import cn.lihongjie.beans.annotation.thirdParty.ExternalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 982264618@qq.com
 */
@Configuration
@ComponentScan(basePackageClasses = AnnoBeans.class)
public class AnnotationConfig {


	@Bean
	public ExternalService externalService(Service service) {


		ExternalService externalService = new ExternalService(1, "test");
		externalService.setService(service);
		return externalService;

	}
}
