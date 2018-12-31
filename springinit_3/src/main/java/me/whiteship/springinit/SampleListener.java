package me.whiteship.springinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {

    /*
    //resources에 있는 프로퍼티 설정 가져오는 법
    @Value("${woowon.name}")
    private String name;

    @Value("${woowon.age}")
    private String age;

    @Value("${woowon.fullName}")
    private String fullName;
    */

    //class로 만든 프로퍼티 설정 가져오는 법
    @Autowired
    WoowonProperties woowonProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("=========================");
        System.out.println("Application is Started!!");
        System.out.println(woowonProperties.getName());
        System.out.println(woowonProperties.getAge());
        System.out.println(woowonProperties.getFullName());
        System.out.println(woowonProperties.getSessionTimeout());
        System.out.println("=========================");
    }
}
