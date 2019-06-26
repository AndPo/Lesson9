package lits.com.Lesson9.dto;

import lits.com.Lesson9.model.Person;
import lombok.Data;


@Data
public class PersonDto extends Person {


    private long id;

    private String name;

    private int age;

}
