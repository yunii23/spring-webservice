package com.start.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> { //Repository는 디비 레이어 접근자
    //인터페이스 생성 후 JpaRepository<Entity클래스, pk타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성된다

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
