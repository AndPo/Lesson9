package lits.com.Lesson9.repository;

import lits.com.Lesson9.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class PersonRepository implements JpaRepository<Person, Integer> {



}
