package lits.com.Lesson9.service;
import lits.com.Lesson9.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto getById(Long id);

    List<PersonDto>getAllPersons();

    PersonDto save(PersonDto personDto);

    PersonDto update(PersonDto personDto);

    List<PersonDto> getAllPersonsByName(String name);

    List<PersonDto> findByNameAndAge(String name, Integer age);

}
