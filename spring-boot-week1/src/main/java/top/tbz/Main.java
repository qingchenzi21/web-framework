package top.tbz;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

@RestController @SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//        @GetMapping("/hello")
//        public String index(){
//            return "Hello world";
//        }

        @GetMapping("/strings")
        public List<String> string(){
            return List.of("hello","world");
        }


}