package com.gostyle.services;

import com.gostyle.entities.Coupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(CouponServiceImplTest.class);

    @Autowired
    private CouponService service;

    @BeforeEach
    void setUp() {
        log.trace("Check if service Coupon is Injected ...");
        assertNotNull(service, "ERROR Service Coupon NOT Injected !!!");
        log.trace("Service Coupon Injected");
    }

    @Test
    void getAll() {
        var lst = service.getAll();
        lst.forEach(a -> log.trace("{}", a));
        log.trace("Total number of coupons : {}", lst.size());
    }

    @Test
    void create() {
        Coupon coupon = new Coupon();
        coupon.setLibelle("TestLibelle");
        coupon.setDescription("TestDescription");
        coupon.setDate_end(LocalDate.parse("2020-01-08"));
        coupon.setCompteur(null);
        coupon.setInfo(1L);

        service.create(coupon);
        log.trace("Create Coupon : {}", coupon);
    }

    @Test
    void read() {
        Long id = 3L;
        Coupon coupon = service.read(id);
        log.trace("Coupon : {}", coupon);
    }

    @Test
    void update() {
        Coupon coupon = service.read(3L);
        coupon.setLibelle("TestUpdate");
        service.update(coupon);
        log.trace("Update Coupon : {}", coupon);
    }

    @Test
    void delete() {
        service.delete(3L);
        assertNull(service.read(3L));
    }

    @Test
    void getAllByInfo() {
        Long info = 1L;
        var lst = service.getAllByInfo(info);
        lst.forEach(a -> log.trace("{}", a));
        log.trace("Total number of coupons with info {} : {}", info, lst.size());
    }
}
