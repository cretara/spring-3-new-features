package dev.cretara.spring3newfeatures.person.service;

import dev.cretara.spring3newfeatures.person.model.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getAllPerson();
}
