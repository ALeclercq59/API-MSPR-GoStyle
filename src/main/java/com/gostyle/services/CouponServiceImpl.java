package com.gostyle.services;

import com.gostyle.entities.Coupon;
import com.gostyle.repositories.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService{
    private final static Logger log = LoggerFactory.getLogger(CouponServiceImpl.class);

    private final CouponRepository repository;

    public CouponServiceImpl(CouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Coupon> getAll() {
        return repository.findAll();
    }

    @Override
    public Coupon create(Coupon coupon) {
        return repository.save(coupon);
    }

    @Override
    public Coupon read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Coupon update(Coupon coupon) {
        return repository.saveAndFlush(coupon);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Coupon> getAllByInfo(Long id) {
        return repository.findAllByInfo(id);
    }
}
