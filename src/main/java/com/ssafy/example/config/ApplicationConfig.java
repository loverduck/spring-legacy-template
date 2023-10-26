package com.ssafy.example.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:/config/dbinfo.properties")
@MapperScan({"com.ssafy.example.product.model.mapper", "com.ssafy.example.member.model.mapper"})
@ComponentScan("com.ssafy.example.*.model")
@EnableTransactionManagement
public class ApplicationConfig {
	
	// mybatis ���� ���� �߰�
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		bean.setDataSource(dataSource); // DB ����
		bean.setTypeAliasesPackage("com.ssafy.example.*.model.dto"); // typeAliase ���� - Ŭ������ or camelCase
		bean.setMapperLocations(resolver.getResources("classpath:/config/mappers/*.xml")); // mapper ����
		
		return bean.getObject();
	}
	
	
	// mybatis-config.xml DB ������ java���� ó���ϱ�
	@Bean
	public DataSource dataSource(
			@Value("${dbinfo.username}") String userName,
			@Value("${dbinfo.password}") String password,
			@Value("${dbinfo.driver}") String driverClassName,
			@Value("${dbinfo.url}") String url) {
		BasicDataSource ds = new BasicDataSource();
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		return ds;
	}
	
	// Ʈ����� ����
	@Bean
	public TransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
