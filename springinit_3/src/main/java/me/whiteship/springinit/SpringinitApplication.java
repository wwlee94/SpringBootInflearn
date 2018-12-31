package me.whiteship.springinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringinitApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringinitApplication.class);
        /*
           ApplicationStartingEvent는 빈을 등록하기 전에 나오는 이벤트로
           SpringApplication에 이벤트리스너를 따로 등록해야 처리 가능 (이때는 리스너를 빈으로 안만들어도 됨)
           //app.addListeners(new SampleListener());
        */
        app.run(args);
    }

}

