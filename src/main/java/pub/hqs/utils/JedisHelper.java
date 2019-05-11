package pub.hqs.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: JavaSample
 * @description: redis
 * @author: hqs.pub
 * @create: 2019-05-11 15:24
 **/
public class JedisHelper {

    private final static Class<JedisHelper> LOCK = JedisHelper.class;

    private static Jedis jedis = null;

    private JedisHelper() {
    }

    public static Jedis instance() {
        synchronized (LOCK) {
            if (jedis != null)
                return jedis;

            JedisPoolConfig config = new JedisPoolConfig();
            JedisPool pool = new JedisPool(config, "t.cn", 6379);
            jedis = pool.getResource();
            return jedis;
        }
    }

    /**
     * 存入
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static void set(String key, Object value) {
        String str = JsonHelper.obj2String(value);
        instance().set(key, str);
    }

    /**
     * 设置过期时间
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static void set(String key, Object value, int seconds) {
        String str = JsonHelper.obj2String(value);
        instance().set(key, str);
        instance().expire(key, seconds);
    }

    /**
     * 取出对象
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static <T> T get(String key, Class<T> clazz) {
        Boolean exist = instance().exists(key);
        if (!exist)
            return null;

        String value = instance().get(key);
        return JsonHelper.string2Obj(value, clazz);
    }

    /**
     * 取出list集合
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static <T> T get(String key, TypeReference typeReference) {
        Boolean exist = instance().exists(key);
        if (!exist)
            return null;

        String value = instance().get(key);
        return JsonHelper.string2Obj(value, typeReference);
    }

    /**
     * 删除key
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static void del(String key) {
        instance().del(key);
    }

    /**
     * 存入list
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static void lpush(String key, Object value) {
        String str = JsonHelper.obj2String(value);
        instance().lpush(key, str);
    }

    /**
     * 获取list
     *
     * @Param:
     * @return:
     * @Author: hqs.pub
     * @Date: 2019/5/11
     */
    public static List<String> lrange(String key, int start, int stop) {
        Boolean exist = instance().exists(key);
        if (!exist)
            return null;

        List<String> values = instance().lrange(key, start, stop);
        return values;
    }
}
