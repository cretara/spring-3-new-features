package dev.cretara.spring3newfeatures.repository;

import dev.cretara.spring3newfeatures.person.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long> {
}
