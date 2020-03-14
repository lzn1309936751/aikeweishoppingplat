package com.dao.fe;

import com.entity.fe.CouponEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponDao {
    CouponEntity getByMoney(@Param("total") double total);

    List<CouponEntity> getAll();

    void insert(@Param("name") Integer name,@Param("money") Integer money);

    void update(@Param("name") Integer name,@Param("money") Integer money,@Param("id") Integer id);

    void delete(Integer id);
}
