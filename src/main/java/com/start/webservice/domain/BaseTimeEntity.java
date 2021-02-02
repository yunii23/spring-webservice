package com.start.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //jap entity 클래스들이 basetimeentity를 상속할 경우 필드들(createDate, modifiedDate)도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //이 클래스에 auditing 기능 포함시킴
public abstract class BaseTimeEntity {
    @CreatedDate //시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 엔티티 값 변경 시간 자동 저장
    private LocalDateTime modifiedDate;

//    public LocalDateTime getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
}
