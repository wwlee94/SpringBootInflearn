package me.whiteship.springinit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;


/*
    타입-세이프 프로퍼티
    1. 여러 프로퍼티 묶어서 읽어오기 가능                -> WoowonProperties
    2. 빈으로 등록해서 다른 빈에 주입할 수도 있음
    3. 융통성 있는 바인딩                             -> full-name,full_name -> fullName으로 바인딩해줌
    4. 프로퍼티 타입 컨버젼                            -> 문자열 -> int로 문자+s,m,ms,ns -> Duration 으로 컨버젼 해줌
    5. 프로퍼티 값 검증                               -> 빈 값 있으면 오류 발생하도록
*/
//클래스로 프로퍼티 등록하기
@Component
@ConfigurationProperties("woowon")
@Validated                              //프로퍼티 값 검증
public class WoowonProperties {

    String name;

    int age;

    String fullName;

    //프로퍼티 바인딩 기능이 있어서 properties에 s,m,h,ms등 맞는 타입 써주면 자동 변환 아래 한 줄 필요 X
    //@DurationUnit(ChronoUnit.SECONDS)
    Duration sessionTimeout = Duration.ofSeconds(30);

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
