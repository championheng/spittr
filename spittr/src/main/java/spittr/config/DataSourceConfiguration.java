package spittr.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ResourceBundle;

/**
 * Created by hg_yi on 17-11-2.
 */
@Configuration
public class DataSourceConfiguration {
    private static String URL;
    private static String USERNAME;
    private static String PASSWD;
    private static String Driver;

    //加载配置文件
    private static ResourceBundle rb = ResourceBundle.getBundle("db-config");

    //静态代码块在加载类时只执行一次
    static {
        URL = rb.getString("jdbc.URL");
        USERNAME = rb.getString("jdbc.USERNAME");
        PASSWD = rb.getString("jdbc.PASSWD");
        Driver = rb.getString("jdbc.Driver");
    }

//    @Profile("development")
//    @Bean
//    public DataSource embeddedDataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//                .build();
//    }

//    @Profile("qa")
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(Driver);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWD);
        dataSource.setInitialSize(5);
        dataSource.setMaxIdle(10);

        return dataSource;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//    @Profile("production")
//    @Bean
//    public DataSource dataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/spittr");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//
//        return (DataSource) jndiObjectFactoryBean.getObject();
//    }
}
