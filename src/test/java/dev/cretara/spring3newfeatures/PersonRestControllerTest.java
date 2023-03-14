package dev.cretara.spring3newfeatures;

import dev.cretara.spring3newfeatures.configuration.DataGenerator;
import dev.cretara.spring3newfeatures.person.model.Person;
import dev.cretara.spring3newfeatures.person.service.IPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DataGenerator dataGenerator;
    private Person firstPerson;
    private Person secondPerson;
    @MockBean
    private IPersonService personService;
    private List<Person> persons;

    @BeforeEach
    void setUp() {
        firstPerson = dataGenerator.generateFakePerson();
        secondPerson = dataGenerator.generateFakePerson();
        persons = Arrays.asList(firstPerson, secondPerson);
    }

    @Test
    void testGetAllPerson_withIntegrationTest() throws Exception {
        when(personService.getAllPerson()).thenReturn(persons.iterator());
        mockMvc.perform(get("/persons/"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(2)))
               .andExpect(jsonPath("$[0].name", is(firstPerson.getName())))
               .andExpect(jsonPath("$[0].surname", is(firstPerson.getSurname())))
               .andExpect(jsonPath("$[0].cf", is(firstPerson.getCf())))
               .andExpect(jsonPath("$[1].name", is(secondPerson.getName())))
               .andExpect(jsonPath("$[1].surname", is(secondPerson.getSurname())))
               .andExpect(jsonPath("$[1].cf", is(secondPerson.getCf())));
    }

}

