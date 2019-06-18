package lits.com.Lesson9.entity;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;
    private Integer age;
    private Boolean dead;

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

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }
}
