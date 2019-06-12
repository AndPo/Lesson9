package lits.com.Lesson9.entity;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String name;
    @Column
    private int age;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
