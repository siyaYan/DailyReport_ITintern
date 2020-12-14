package com.example.dailyReport.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.example.dailyReport.Mapper.two" , sqlSessionFactoryRef = "targetFactory")
public class TargetConfig {
    @Bean(name = "targetData")
    @ConfigurationProperties(prefix = "spring.datasource.target")
    public DataSource getTarget() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "targetFactory")
    public SqlSessionFactory getTargetFactory(@Qualifier("targetData") DataSource targetData) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(targetData);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:Mapper/two/*.xml")
        );
        return bean.getObject();
    }
}