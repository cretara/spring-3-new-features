package dev.cretara.spring3newfeatures.configuration;

import dev.cretara.spring3newfeatures.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSetup implements ApplicationRunner {

    @Lazy
    private final IPersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (personRepository.count() == 0) {
            log.warn("No data in database, launching script startup");
            //TODO: add sql init database
        }
        log.info("Data present, not creating schema and data");
    }
}
