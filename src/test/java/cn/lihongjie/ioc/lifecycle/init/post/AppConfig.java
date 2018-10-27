package cn.lihongjie.ioc.lifecycle.init.post;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 982264618@qq.com
 */
@Configuration
@ComponentScan(basePackageClasses = MyBeanFactoryPostProcessor.class)
public class AppConfig {

}
