package me.whiteship.springinit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//파일의 내용을 properties에 추가하기 위한 것
@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest
public class SpringinitApplicationTests {

    @Autowired
    Environment environment;

    @Test
    public void contextLoads() {
        //무슨 역할?
        assertThat(environment.getProperty("woowon.name"))
                    .isEqualTo("Woowon2");
    }

}

