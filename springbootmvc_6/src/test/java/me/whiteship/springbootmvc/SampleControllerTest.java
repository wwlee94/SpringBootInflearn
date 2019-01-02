package me.whiteship.springbootmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    //MockMVC -> 가짜 서블릿 컨테이너!
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        // 요청 "/hello"
        // 응답
        // -모델 name : keesun
        // - 뷰 이름 : hello
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name",is("keesun")))
                .andExpect(content().string(containsString("keesun")));

        /*
            Thymeleaf를 써서 랜더링 된 실행 결과를 확인 가능(hello.html)
            예전 JSP를 사용 했을 땐 본문 결과를 확인하는게 어려움
            랜더링 자체를 서블릿 엔진이 만들어야만 View를 확인 할 수 있는거라서
            근데 Thymeleaf는 독자적으로 서블릿 개입 없이 만들어서 확인 가능

            기존 jsp를 사용하는 방법은 if를 쓰기위해 jsp전용 태그도 붙여야하고 html 마크업 language 틀을 깸
            Thymeleaf (동적 뷰) -> 속성으로 값을 줌 틀을 깨지 않고 편해서 쓴다.

            //이러한 결과정보
             Body = <!DOCTYPE html>
            <html lang="en">
            <head>
            <title>Title</title>
            </head>
            <body></body>
            </html>
         */
    }
}