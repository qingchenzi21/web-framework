package top.tbz.config.model;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TeamTest {

    @Resource
    private Team team;

    @Test
    void testTeam() {
        log.info("111111111");
        log.info(String.valueOf(team));
        assertEquals("web2班",team.getName());
        assertEquals("tbz",team.getLeader());
    }
}