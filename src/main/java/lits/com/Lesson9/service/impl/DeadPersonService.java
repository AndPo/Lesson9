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

@Service
@Qualifier(value = "dead")
public class DeadPersonService implements PersonService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDto getById(Long id) {
        Person one = null; //personRepository.findOne(id);
        if(one==null){
            throw new RuntimeException("User not found");
        }
        return personMapper.toDto(one);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List <Person> list = personRepository.findAll();
        List<PersonDto> resList = new ArrayList<>();
        for (Person person:list){
            resList.add(modelMapper.map(person, PersonDto.class));
        }
        return resList;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Person entity = personMapper.toEntity(personDto);
        return personMapper.toDto(personRepository.save(entity));
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        return null;
    }

    @Override
    public List<PersonDto> getAllPersonsByName(String name) {
        return null;
    }

    @Override
    public List<PersonDto> findByNameAndAge(String name, Integer age) {
        return null;
    }


}
