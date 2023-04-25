package spring.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import spring_mybatis.config.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class DataSourceTest {

	@Value("${db.driver}")
	String driver;

	@Test
	public void testDriver() {
		assertEquals(driver, "com.mysql.cj.jdbc.Driver");
	}

	@Autowired
	BasicDataSource ds;

	@Test
	public void testDs() throws SQLException {
		assertNotNull(ds);

		List<Connection> cons = new ArrayList<Connection>();

		for (int i = 0; i < 10; i++) {
			cons.add(ds.getConnection());
			printConnection();
		}
		cons.forEach(c -> {
			try {
				c.close();
				printConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	private void printConnection() {
		System.out.println("현재 Connection : " + ds.getNumActive() + " 한가한" + ds.getNumIdle());
	}

	@Autowired
	SqlSessionFactory factory;

	@Test
	public void factoryTest() {
		assertNotNull(factory);
	}

}
