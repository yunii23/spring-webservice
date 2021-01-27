package com.start.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가, 괄호내용은 기본 생성자 접근 제한을 프로텍티드로 한다
                                                    // 엔티티 클래스를 프로젝트 코드상에서 기본 생성자로 생성하는 것은 막되, jap에서 엔티티 클래스를 생성하는 것은 허용하기 위해 추가
@Getter //클래스 내 모든 필드의 getter 메소드를 자동 생성
@Entity //테이블과 링크 될 클래스임
public class Posts {
    // 포스트 클래스는 실제 db의 테이블과 매칭될 클래스. 엔티티 클래스임
    // JAP를 사용하기 때문에 db 데이터에 작업할 경우 실제 쿼리를 날리기 보다는 엔티티 클래스의 수정을 통해 작업

    @Id //해당 테이블의 pk 필드, 웬만하면 Long 타입의 ai 추천, mysql은 bigint
    @GeneratedValue //pk 생성 규칙, ai임
    private Long id;

    @Column(length = 500, nullable = false) // 굳이 작성하지 않아도 다 컬럼인데, 작성하는 경우는 수정하고 싶을 때(기본값 문자열 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    public static void main(String[] args) {

    }

    @Builder //해당 클래스의 빌더패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함함
            // 생성자 대신 빌더 클래스 아용함
    public Posts(String  title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
