package com.gostyle.services;

import com.gostyle.entities.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> getAll();
    Coupon create(Coupon coupon);
    Coupon read(Long id);
    Coupon update(Coupon coupon);
    void delete(Long id);
    List<Coupon> getAllByInfo(Long info);
}
