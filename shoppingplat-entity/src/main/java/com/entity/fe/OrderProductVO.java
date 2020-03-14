package com.entity.fe;

import com.entity.fe.OrderEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author lzn
 */
@Data
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
