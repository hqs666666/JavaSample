package config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
     <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>/WEB-INF/applicationContext.xml</param-value>
     </context-param>
     <listener>
         <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     </listener>
      */

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[] {ApplicationContextXml.class};
    }

    /*
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <!--配置dispatcher.xml作为mvc的配置文件-->
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>
     */

    @Override

    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[] {DispatcherServletXml.class};
    }

    /*
    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
     */

    @Override
    protected String[] getServletMappings(){
        return new String[] {"/"};
    }

    /*
    解决中文乱码
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    */

    /*初始化器*/
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        super.onStartup(servletContext);
        servletContext.addFilter("name",new CharacterEncodingFilter("UTF-8",true))
                .addMappingForUrlPatterns(null,false,"/*");
    }
}

