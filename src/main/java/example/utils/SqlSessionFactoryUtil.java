package example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private final static Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryUtil(){}

    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if(sqlSessionFactory != null)
                return sqlSessionFactory;

            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try{
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException ex){
                ex.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }
}
