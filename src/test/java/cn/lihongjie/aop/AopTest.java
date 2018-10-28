package cn.lihongjie.aop;

import cn.lihongjie.beans.aop.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 982264618@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ComponentScan("cn.lihongjie.beans.aop")
@ContextConfiguration(classes = AopTest.class)
@EnableAspectJAutoProxy  // 使用注解的方式开启aop
public class AopTest {


	@Autowired
	Service service;


	@Test
	public void testAop() throws Exception {

		service.doThing();



	}
}
