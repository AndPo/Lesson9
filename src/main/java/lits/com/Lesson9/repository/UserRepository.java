package lits.com.Lesson9.repository;

import lits.com.Lesson9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    User findOneByEmail(String email);
}
