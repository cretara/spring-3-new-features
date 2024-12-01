package dev.cretara.spring3newfeatures.person.model;

import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
public record PersonDto(Long id, String name, String surname, String cf) implements Serializable {
}