package lits.com.Lesson9.service.impl;
import lits.com.Lesson9.dtos.PersonDto;
import lits.com.Lesson9.entity.Person;
import lits.com.Lesson9.repository.PersonRepository;
import lits.com.Lesson9.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeadPersonService implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonDto getById(Integer id) {
        return null;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return null;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setAge(personDto.getAge());
        return personDto;
    }
}
