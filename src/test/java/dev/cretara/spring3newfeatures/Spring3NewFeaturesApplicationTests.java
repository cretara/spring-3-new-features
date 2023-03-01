package dev.cretara.spring3newfeatures;

import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring3NewFeaturesApplicationTests {

    @Autowired
    private IPersonRepository personRepository;

    @Test
    @DisplayName("Person fetched not empty")
    void whenFetchingPerson_ThenNotEmpty() {
        Assertions.assertNotNull(personRepository.findAll());
    }

}
