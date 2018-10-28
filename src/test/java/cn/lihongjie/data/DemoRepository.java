package cn.lihongjie.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 982264618@qq.com
 */
@Repository
public class DemoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;



	public void insert(String name) {

		jdbcTemplate.update("INSERT INTO SYS_USER (`NAME`) VALUES (?)", name);


	}


	public List<Map<String, Object>> get() {



		return jdbcTemplate.queryForList("SELECT * FROM SYS_USER");
	}


}
