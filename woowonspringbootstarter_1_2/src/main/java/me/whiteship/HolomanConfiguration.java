package me.whiteship;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* spring-factories에 해당 configuration을 등록한 후
   install하면 local maven 저장소에다가 빌드한 것을 저장함
   즉, 다른 프로젝트에서 가져다가 쓸 수 있다.
 */
@Configuration
@EnableConfigurationProperties(HolomanProperties.class)         //HolomanProperties클래스에서 등록한 것 가져옴
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean       //이 타입의 빈이 있다면 등록 하지 않겠다!.
    public Holoman holoman(HolomanProperties properties){
        Holoman holoman = new Holoman();
        holoman.setHowLong(properties.getHowLong());
        holoman.setName(properties.getName());
        return holoman;
    }
}
