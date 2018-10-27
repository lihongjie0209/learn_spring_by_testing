package cn.lihongjie.ioc.condition;

import cn.lihongjie.beans.condition.Service;
import cn.lihongjie.beans.condition.ServiceDevImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author 982264618@qq.com
 */

@Configuration
public class AppConfigWithCondition {

	@Bean
	@Conditional(value = FalseCondition.class)
	public Service service(){


		return new ServiceDevImpl();




	};




}
