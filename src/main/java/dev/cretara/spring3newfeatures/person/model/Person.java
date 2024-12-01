package dev.cretara.spring3newfeatures.person.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "timestamp(6) with time zone default " + "CURRENT_TIMESTAMP")
    private Instant createdDate;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone default " + "CURRENT_TIMESTAMP")
    private Instant lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    @Nullable
    private String creationUser;

    @Nullable
    @LastModifiedBy
    private String lastModificationUser;

    private String name;

    private String surname;

    private String cf;

    public Person(String firstName, String lastName, String cf) {
        this.name = firstName;
        this.surname = lastName;
        this.cf = cf;
    }
}
