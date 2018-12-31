package me.whiteship.springinit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
//argument 찍기 위한 Listener + ApplicationRunner TEST
public class ArgumentListener implements ApplicationRunner {

    /*
    //어떤 빈에 생성자가 하나고 그 생성자의 파라미터가 빈이라면 스프링이 의존성 자동으로 주입!!
    //jvm으로 들어온 args는 못 받음
    public ArgumentListener(ApplicationArguments arguments){
        System.out.println("foo: "+arguments.containsOption("foo"));
        System.out.println("bar: "+arguments.containsOption("bar"));
    }
    */

    private Logger logger = LoggerFactory.getLogger(ArgumentListener.class);

    @Autowired
    private WoowonProperties woowonProperties;

    //ApplicationRunner 에플리케이션 실행 한 뒤에 이벤트 만들고 싶을 때
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo: "+args.containsOption("foo"));
        System.out.println("bar: "+args.containsOption("bar"));

        logger.debug("=========================");
        logger.debug("로깅 디버그");
        logger.debug(woowonProperties.getName());
        logger.debug(woowonProperties.getFullName());
        logger.debug("=========================");
    }
}
