package com.hrd.thymeleaf.configuration;



import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("com.hrd.thymeleaf.repository")
public class MyBatisConfiguartion {
	private javax.sql.DataSource dataSource;
	@Autowired
	public MyBatisConfiguartion(DataSource dataSource){
		this.dataSource= dataSource;
	}
	@Bean
	public DataSourceTransactionManager transactionManger(){
		
		return new DataSourceTransactionManager(dataSource);
	
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
				return sessionFactoryBean;
		
	}
}
