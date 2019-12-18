package com.dao;

import com.entity.CouponEntity;
import org.apache.ibatis.annotations.Param;

public interface CouponDao {
    CouponEntity getByMoney(@Param("total") double total);
}
