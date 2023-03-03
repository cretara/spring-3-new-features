package dev.cretara.spring3newfeatures.person.service;

import dev.cretara.spring3newfeatures.person.dto.PersonDTO;

import java.util.List;

public interface IPersonService {
    List<PersonDTO> getAllPerson();
}
