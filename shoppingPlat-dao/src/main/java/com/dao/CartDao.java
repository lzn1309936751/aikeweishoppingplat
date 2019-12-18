package com.dao;

import com.entity.CartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CartDao {
    void insert(CartEntity carts);

    List<CartEntity> getAll(int user_id);

    CartEntity getCartPrice(@Param("pro_id") int pro_id,@Param("user_id") int user_id);
    void update(@Param("num") int num,@Param("subTotal") double subTotal,
                @Param("pro_id") int pro_id,@Param("user_id") int user_id);

    Integer recordCartCount(int user_id);

}
