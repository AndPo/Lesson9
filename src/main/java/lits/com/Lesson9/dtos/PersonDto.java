package lits.com.Lesson9.dtos;

import lits.com.Lesson9.entity.Person;

import javax.persistence.*;


public class PersonDto extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String name;
    @Column
    private int age;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
