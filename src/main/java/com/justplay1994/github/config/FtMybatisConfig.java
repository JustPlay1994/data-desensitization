package com.justplay1994.github.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.justplay1994.github.dao.ft")
public class FtMybatisConfig {

    @Bean(name = "ftDataSource") //作为一个bean对象并命名
    @ConfigurationProperties(prefix = "spring.ft") //配置文件中，该数据源的前缀
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ftSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("ftDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/justplay1994/github/dao/ft/*.xml"));//对应mapper.xml的具体位置
        return bean.getObject();
    }

    @Bean(name = "ftTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("ftDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ftSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("ftSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
