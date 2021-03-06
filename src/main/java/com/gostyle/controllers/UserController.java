package com.gostyle.controllers;

import com.gostyle.entities.User;
import com.gostyle.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return service.read(id);
    }

    @PutMapping("/addCoupon/user={idUser}&coupon={idCoupon}")
    public void addCouponForUser(@PathVariable("idUser") Long idUser, @PathVariable("idCoupon") Long idCoupon) {
        service.addCouponForUser(idUser, idCoupon);
    }
}
