package top.tbz1;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class RedisApplicationTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test(){
        stringRedisTemplate.opsForValue().set("key","123",60, TimeUnit.SECONDS);
    }

}