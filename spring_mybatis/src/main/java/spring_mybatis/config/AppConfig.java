package spring_mybatis.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import spring_mybatis.model.dao.MemberDao;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@PropertySource("classpath:dbinfo.properties")
// compoenent scan 하여야 함
@ComponentScan(basePackageClasses = MemberDao.class)
public class AppConfig {

	@Bean
	public SqlSessionFactory factory(DataSource ds) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds);
		// 첫글자 소문자
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] res = resolver.getResources("classpath:mapper/*.xml");
		bean.setMapperLocations(res);
		bean.setTypeAliasesPackage("spring_mybatis.model.dto");
		// bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		return bean.getObject();
	}

	@Bean
	public DataSource dataSource(@Value("${db.driver}") String driverClassName, @Value("${db.url}") String url,
			@Value("${db.username}") String userName, @Value("${db.password}") String password) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);

		// 맨처음 다섯개만 만들어 놓는다.
		ds.setInitialSize(5);
		ds.setMaxTotal(10);
		// 7개 까지는 최소한 유지한다.
		ds.setMinIdle(7);
		return ds;
	}

}