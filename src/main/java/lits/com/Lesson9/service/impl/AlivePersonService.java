package lits.com.Lesson9.service.impl;
import lits.com.Lesson9.dto.PersonDto;
import lits.com.Lesson9.model.Person;
import lits.com.Lesson9.repository.PersonRepository;
import lits.com.Lesson9.service.PersonService;
import lits.com.Lesson9.service.mapper.PersonMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier(value = "alive")
public class AlivePersonService implements PersonService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDto getById(Long id) {
         return Optional.ofNullable(personRepository.findOne(id))
                .map(e -> modelMapper.map(e, PersonDto.class))
                .orElse(new PersonDto());
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> list = personRepository.findAll();
        List<PersonDto> resultList = new ArrayList<>();
        for (Person person :list) {
            resultList.add(modelMapper.map(person, PersonDto.class));
        }
        return  resultList;
    }

    @Override
    public PersonDto save(PersonDto personDto)
    {
        Person entity = personMapper.toEntity(personDto);
        return personMapper.toDto(personRepository.save(entity));
    }

    @Override
    public List<PersonDto> findByNameAndAge(String name, Integer age) {
        return personRepository.findByNameAndAge(name, age).stream()
                .filter(e -> !e.getDead())
                .map(e -> modelMapper.map(e, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        return Optional.ofNullable(personDto)
                .map(e -> modelMapper.map(e, Person.class))
                .map(e -> personRepository.save(e))
                .map(e -> modelMapper.map(e, PersonDto.class))
                .orElse(new PersonDto());
    }

    @Override
    public List<PersonDto> getAllPersonsByName(String name) {
        return personRepository.findAllByNameContains(name).stream()
                .filter(e -> !e.getDead())
                .map(e -> modelMapper.map(e, PersonDto.class))
                .collect(Collectors.toList());
    }



    Person person = Person.builder().build();


}
