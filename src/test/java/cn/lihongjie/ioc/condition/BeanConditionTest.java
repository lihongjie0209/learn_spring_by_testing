package cn.lihongjie.ioc.condition;

import cn.lihongjie.beans.condition.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 982264618@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigWithCondition.class)
public class BeanConditionTest {


	@Autowired
	ApplicationContext context;


	@Test(expected = NoSuchBeanDefinitionException.class)
	public void testWhenConditionIsFalseBeanIsNotLoaded() throws Exception {


		Service contextBean = context.getBean(Service.class);

	}
}
