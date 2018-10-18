package cn.lihongjie.ioc;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author 982264618@qq.com
 */
@Configuration
@ComponentScan(basePackages = {"cn.lihongjie.beans.profile"})
public class AppProfileConfig {



}
