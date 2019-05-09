package com.emotte.cloud.common.database.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.emotte.cloud.common.database.config.DataSourceConfigEmotte;
import oracle.jdbc.xa.client.OracleXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = {"com.emotte.cloud.app.user.emotte.mapper.*"}, sqlSessionFactoryRef = "sqlSessionFactoryEmotte")
public class DataSourceEmotte {

    @Bean(name = "emotteDataSource")
    public DataSource emotteDataSource(DataSourceConfigEmotte dataSourceConfigEmotte) throws SQLException {
        OracleXADataSource oracleXADataSource = new OracleXADataSource();
        oracleXADataSource.setUser(dataSourceConfigEmotte.getUsername());
        oracleXADataSource.setPassword(dataSourceConfigEmotte.getPassword());
        oracleXADataSource.setURL(dataSourceConfigEmotte.getUrl());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(oracleXADataSource);
        //设置dataSourceCgy数据源的事物 由全局jta事物管理器来管理
        atomikosDataSourceBean.setUniqueResourceName("emotteDataSource");
        atomikosDataSourceBean.setMinPoolSize(dataSourceConfigEmotte.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dataSourceConfigEmotte.getMaxPoolSize());
        atomikosDataSourceBean.setBorrowConnectionTimeout(dataSourceConfigEmotte.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dataSourceConfigEmotte.getLoginTimeout());
        atomikosDataSourceBean.setMaxLifetime(10000);
        atomikosDataSourceBean.setTestQuery(dataSourceConfigEmotte.getTestQuery());
        atomikosDataSourceBean.setMaxIdleTime(dataSourceConfigEmotte.getMaxIdleTime());
        return atomikosDataSourceBean;
    }

    @Bean(name = "sqlSessionFactoryEmotte")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("emotteDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplateEmotte")
    public SqlSessionTemplate getSQSessionTemplate(@Qualifier("sqlSessionFactoryEmotte") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
