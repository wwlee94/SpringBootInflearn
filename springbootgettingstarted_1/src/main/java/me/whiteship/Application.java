package me.whiteship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//maven으로 생성한 @SpringBootApplication 이다.
//다른 방법: https://start.spring.io 에서 Spring Initializr 사용 가능 !!

/*
//@SpringBootApplication 안에 들어있는 @(애노테이션)
@SpringBootConfiguration
@ComponentScan                //1. @Compoenent를 가진 class들을 스캔해서 bean으로 등록
@EnableAutoConfiguration      //2. 추가적으로 읽어온 bean들을 추가 등록 (컨벤션들 -> auto 기본 설정)
*/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }


    // 그냥 여기서 빈을 새로 생성하면 덮어 씌워짐!!
     /*
    // 덮어 쓰기 방지 방법: @ContitionalOnMissingBean을 받아온 프로젝트 빈에 추가해주면
    //(WhiteShip)빈이 이미 있어 빈을 만들지 않고 넘어감
    @Bean
    public Holoman holoman(){
        Holoman holoman = new Holoman();
        holoman.setHowLong(60);
        holoman.setName("WhiteShip");
        return holoman;
    }
     */
     /*
        프로퍼티 자동 설정 방법 : application.properties 사용
        개발하는 프로젝트에서 application.properties 에 값만 적용해주면
        빈을 받아오는 프로젝트에서 ConfigurationProperties("holoman") 설정하면
        프로퍼티 값 자동 완성
     */
}
