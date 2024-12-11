package dev.cretara.spring3newfeatures.repository;

import dev.cretara.spring3newfeatures.person.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class IPersonRepositoryTest {

    @Autowired
    private IPersonRepository personRepository;

    @Test
    void givenPersonObject_whenSave_thenReturnSavedPerson() {
        Person person = new Person("Mario", "Rossi", "RSSMRA80A01H501A");
        Person savedPerson = personRepository.save(person);
        assertThat(savedPerson).isNotNull();
        assertThat(savedPerson.getId()).isPositive();
    }

}