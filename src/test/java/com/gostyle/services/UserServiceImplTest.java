package com.gostyle.services;

import com.gostyle.entities.Coupon;
import com.gostyle.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService service;

    @BeforeEach
    void setUp() {
        log.trace("Check if service User is Injected ...");
        assertNotNull(service, "ERROR Service User NOT Injected !!!");
        log.trace("Service User Injected");
    }

    @Test
    void getAll() {
        var lst = service.getAll();
        lst.forEach(a -> log.trace("{}", a));
        log.trace("Total number of users : {}", lst.size());
    }

    @Test
    void create() {
        User user = new User();
        user.setMail("Test@gmail.com");
        user.setPassword("TestPassword");
        user.setName("TestName");
        user.setSurname("TestSurname");

        service.create(user);
        log.trace("Create User : {}", user);
    }

    @Test
    @Transactional
    void read() {
        Long id = 1L;
        User user = service.read(id);
        log.trace("User : {}", user);
    }

    @Test
    void update() {
        User user = service.read(5L);
        user.setMail("TestUpdate@gmail.com");
        service.update(user);
        log.trace("Update User : {}", user);
    }

    @Test
    void delete() {
        service.delete(4L);
        assertNull(service.read(4L));
    }

    @Test
    void findUserByMailAndPassword() {
        String mail = "TestUpdate@gmail.com";
        String password = "TestPassword";
        User user = service.findUserByMailAndPassword(mail, password);
        log.trace("User : {}", user);
    }

    @Test
    void addCouponForUser() {
        service.addCouponForUser(2L, 3L);
    }

    @Test
    void addUser(){
        service.addUser("test","test","test","test");
    }
}
