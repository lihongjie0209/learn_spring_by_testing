package cn.lihongjie.ioc.conflict;

import cn.lihongjie.beans.conflict.Service;
import cn.lihongjie.beans.conflict.ServiceDevImpl;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 982264618@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigWithQualifier.class)
public class BeanConflictTest {


	@Autowired
	@Qualifier("devService")
	Service service;


	@Test
	public void testQualifier() throws Exception {


		Assert.assertThat(service, IsInstanceOf.instanceOf(ServiceDevImpl.class));


	}
}
