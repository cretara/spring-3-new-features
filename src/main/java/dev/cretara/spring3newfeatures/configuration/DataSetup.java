package dev.cretara.spring3newfeatures.configuration;

import dev.cretara.spring3newfeatures.person.model.Person;
import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSetup implements ApplicationListener<ApplicationReadyEvent> {

    @Lazy
    private final DataGenerator dataGenerator;

    @Lazy
    private final IPersonRepository personRepository;
    
    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        log.debug("applicationReadyEvent {}", applicationReadyEvent);
        if (personRepository.count() == 0) {
            log.warn("No data in database, launching script startup");
            Set<Person> personDataGeneratedSet = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                Person person = dataGenerator.generateFakePerson();
                personDataGeneratedSet.add(person);
            }
            personRepository.saveAll(personDataGeneratedSet);
        }
        log.info("Data present, not injecting starting generate data");
    }
}
