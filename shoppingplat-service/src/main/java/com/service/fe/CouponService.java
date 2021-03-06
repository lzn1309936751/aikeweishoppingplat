package com.service.fe;

import com.dao.fe.CouponDao;
import com.entity.fe.CouponEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class CouponService {
    @Autowired
    private CouponDao dao;

    public CouponEntity getByMoney(double total) {
        return dao.getByMoney(total);
    }

    public List<CouponEntity> getAll(){
        return dao.getAll();
    }
}
