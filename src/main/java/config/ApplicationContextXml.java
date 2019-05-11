package config;

import com.github.pagehelper.PageInterceptor;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.sql.DataSource;
import java.io.FileReader;
import java.util.Locale;
import java.util.Properties;

@Configuration
@ComponentScan(value = {"pub.hqs.service", "pub.hqs.dao"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})
@EnableTransactionManagement
public class ApplicationContextXml implements TransactionManagementConfigurer {
    private DataSource dataSource = null;

    /**
     * 配置数据库
     */
    @Bean(name = "dataSource")
    public DataSource initDataSource() {
        if (dataSource != null)
            return dataSource;

        Properties props = getProperties("jdbc.properties");
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 配置 SqlSessionFactoryBean
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean initSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(initDataSource());
        //读取classpath下的资源文件
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactory.setConfigLocation(resource);
        sqlSessionFactory.setPlugins(new Interceptor[]{initPageInterceptor()});
        return sqlSessionFactory;
    }

    /**
     * 通过自动扫描，发现mapper 接口
     */
    @Bean()
    public MapperScannerConfigurer initMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("pub.hqs.*");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
        msc.setAnnotationClass(Repository.class);
        return msc;
    }

    /**
     * 实现接口方法，注册注解事物，当@Transactional使用时产生数据库事物
     *
     * @Param:
     * @return: PlatformTransactionManager
     * @Author: hqs.pub
     * @Date: 2019/5/4
     */
    @Override
    @Bean(name = "annotationDrivenTransactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }

    /**
     * 初始化分页插件
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/4
     */
    public PageInterceptor initPageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties props = getProperties("page.properties");
        pageInterceptor.setProperties(props);
        return pageInterceptor;
    }

    /**
     * cookie设置
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    @Bean
    public LocaleResolver initCookieLocaleResolver() {
        CookieLocaleResolver cookie = new CookieLocaleResolver();
        cookie.setCookieName("hqs-cookie");
        cookie.setCookieMaxAge(1000);
        cookie.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return cookie;
    }

    /**
     * 获取classpath下的文件内容
     *
     * @Param: filename classpath下的文件路径
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/4
     */
    private Properties getProperties(String filename) {
        Properties props = new Properties();
        try {
            Resource resource = new ClassPathResource(filename);
            props.load(new FileReader(resource.getFile()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
