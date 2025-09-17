package top.tbz.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.tbz.entity.UserAccount;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAccountMapperTest {
    @Resource
    private UserAccountMapper userAccountMapper;

    @Test
    void testUserAcount(){
        UserAccount userAccount = userAccountMapper.selectById(1);
        assertEquals("tubenzhuo",userAccount.getUsername());

    }

}