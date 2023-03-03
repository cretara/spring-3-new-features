package dev.cretara.spring3newfeatures.person.service.impl;

import dev.cretara.spring3newfeatures.person.dto.PersonDTO;
import dev.cretara.spring3newfeatures.person.service.IPersonService;
import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public class PersonServiceImpl implements IPersonService {

    @Lazy
    private final IPersonRepository personRepository;
    @Override
    public List<PersonDTO> getAllPerson() {
        return personRepository
                .findAll()
                .iterator();
    }
}
