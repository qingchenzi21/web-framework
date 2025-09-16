package top.tbz.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tbz.config.model.Team;

@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamController {
    @PostMapping("add")
    public Team createTeam(@RequestBody Team team){
        log.info("team:{}",team);
        return team;
    }
}
