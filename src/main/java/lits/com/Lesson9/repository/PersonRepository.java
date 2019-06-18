package lits.com.Lesson9.repository;

import lits.com.Lesson9.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface PersonRepository extends JpaRepository<Person, Integer> {



}
