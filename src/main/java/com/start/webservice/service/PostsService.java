package com.start.webservice.service;

import com.start.webservice.domain.posts.PostsRepository;
import com.start.webservice.dto.posts.PostsMainResponseDto;
import com.start.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    // 서비스 메소드는 entity를 바로 받지 않고, save용 dto인 postssaverequestdto를 받아서 저장함
    // 비즈니스 로직, 트랜잭션 관리는 모두 서비스에서 관리, 뷰와 연동되는 부분은 컨트롤러에서 담당하도록 구성 위함
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId(); //id를 알수있도록 타입은 Long, getId가 반환값
    }

    @Transactional(readOnly = true) //옵션(readOnly = true)을 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new) //실제로는 .map(posts -> new PostsMainResponseDto(posts))
                //repository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsMainResponseDto로 변환 -> List로 반환하는 메소드
                .collect(Collectors.toList());
    }
}
