package lits.com.Lesson9.service;

import lits.com.Lesson9.dto.PersonDto;
import lits.com.Lesson9.model.Person;
import lits.com.Lesson9.repository.PersonRepository;
import lits.com.Lesson9.service.impl.AlivePersonService;
import lits.com.Lesson9.service.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    PersonService personService = new AlivePersonService();

    @Test
    public void shouldSavePerson(){

        Person person = new Person();
        PersonDto personDto = new PersonDto();
        when(personMapper.toEntity(personDto)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);
        when(personMapper.toDto(person)).thenReturn(personDto);
        assertNotNull(personService.save(personDto));

    }

    @Test
    public void shouldGetPerson(){
        Person person = new Person();
        when(personRepository.findOne(1)).thenReturn(person);

        personService.getById(1);
        verify(personRepository,times(1)).findOne(1);
    }




}
