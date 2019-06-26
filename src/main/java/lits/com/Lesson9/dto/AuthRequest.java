package lits.com.Lesson9.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
@Data
public class AuthRequest {
    @NotEmpty
    @Size(max = 64)
    private String email;
    @NotEmpty
    @Size(max = 32)
    private String password;


}
