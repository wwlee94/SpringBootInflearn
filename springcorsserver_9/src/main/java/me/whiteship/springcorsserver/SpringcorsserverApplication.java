package me.whiteship.springcorsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringcorsserverApplication {

    //18080포트에서 리소스 사용하도록 허용하겠다.
    //or -> Class 하나 생성해서 @configuration으로 WebMvcConfigurer의 addCorsMappings메소드 이용
    @CrossOrigin(origins = "http://localhost:18080")

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcorsserverApplication.class, args);
    }

}

