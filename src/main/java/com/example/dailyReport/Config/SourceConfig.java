package com.example.dailyReport.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 *
 * @Params: mapper1
 * @Author: Siya(Xiran) Yan
 * @Date: 11:14 14/12/20
 */
@Configuration
@MapperScan(basePackages = "com.example.dailyReport.Mapper.one", sqlSessionFactoryRef = "oneSqlSessionFactory")
public class SourceConfig {
    @Bean(name = "DataOneSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.source")
    public DataSource getDateSourceOne() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oneSqlSessionFactory")
    @Primary
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("DataOneSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:Mapper/one/*.xml"));
        return bean.getObject();
    }
}
