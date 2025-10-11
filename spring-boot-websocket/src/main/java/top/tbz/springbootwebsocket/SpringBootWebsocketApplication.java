package top.tbz.springbootwebsocket;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWebsocketApplication {

    public static void main(String[] args) {

        org.springframework.boot.SpringApplication.run(SpringBootWebsocketApplication.class, args);
    }

}
