package com.gostyle.controllers;

import com.gostyle.entities.Coupon;
import com.gostyle.services.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final static Logger log = LoggerFactory.getLogger(CouponController.class);

    private CouponService service;

    public CouponController(CouponService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> coupons = service.getAll();
        if (coupons != null) {
            return new ResponseEntity<>(coupons, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getOneCoupon(@PathVariable("id") Long id) {
        Coupon coupon = service.read(id);
        if (coupon != null) {
            return new ResponseEntity<>(coupon, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info={info}")
    public ResponseEntity<List<Coupon>> getAllCouponsByInfo(@PathVariable("info") Long info) {
        List<Coupon> coupons = service.getAllByInfo(info);
        if (coupons != null) {
            return new ResponseEntity<>(coupons, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
