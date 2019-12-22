package com.entity;

import java.util.List;
import java.util.Set;

/**
 * @author lzn
 */
public class OrderProductVO {
    private List<OrderEntity> orders;
    private Set<OrderEntity> set;
    private Integer cid;


    public OrderProductVO() {
    }

    public OrderProductVO(Set<OrderEntity> set,Integer cid) {
        this.set = set;
        this.cid=cid;
    }
}
