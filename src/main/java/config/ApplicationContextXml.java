package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import javax.xml.ws.Service;
import java.util.Properties;

@Configuration
/*@ComponentScan(basePackages = {"example"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})*/
@ComponentScan(basePackages = {"example"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
/*@EnableTransactionManagement*/
public class ApplicationContextXml {
    private DataSource dataSource = null;

    @Bean(name = "dataSource")
    public DataSource initDataSource() {
        if (dataSource != null)
            return dataSource;

        Properties props = new Properties();
        props.setProperty("driverClassName", "com.sql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://t.cn/ssm?useUnicode=true&characterEncoding=utf8");
        props.setProperty("username", "root");
        props.setProperty("password", "123456");
        props.setProperty("maxActive", "200");   //最大连接数
        props.setProperty("maxIdle", "20");      //最大
        props.setProperty("maxWait", "30000");   //最大等待
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }
}
