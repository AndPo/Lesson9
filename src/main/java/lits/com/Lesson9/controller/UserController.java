package lits.com.Lesson9.controller;

import lits.com.Lesson9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
