package dev.cretara.spring3newfeatures.configuration;

import com.github.javafaker.Faker;
import com.google.common.base.Suppliers;
import dev.cretara.spring3newfeatures.model.Person;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.function.Supplier;

@Component
public class DataGenerator {

    private final Supplier<Faker> fakerSupplier = Suppliers.memoize(this::createFaker);

    private Faker createFaker() {
        return Faker.instance(Locale.ITALY);
    }

    private Faker faker() {
        return fakerSupplier.get();
    }

    private String fakeFiscalCode() {
        return faker().bothify("??????##?##?###?", true);
    }

    public Person generateFakePerson() {
        Faker faker = faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return new Person(firstName, lastName, fakeFiscalCode());
    }

}
