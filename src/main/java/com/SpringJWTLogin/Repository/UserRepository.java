package com.SpringJWTLogin.Repository;

import com.SpringJWTLogin.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findBYUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);
}
