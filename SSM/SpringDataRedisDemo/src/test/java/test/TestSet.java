package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author Administrator
 * @title: TestSet
 * @projectName SpringDataRedisDemo
 * @description: TODO
 * @date 2019/5/2623:35
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestSet {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存入值
     */
    @Test
    public void setValue() {
       redisTemplate.boundSetOps("nameset").add("庄耀");
       redisTemplate.boundSetOps("nameset").add("家宝");
       redisTemplate.boundSetOps("nameset").add("包柯");
    }

    /**
     * 提取值
     */
    @Test
    public void getValue() {
        Set members = redisTemplate.boundSetOps("nameset").members();
        System.out.println(members);
    }

    /**
     * 删除集合中的某一个值
     */
    @Test
    public void deleteValue() {
         redisTemplate.boundSetOps("nameset").remove("包柯");

    }

    /**
     * 删除集合中的所有值
     */
    @Test
    public void deleteAllValue() {
        redisTemplate.delete("nameset");

    }
}
