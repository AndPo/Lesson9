package lits.com.Lesson9.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@EqualsAndHashCode(exclude = "id")
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column
   private String name;
   @Column
   private String description;


}
