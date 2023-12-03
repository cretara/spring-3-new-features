package dev.cretara.spring3newfeatures.person.controller;

import dev.cretara.spring3newfeatures.person.model.Person;
import dev.cretara.spring3newfeatures.person.service.IPersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
@Slf4j
public class PersonRestController {

    @Lazy
    private final IPersonService personService;

    @GetMapping("/")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

}
