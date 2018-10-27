package cn.lihongjie.i18n;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

/**
 * @author 982264618@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes = I18NTest.class)
public class I18NTest {


	@Autowired
	MessageSource context;


	@Test
	public void testMessage() throws Exception {


		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:/i18n");
		Assert.assertThat(messageSource.getMessage("message", new Object[]{}, Locale.ENGLISH), Is.is("test"));

		Assert.assertThat(messageSource.getMessage("message", new Object[]{}, Locale.GERMAN), Is.is("detest"));
	}
}
