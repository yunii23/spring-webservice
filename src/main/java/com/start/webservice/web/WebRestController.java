package com.start.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //얘는 ResponseBody를 모든 메소드에서 적용해줌
public class WebRestController {

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld"; //hello 메소드 결과는 helloworld라는 문자열을 json 형태로 반환
    }
}
