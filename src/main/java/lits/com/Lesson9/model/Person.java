package lits.com.Lesson9.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table
@Builder
public class Person {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Boolean dead;

    public Person(){}


}
