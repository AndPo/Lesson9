package lits.com.Lesson9.service.mapper;

import lits.com.Lesson9.dto.PersonDto;
import lits.com.Lesson9.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toEntity(PersonDto personDto){
        Person person = new Person();
        person.setName(personDto.getName());
        person.setAge(personDto.getAge());
        person.setId(personDto.getId());

        return person;
    }
    public PersonDto toDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setAge(person.getAge());
        personDto.setName(person.getName());
        personDto.setId(person.getId());

        return personDto;
    }

}
