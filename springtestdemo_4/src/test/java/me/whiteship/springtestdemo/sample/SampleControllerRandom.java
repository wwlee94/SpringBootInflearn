package me.whiteship.springtestdemo.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//SpringBootTest -> 메인@SpringBootApplication 찾아서 모든 빈 스캔 다함
// -> 테스트용 ApplicationContext를 만들고 다 빈으로 등록 해주고
// -> MockBean 찾아서 빈 교체
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)     //내장 톰캣 사용함 - 비어있는 포트에
public class SampleControllerRandom {

    @Autowired
    WebTestClient webTestClient;

    //SampleService 에 있던 빈을 여기서 MockBean으로 교체함
    //모든 @Test마다 자동으로 리셋
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception{
        //mocking?
        when(mockSampleService.getName()).thenReturn("whiteship");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello whiteship");

    }
}
