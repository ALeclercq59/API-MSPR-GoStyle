package com.gostyle.services;

import com.gostyle.entities.Coupon;
import com.gostyle.entities.User;
import com.gostyle.repositories.CouponRepository;
import com.gostyle.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository;

    private CouponService couponService;

    @Autowired
    public void setMissionService(CouponService missionService) {
        this.couponService = missionService;
    }

    public UserServiceImpl(UserRepository repository, CouponRepository couponRepository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User findUserByMailAndPassword(String mail, String password) {
        return repository.findByMailEqualsAndPasswordEquals(mail, password);
    }

    public void addCouponForUser(Long idUser, Long idCoupon) {
        User user = read(idUser);
        Coupon coupon = couponService.read(idCoupon);

        List<Coupon> couponsUser = user.getCoupons();
        couponsUser.add(coupon);
        user.setCoupons(couponsUser);

        List<User> userCoupons = coupon.getUsers();
        userCoupons.add(user);
        coupon.setUsers(userCoupons);

        couponService.update(coupon);
        update(user);
    }
}
