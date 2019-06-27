package lits.com.Lesson9.repository;

import lits.com.Lesson9.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByNameContains(String name);

    List<Person> findByNameAndAge(String name, Integer age);
}
