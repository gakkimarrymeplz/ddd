package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @title: TestHash
 * @projectName SpringDataRedisDemo
 * @description: TODO
 * @date 2019/5/270:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存入值
     */
    @Test
    public void testSetValue() {
        redisTemplate.boundHashOps("nameHash").put("a","新垣结衣");
        redisTemplate.boundHashOps("nameHash").put("b","石原里美");
        redisTemplate.boundHashOps("nameHash").put("c","花泽香菜");
    }

    /**
     * 提取所有的Key
     */
    @Test
    public void testGetAllKey() {
        Set set = redisTemplate.boundHashOps("nameHash").keys();
        System.out.println(set);
    }

    /**
     * 提取所有的值
     */
    @Test
    public void testGetAllValues() {
        List values = redisTemplate.boundHashOps("nameHash").values();
        System.out.println(values);
    }

    /**
     * 根据key获取值
     */
    @Test
    public void testGetValueByKey() {
        String s = (String) redisTemplate.boundHashOps("nameHash").get("b");
        System.out.println(s);
    }

    /**
     * 根据key移除值
     */
    @Test
    public void testDeleteValueByKey() {
        redisTemplate.boundHashOps("nameHash").delete("a");
    }


}
