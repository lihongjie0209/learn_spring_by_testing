package cn.lihongjie.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static org.apache.log4j.Logger.getLogger;

/**
 * @author 982264618@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes = SpringDataTest.class)
@ComponentScan(basePackageClasses = DemoRepository.class)
public class SpringDataTest {

private static final Logger logger = getLogger(SpringDataTest.class);
	@Autowired
	private DemoRepository demoRepository;

	@Bean
	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUrl("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:sql/init.sql'");
		dataSource.setUsername("sa");
		dataSource.setInitialSize(5);
		return dataSource;


	}

	;


	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {


		return new JdbcTemplate(dataSource);


	}

	;


	@Test
	public void testInsert() throws Exception {

		demoRepository.insert("test");
		List<Map<String, Object>> list = demoRepository.get();
logger.info(list);


		Assert.assertThat(list.size(), Is.is(1));

	}
}
