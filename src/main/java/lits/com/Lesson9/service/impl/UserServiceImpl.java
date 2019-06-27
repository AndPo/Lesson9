package lits.com.Lesson9.service.impl;

import lits.com.Lesson9.model.User;
import lits.com.Lesson9.repository.UserRepository;
import lits.com.Lesson9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    //TODO implement UserDto to service
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(s);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        //todo add correct authotities
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<GrantedAuthority> getAuthority(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });

        return authorities;
    }

    /*public User findById(Long id) {
        return userRepository.findById(id);
    }*/
}
