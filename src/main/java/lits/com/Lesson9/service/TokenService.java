package lits.com.Lesson9.service;


public interface TokenService {

    Long parseToken(String token);

    String createToken(Long id);
}
