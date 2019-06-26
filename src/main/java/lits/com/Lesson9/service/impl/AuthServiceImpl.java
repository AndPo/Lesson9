package lits.com.Lesson9.service.impl;

import lits.com.Lesson9.repository.UserRepository;
import lits.com.Lesson9.service.AuthService;
import lits.com.Lesson9.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String auth(String login, String pass) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        pass
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserEntity user = userRepository.findOneByEmail(login);
        return tokenService.createToken(user.getId());
    }
}
