package com.dao.fe;

import com.entity.fe.CouponEntity;
import org.apache.ibatis.annotations.Param;

public interface CouponDao {
    CouponEntity getByMoney(@Param("total") double total);
}
