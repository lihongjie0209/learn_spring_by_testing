package cn.lihongjie.resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes = ResourceLoaderTest.class)
public class ResourceLoaderTest {

	@Value("classpath:/resources.txt")
	Resource resource;

	private static final Logger logger = getLogger(ResourceLoaderTest.class);

	@Test
	public void testResourceLoader() throws Exception {

		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

		Resource resource = resourceLoader.getResource("classpath:/resources.txt");

		Assert.assertNotNull(resource);

		String filename = resource.getFilename();

		logger.info(filename);

	}


	/**
	 * 可以通过路径匹配获得一组resource
	 * @throws Exception
	 */
	@Test
	public void testResourcePatternResolver() throws Exception {


		PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

		Resource[] resources = patternResolver.getResources("classpath:/*.xml");
		logger.info(Arrays.toString(resources));


	}


	@Test
	public void testResourceInjection() throws Exception {


		Assert.assertNotNull(resource);

	}
}
