package dev.cretara.spring3newfeatures.person.dto;

import dev.cretara.spring3newfeatures.configuration.model.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class PersonDTO extends GenericDTO {

    private String name;

    private String surname;

    private String cf;

}
