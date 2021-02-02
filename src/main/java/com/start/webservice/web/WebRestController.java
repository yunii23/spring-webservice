package com.start.webservice.web;

import com.start.webservice.domain.posts.PostsRepository;
import com.start.webservice.dto.posts.PostsSaveRequestDto;
import com.start.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //얘는 ResponseBody를 모든 메소드에서 적용해줌
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;

    @GetMapping("/hello") //주소
    public String hello(){
        return "HelloWorld"; //hello 메소드 결과는 helloworld라는 문자열을 json 형태로 반환
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        //postsRepository.save(dto.toEntity()); 원래 이거였고 service 테스트 거친 후에 아래처럼 수정
        return postsService.save(dto);
    }
}
