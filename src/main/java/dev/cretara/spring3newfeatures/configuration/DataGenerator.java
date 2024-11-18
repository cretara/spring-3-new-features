package dev.cretara.spring3newfeatures.configuration;

import dev.cretara.spring3newfeatures.person.model.Person;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DataGenerator {

    private final Faker faker = new Faker(Locale.ITALY);

    public String generateFakeFiscalCode() {
        return faker.bothify("??????##?##?###?", true);
    }

    public Person generateFakePerson() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return new Person(firstName, lastName, generateFakeFiscalCode());
    }

}
