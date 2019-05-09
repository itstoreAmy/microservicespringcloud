package com.emotte.cloud.common.database.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.emotte.cloud.common.database.config.DataSourceConfigEmerp;
import oracle.jdbc.xa.client.OracleXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = {"com.emotte.cloud.app.user.emerp.mapper.*"}, sqlSessionFactoryRef = "sqlSessionFactoryEmerp")
public class DataSourceEmerp {

    @Bean(name = "emerpDataSource")
    @Primary
    public DataSource emerpDataSource(DataSourceConfigEmerp dataSourceConfigEmerp) throws SQLException {
        OracleXADataSource oracleXADataSource = new OracleXADataSource();
        oracleXADataSource.setUser(dataSourceConfigEmerp.getUsername());
        oracleXADataSource.setPassword(dataSourceConfigEmerp.getPassword());
        oracleXADataSource.setURL(dataSourceConfigEmerp.getUrl());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(oracleXADataSource);
        //设置dataSourceCgy数据源的事物 由全局jta事物管理器来管理
        atomikosDataSourceBean.setUniqueResourceName("emerpDataSource");
        atomikosDataSourceBean.setMinPoolSize(dataSourceConfigEmerp.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dataSourceConfigEmerp.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(10000);
        atomikosDataSourceBean.setBorrowConnectionTimeout(dataSourceConfigEmerp.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dataSourceConfigEmerp.getLoginTimeout());
        atomikosDataSourceBean.setTestQuery(dataSourceConfigEmerp.getTestQuery());
        atomikosDataSourceBean.setMaxIdleTime(dataSourceConfigEmerp.getMaxIdleTime());
        return atomikosDataSourceBean;
    }

    @Bean(name="sqlSessionFactoryEmerp")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("emerpDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name="sqlSessionTemplateEmerp")
    @Primary
    public SqlSessionTemplate getSQSessionTemplate(@Qualifier("sqlSessionFactoryEmerp") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
