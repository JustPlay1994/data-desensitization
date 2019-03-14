package com.justplay1994.github.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Package: com.justplay1994.github.config
 * @Project: data-desensitization
 * @Creator: huangzezhou
 * @Create_Date: 2019/3/14 16:43
 * @Updater: huangzezhou
 * @Update_Date: 2019/3/14 16:43
 * @Update_Description: huangzezhou 补充
 * @Description:
 **/
@Configuration
public class MybatisConfig {

    @Bean(name = "dxDataSource") //作为一个bean对象并命名
    @ConfigurationProperties(prefix = "spring.dx") //配置文件中，该数据源的前缀
    @Primary   //用于标记主数据源，除了主数据源外，其余注入文件都不添加该注解
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dxSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dxDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/justplay1994/github/dao/*.xml"));//对应mapper.xml的具体位置
        return bean.getObject();
    }

    @Bean(name = "dxTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("dxDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dxSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("dxSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
