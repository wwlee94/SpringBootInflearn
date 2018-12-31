package me.whiteship.demospringmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    //원래 public @ResponseBody String hello(){} 써야해
    public String hello(){
        return "hello";
    }

    /*
        - 스프링 웹 MVC 2부 -
        문자열이면 String convertor 사용
        json, 컴포지션타입(객체)이면  json convertor 사용
    @PostMapping("/user")
    public @ResponseBody User create(@RequestBody User user){
        return null;
    }
    */

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }
}
