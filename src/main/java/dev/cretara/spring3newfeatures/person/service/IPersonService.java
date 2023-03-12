package dev.cretara.spring3newfeatures.person.service;

import dev.cretara.spring3newfeatures.person.model.Person;

import java.util.Iterator;

public interface IPersonService {
    Iterator<Person> getAllPerson();
}
