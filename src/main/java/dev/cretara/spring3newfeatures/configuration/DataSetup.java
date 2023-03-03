package dev.cretara.spring3newfeatures.configuration;

import dev.cretara.spring3newfeatures.person.model.Person;
import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSetup implements ApplicationRunner {

    @Lazy
    private final DataGenerator dataGenerator;

    @Lazy
    private final IPersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (personRepository.count() == 0) {
            log.warn("No data in database, launching script startup");
            Set<Person> personDataGeneratedSet = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                Person person = dataGenerator.generateFakePerson();
                personDataGeneratedSet.add(person);
            }
            personRepository.saveAll(personDataGeneratedSet);
        }
        log.info("Data present, not data");
    }
}
