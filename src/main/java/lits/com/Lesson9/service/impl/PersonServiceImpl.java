package lits.com.Lesson9.service.impl;

import lits.com.Lesson9.dto.PersonDto;
import lits.com.Lesson9.model.Person;
import lits.com.Lesson9.repository.PersonRepository;
import lits.com.Lesson9.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PersonDto getById(Long id) {
        return Optional.ofNullable(personRepository.findOne(id))
                .map(e -> modelMapper.map(e, PersonDto.class))
                .orElse(new PersonDto());
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(e -> modelMapper.map(e, PersonDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<PersonDto> getAllPersonsByName(String name) {
        return personRepository.findAllByNameContains(name).stream()
                .map(e -> modelMapper.map(e, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        return Optional.ofNullable(personDto)
                .map(e -> modelMapper.map(e, Person.class))
                .map(e -> personRepository.save(e))
                .map(e -> modelMapper.map(e, PersonDto.class))
                .orElse(new PersonDto());
    }

    @Override
    public List<PersonDto> findByNameAndAge(String name, Integer age) {
        return personRepository.findByNameAndAge(name, age).stream()
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
}
