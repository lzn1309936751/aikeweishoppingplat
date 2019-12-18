package com.service;

import com.dao.CartDao;
import com.entity.CartEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class CartService {
    @Autowired
    private CartDao cartDao;

    public void insert(CartEntity carts){
        cartDao.insert(carts);
    }

    public List<CartEntity> getAll(int user_id){
        return cartDao.getAll(user_id);
    }

    public CartEntity getCartPrice(int pro_id,int user_id){
        return cartDao.getCartPrice(pro_id,user_id);
    }

    public void update(int num,double subTotal,int pro_id,int user_id){
        cartDao.update(num,subTotal,pro_id,user_id);
    }

    public Integer recordCartCount(int user_id){
        return cartDao.recordCartCount(user_id);
    }

}
