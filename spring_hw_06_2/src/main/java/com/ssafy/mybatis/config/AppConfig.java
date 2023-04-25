package com.ssafy.mybatis.config;

import javax.sql.DataSource;

import com.ssafy.mybatis.model.service.MemberService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import org.springframework.beans.factory.annotation.Value;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:dbinfo.properties")
// compoenent scan 하여야 함
@ComponentScan(basePackageClasses = MemberService.class)
@MapperScan(basePackages = {"com.ssafy.mybatis.model.dao"})
public class AppConfig {
    @Bean
    public TransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    // @Bean 에서 파라미터가 빈이면 자동으로 injection
    @Bean
    public SqlSessionTemplate template(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
        // sqlSesssionFactory 자동으로 인젝션됨.
    }

    @Bean
    public SqlSessionFactory factory(DataSource ds) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        // 첫글자 소문자
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] res = resolver.getResources("classpath:mapper/*.xml");
        System.out.println(res);
        bean.setMapperLocations(res);
        bean.setTypeAliasesPackage("com.ssafy.mybatis.model.dto");
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