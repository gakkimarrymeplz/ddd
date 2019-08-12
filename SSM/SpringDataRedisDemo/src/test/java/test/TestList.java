package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Administrator
 * @title: TestList
 * @projectName SpringDataRedisDemo
 * @description: TODO
 * @date 2019/5/2623:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 右压栈：后添加的对象排在后边
     */
    @Test
    public void testSetValue1() {
        redisTemplate.boundListOps("nameList1").rightPush("何妮");
        redisTemplate.boundListOps("nameList1").rightPush("爱");
        redisTemplate.boundListOps("nameList1").rightPush("祝茂华");

    }

    /**
     * 显示右压栈集合
     */
    @Test
    public void testGetValue1() {
        List list = redisTemplate.boundListOps("nameList1").range(0, 10);
        System.out.println(list);


    }

    /**
     * 左压栈：后添加的对象排在前边
     */
    @Test
    public void testSetValue2() {
        redisTemplate.boundListOps("nameList2").leftPush("何妮");
        redisTemplate.boundListOps("nameList2").leftPush("爱");
        redisTemplate.boundListOps("nameList2").leftPush("祝茂华");


    }

    /**
     * 显示右压栈集合
     */
    @Test
    public void testGetValue2() {
        List list = redisTemplate.boundListOps("nameList2").range(0, 10);
        System.out.println(list);


    }

    /**
     * 查询某个元素
     */
    @Test
    public void testSearchByIndex() {
        String s = (String)redisTemplate.boundListOps("nameList1").index(1);
        System.out.println(s);
    }

    /**
     * 根据索引删除
     */
    @Test
    public void testRomoveByIndex() {
        redisTemplate.boundListOps("nameList1").remove(1,"爱");
    }

    /**
     * 删除集合中的所有值
     */
    @Test
    public void testRomoveAll() {
        redisTemplate.delete("nameList2");
    }


}
