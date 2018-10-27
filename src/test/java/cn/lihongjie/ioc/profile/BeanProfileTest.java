package cn.lihongjie.ioc.profile;

import cn.lihongjie.beans.profile.Service;
import cn.lihongjie.beans.profile.ServiceDevImpl;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 982264618@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigWithProfile.class)
@ActiveProfiles("dev")
public class BeanProfileTest {


	@Autowired
	Service service;


	@Test
	public void testProfile() throws Exception {


		Assert.assertThat(service, IsInstanceOf.instanceOf(ServiceDevImpl.class));



	}
}
