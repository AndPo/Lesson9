package lits.com.Lesson9.repository;

import lits.com.Lesson9.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name, Integer age);

    List<Person> findAllByNameContains(String name);



}
