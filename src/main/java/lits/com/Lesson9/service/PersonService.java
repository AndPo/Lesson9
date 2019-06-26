package lits.com.Lesson9.service;
import lits.com.Lesson9.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto getById(long id);
    List<PersonDto>getAllPersons();
    PersonDto save(PersonDto personDto);

    PersonDto update(PersonDto personDto);

    List<PersonDto> getAllPersonsByName(String name);

}
