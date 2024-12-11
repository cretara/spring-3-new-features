package dev.cretara.spring3newfeatures.repository;

import dev.cretara.spring3newfeatures.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
