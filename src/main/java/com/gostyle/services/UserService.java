package com.gostyle.services;

import com.gostyle.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User create(User user);
    User read(Long id);
    User update(User user);
    void delete(Long id);
    User findUserByMailAndPassword(String mail, String password);
    void addCouponForUser(Long idUser, Long idCoupon);
    void deleteCouponForUser(Long idUser, Long idCoupon);
}
