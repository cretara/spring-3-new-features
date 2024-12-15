package dev.cretara.spring3newfeatures.service;

import dev.cretara.spring3newfeatures.configuration.DataGenerator;
import dev.cretara.spring3newfeatures.person.dto.mapper.PersonMapper;
import dev.cretara.spring3newfeatures.person.model.Person;
import dev.cretara.spring3newfeatures.person.model.PersonDto;
import dev.cretara.spring3newfeatures.person.service.impl.PersonServiceImpl;
import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private IPersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    private DataGenerator dataGenerator;

    @BeforeEach
    void setUp() {
        dataGenerator = new DataGenerator();
    }

    @Test
    @DisplayName("Given PersonRepository when get all person then return personDto list")
    void givenPersonRepository_whenGetAllPerson_thenReturnPersonDtoList() {
        // given
        Person firstPersonMocked = dataGenerator.generateFakePerson();
        Person secondPersonMocked = dataGenerator.generateFakePerson();
        List<Person> personListMocked = List.of(firstPersonMocked, secondPersonMocked);
        given(personRepository.findAll()).willReturn(personListMocked);

        PersonDto firstPersonDtoMocked = new PersonDto(1L, firstPersonMocked.getName(), firstPersonMocked.getSurname(), firstPersonMocked.getCf());
        PersonDto secondPersonDtoMocked = new PersonDto(2L, secondPersonMocked.getName(), secondPersonMocked.getSurname(), secondPersonMocked.getCf());
        given(personMapper.toDto(firstPersonMocked)).willReturn(firstPersonDtoMocked);
        given(personMapper.toDto(secondPersonMocked)).willReturn(secondPersonDtoMocked);

        // when
        List<PersonDto> personDtoListReturnedByService = personService.getAllPerson();

        // then
        assertThat(personDtoListReturnedByService)
                .isNotEmpty()
                .hasSameSizeAs(personListMocked);
    }
}
