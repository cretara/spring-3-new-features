package dev.cretara.spring3newfeatures.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person extends BaseModelEntity {

    private String name;

    private String surname;

}