package com.gostyle.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    private final static Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void setUp() {
        log.trace("setUp before All ...");
        assertNotNull(repository,"User Repository is NOT Inject !!!");
    }

    @Test
    void findAllUsers() {
        log.trace("START findAllUsers");
        var lst = repository.findAll();
        lst.forEach(c->log.trace("{}", c));
        log.trace("Number of users : {}", lst.size());
        log.trace("END findAllUsers");
    }

    @Test
    void findOneUser() {
        log.trace("START findOneUser");
        Long id = 1L;
        var user = repository.findById(id).orElse(null);
        assertNotNull(user,"ERROR User number "+id+" NOT PRESENT !!!!");
        log.trace("User : {}", user);
        log.trace("END findOneUser");
    }

    @Test
    void findByMailContainsAndPasswordContains() {
        log.trace("START findOneUser");
        String mail = "anthony@gmail.com";
        String password = "anthony";
        var user = repository.findByMailEqualsAndPasswordEquals(mail, password);
        log.trace("User : {}", user);
        log.trace("END findOneUser");
    }
}
