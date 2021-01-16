package com.jiang.localspringbootdemo.config.datasource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by jiang on 2018/4/9.
 */
@Configuration
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDataSourceConfig implements TransactionManagementConfigurer {
    /**
     * 精确到 mysql 目录,以便跟其他数据源隔离
     */
    static final String PACKAGE = "com.jiang.localspringbootdemo.mapper";
    /**
     * 扫描 Mapper 接口并容器管理
     */
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    static final String ENTITY_PACKAGE="com.jiang.localspringbootdemo.entity";

    @Resource
    private DataSource dataSource;

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory( DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MysqlDataSourceConfig.MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage(ENTITY_PACKAGE);
        return sessionFactory.getObject();
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
       return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "batchSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory){
      return new SqlSessionTemplate(sqlSessionFactory,ExecutorType.REUSE);
    }
}
