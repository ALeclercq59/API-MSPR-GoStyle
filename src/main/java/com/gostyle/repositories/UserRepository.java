package com.gostyle.repositories;

import com.gostyle.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMailEqualsAndPasswordEquals(String mail, String password);
    User findByMailIsAndPasswordIs(String mail, String password);
}
