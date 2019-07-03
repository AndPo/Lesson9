package lits.com.Lesson9.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class PersonDto {

    private Long id;
    @NotNull
    private String name;

    private int age;

}
