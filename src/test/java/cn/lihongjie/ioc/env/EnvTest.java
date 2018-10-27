package cn.lihongjie.ioc.env;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 982264618@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigWithEnv.class)
public class EnvTest {

	@Autowired
	Environment environment;


	@Test
	public void testEnv() throws Exception {


		String stringvar = environment.getProperty("stringvar");


		Assert.assertThat(stringvar, Is.is("aaaaaaaaa"));

		Integer integervar = environment.getProperty("intvar", Integer.class);


		Assert.assertThat(integervar, Is.is(1));
	}
}
