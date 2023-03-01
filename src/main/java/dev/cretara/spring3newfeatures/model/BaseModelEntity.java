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
    @Column(nullable = false, updatable = false, columnDefinition = "TIME DEFAULT CURRENT_TIMESTAMP")
    private Instant createdDate;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "TIME DEFAULT CURRENT_TIMESTAMP")
    private Instant lastModifiedDate;
    /**
     * This property reports an indication of the user that requested the initial addition of
     * the entity in the database
     */
    @CreatedBy
    @Column(updatable = false)
    @Nullable
    private String creationUser;
    /**
     * This property reports an indication of the last user that requested an update of this entity
     */
    @Nullable
    @LastModifiedBy
    private String lastModificationUser;

    // base toString that only prints the class name and id - mainly useful as fallback or to include as super with lombok @ToString
    @Override
    public String toString() {
        return getClass().getName() + " [id=" + id + "]";
    }

}