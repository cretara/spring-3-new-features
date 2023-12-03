package dev.cretara.spring3newfeatures.repository;

import dev.cretara.spring3newfeatures.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {
}
