package com.gostyle.controllers;

import com.gostyle.entities.Coupon;
import com.gostyle.entities.User;
import com.gostyle.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAll();
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") Long id) {
        User user = service.read(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/identification")
    public ResponseEntity<User> getUserByEmailAndPassword(@PathParam("email") String email, @PathParam("password") String password) {
        User user = service.findUserByMailAndPassword(email, password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{idUser}/addCoupon")
    public void addCouponForUser(
            @PathVariable("idUser") Long idUser,
            @PathParam("idCoupon") Long idCoupon) {
        service.addCouponForUser(idUser, idCoupon);
    }

    @PostMapping("/add")
    public void addUser(
            @PathParam("mail") String mail,
            @PathParam("password") String password,
            @PathParam("name") String name,
            @PathParam("surname") String surname) {
        service.addUser(mail, password, name, surname);
    }
}
