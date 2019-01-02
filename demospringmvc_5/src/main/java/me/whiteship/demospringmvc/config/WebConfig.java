package me.whiteship.demospringmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    - 스프링 웹 MVC 4부 -
    웹 리소스를 커스텀으로 추가적으로 생성하는 것
    그냥 m밑에 hello.html 만들면 /m/hello 요청 안받아짐
    핸들러 추가해야함!!

    /static/hello.html 같은 경우는 application.properties에 코드 추가
*/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")
                .setCachePeriod(20);
    }
}
