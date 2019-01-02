package me.whiteship.springboothateoas;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class SampleController {

    /*
        스프링 웹 MVC - 10부 : HATEOAS
     */
    @GetMapping("/hello")
    public Resource<Hello> hello(){
        Hello hello = new Hello();
        hello.setPrefix("Hey, ");
        hello.setName("keesun");

        //링크 정보 추가하기
        Resource<Hello> resource = new Resource<>(hello);
        //SampleController 의 hello() 메소드를 링크를 따서 SelfRel에 추가함
        resource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

        //Result _links에 연관 값이 들어감!
        // {"prefix":"Hey, ","name":"keesun","_links":{"self":{"href":"http://localhost/hello"}}}

        return resource;
    }

    /*
           스프링 웹 MVC - 11부 : CORS
           @Rest API -> localhost:8080 지원
           @Rest API를 localhost:18080 어플리케이션이 호출한다! -> 안됩니다 >_0
     */


}
