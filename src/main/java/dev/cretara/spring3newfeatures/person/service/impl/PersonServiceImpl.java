package dev.cretara.spring3newfeatures.person.service.impl;

import dev.cretara.spring3newfeatures.person.dto.mapper.PersonMapper;
import dev.cretara.spring3newfeatures.person.model.PersonDto;
import dev.cretara.spring3newfeatures.person.service.IPersonService;
import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements IPersonService {

    @Lazy
    private final IPersonRepository personRepository;

    @Lazy
    private final PersonMapper personMapper;

    @Override
    public List<PersonDto> getAllPerson() {
        return personRepository
                .findAll()
                .stream()
                .map(personMapper::toDto)
                .toList();
    }
}
