package lits.com.Lesson9.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(Long accountId, String roles) {
        return new JwtUser(
                accountId,
                roles
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}
