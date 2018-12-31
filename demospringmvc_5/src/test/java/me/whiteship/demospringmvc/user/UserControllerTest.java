package me.whiteship.demospringmvc.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    //- 스프링 웹 MVC 2부 -
    //WebMvcTest를 사용하면 의존성 주입해줌
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }


    /*
        - 스프링 웹 MVC 3부 -
        accept(MediaType.APPLICATION_XML) 로 받는 타입은 XML로 설정해도
        핸들러코드(UserController)에서 어쩔땐 이렇게 저렇게 안해도
        XML메시지 컨버터 dependency를 추가하면
        Spring WebMvc의 viewResolver가 알아서 다 처리해줌!!
     */

    //JSON
    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"keesun\",\"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",
                        is(equalTo("keesun"))))
                .andExpect(jsonPath("$.password",
                        is(equalTo("123"))));
    }

    //XML로 내보내려면,받으려면 XML 메시지 컨버터 dependency 추가해야함
    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"keesun\",\"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username")
                        .string("keesun"))
                .andExpect(xpath("/User/password")
                        .string("123"));
    }

}
