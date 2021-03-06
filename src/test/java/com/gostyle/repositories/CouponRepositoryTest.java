package com.gostyle.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponRepositoryTest {

    private final static Logger log = LoggerFactory.getLogger(CouponRepositoryTest.class);

    @Autowired
    private CouponRepository repository;

    @BeforeEach
    void setUp() {
        log.trace("setUp before All ...");
        assertNotNull(repository,"Coupon Repository is NOT Inject !!!");
    }

    @Test
    void findAllCoupons() {
        log.trace("START findAllCoupons");
        var lst = repository.findAll();
        lst.forEach(c->log.trace("{}", c));
        log.trace("Number of coupons : {}", lst.size());
        log.trace("END findAllCoupons");
    }

    @Test
    void findOneCoupon() {
        log.trace("START findOneCoupon");
        Long id = 1L;
        var coupon = repository.findById(id).orElse(null);
        assertNotNull(coupon,"ERROR City number "+id+" NOT PRESENT !!!!");
        log.trace("Coupon : {}", coupon);
        log.trace("END findOneCoupon");
    }

    @Test
    void findAllCouponsByInfo() {
        log.trace("START findAllCouponsByInfo");
        Long id = 2L;
        var lst = repository.findAllByInfo(id);
        lst.forEach(c->log.trace("{}", c));
        log.trace("Number of coupons : {}", lst.size());
        log.trace("END findAllCouponsByInfo");
    }
}
