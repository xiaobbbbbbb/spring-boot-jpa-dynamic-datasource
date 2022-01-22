package cc.fxea.test.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * PlatformConfiguration
 *
 * @author: niko
 * @date: 2022/1/18 16:38
 */
@Configuration
@EnableTransactionManagement(
    proxyTargetClass = true
)
@Import({DataSourceConfig.class})
public class PlatformConfiguration {
    public PlatformConfiguration() {
    }
    @Autowired
    JpaProperties jpaProperties;
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory(
//        DataSource dataSource) throws SQLException, IOException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        Properties properties = new Properties();
//        properties.setProperty("sqlType", "mysql");
//        sqlSessionFactoryBean.setConfigurationProperties(properties);
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new PaginationInterception()});
//        return sqlSessionFactoryBean;
//    }

//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        System.out.println("datasource>>>>>>>>>>>>>>>>>>>>>>>>>>"+dataSource.getClass());
//
//        return new DataSourceTransactionManager(dataSource);
//    }
    @Bean
    public Object testBean(PlatformTransactionManager transactionManager){
        System.out.println("transactionManager>>>>>>>>>>>>>>>>>>>>>>>>>>"+transactionManager.getClass());
        return new Object();
    }
}

