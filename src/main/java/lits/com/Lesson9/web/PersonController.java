package lits.com.Lesson9.web;

import lits.com.Lesson9.dtos.PersonDto;
import lits.com.Lesson9.entity.Person;
import lits.com.Lesson9.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/app")
public class PersonController {

    @Autowired
    @Qualifier(value = "alive")
    private PersonService personService;

    /*@Autowired
    @Qualifier(value = "dead")
    private PersonService deadPersonService;*/

    @GetMapping()
    public String getPersonById(){
        return "Hello world";
    }

    @PostMapping
    public Person savePerson(@RequestBody PersonDto personDto){
        return personService.save(personDto);
    }

    @GetMapping(value = "/user/{id}")
    public Person getPersonById(@PathVariable Integer id){
        return personService.getById(id);
    }
   /* public Person getPersonById(@PathVariable Integer id){
        return  personService.getById(id);
    }

    public Person savePerson(@RequestBody Person person){
        return personService.save(person);
    }*/
}
