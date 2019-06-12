package lits.com.Lesson9.service.impl;
import lits.com.Lesson9.dtos.PersonDto;
import lits.com.Lesson9.entity.Person;
import lits.com.Lesson9.repository.PersonRepository;
import lits.com.Lesson9.service.PersonService;
import lits.com.Lesson9.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "alive")
public class AlivePersonService implements PersonService {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDto getById(Integer id) {
        return personMapper.toDto(personRepository.findOne(id));
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> list = personRepository.findAll();
        List<PersonDto> resultList = new ArrayList<>();
        for (Person person :list) {
            resultList.add(personMapper.toDto(person));
        }
        return  resultList;
    }

    @Override
    public PersonDto save(PersonDto personDto)
    {
        Person entity = personMapper.toEntity(personDto);
        return personMapper.toDto(personRepository.save(entity));
    }
}
