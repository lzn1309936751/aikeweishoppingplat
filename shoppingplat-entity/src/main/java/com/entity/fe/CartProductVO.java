package com.entity.fe;

import com.entity.fe.CartEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author lzn
 */
@Data
public class CartProductVO {
    private List<CartEntity> carts;
    private Set<CartEntity> set;
    private Integer cid;


    public CartProductVO() {
    }

    public CartProductVO(Set<CartEntity> map,Integer cid) {
        this.set = map;
        this.cid=cid;
    }
}
