package lits.com.Lesson9.service;

import lits.com.Lesson9.dtos.PersonDto;
import lits.com.Lesson9.entity.Person;

import java.util.List;

public interface PersonService {

    PersonDto getById(Integer id);
    List<PersonDto>getAllPersons();
    PersonDto save(PersonDto personDto);

}
