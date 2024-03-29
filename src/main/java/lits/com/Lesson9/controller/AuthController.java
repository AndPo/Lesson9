package lits.com.Lesson9.controller;

import lits.com.Lesson9.dto.AuthRequest;
import lits.com.Lesson9.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> auth(@RequestBody AuthRequest auth){
        return ResponseEntity.ok(authService.auth(auth.getEmail(), auth.getPassword()));
    }

}
