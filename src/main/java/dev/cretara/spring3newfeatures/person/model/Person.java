package dev.cretara.spring3newfeatures.person.model;

import dev.cretara.spring3newfeatures.configuration.model.BaseModelEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Person extends BaseModelEntity {

    private String name;

    private String surname;

    private String cf;

}
