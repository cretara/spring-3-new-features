package dev.cretara.spring3newfeatures.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import java.time.Instant;

@MappedSuperclass
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "timestamp(6) with time zone default " +
            "CURRENT_TIMESTAMP")
    private Instant createdDate;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone default " +
            "CURRENT_TIMESTAMP")
    private Instant lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    @Nullable
    private String creationUser;

    @Nullable
    @LastModifiedBy
    private String lastModificationUser;

    @Override
    public String toString() {
        return getClass().getName() + " [id=" + id + "]";
    }

}