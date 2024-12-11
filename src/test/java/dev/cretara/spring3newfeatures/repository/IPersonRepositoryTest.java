package dev.cretara.spring3newfeatures.repository;

import dev.cretara.spring3newfeatures.person.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class IPersonRepositoryTest {

    @Autowired
    private IPersonRepository personRepository;

    @Test
    @DisplayName("Given a Person object, when save, then return saved Person")
    void givenPersonObject_whenSave_thenReturnSavedPerson() {
        Person person = new Person("Mario", "Rossi", "RSSMRA80A01H501A");
        Person savedPerson = personRepository.save(person);
        assertThat(savedPerson).isNotNull();
        assertThat(savedPerson.getId()).isPositive();
    }

    @Test
    @DisplayName("Given a Person object, when save and retrieve, then return saved Person")
    void givenPersonObject_whenSaveAndRetrieve_thenReturnSavedPerson() {
        Person person = new Person("Mario", "Rossi", "RSSMRA80A01H501A");
        Person savedPerson = personRepository.save(person);
        Person retrievedPerson = personRepository.findById(savedPerson.getId()).orElse(null);
        assertThat(retrievedPerson).isNotNull();
        assertThat(retrievedPerson.getId()).isEqualTo(savedPerson.getId());
    }

    @Test
    @DisplayName("Given a Person object, when save and delete, then Person not found")
    void givenPersonObject_whenSaveAndDelete_thenPersonNotFound() {
        Person person = new Person("Mario", "Rossi", "RSSMRA80A01H501A");
        Person savedPerson = personRepository.save(person);
        personRepository.delete(savedPerson);
        Person retrievedPerson = personRepository.findById(savedPerson.getId()).orElse(null);
        assertThat(retrievedPerson).isNull();
    }

    @Test
    @DisplayName("Given a list of Person objects, when save all, then return all saved Persons")
    void givenPersonList_whenFindAll_thenReturnAllPersons() {
        Person person1 = new Person("Mario", "Rossi", "RSSMRA80A01H501A");
        Person person2 = new Person("Luigi", "Verdi", "VRDLGU80A01H501A");
        List<Person> personToSaveList = List.of(person1, person2);
        List<Person> personSavedList = personRepository.saveAll(personToSaveList);
        assertThat(personSavedList)
                .isNotNull()
                .hasSize(personToSaveList.size());
    }

}