package com.entity.fe;

import com.entity.fe.ProductEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author lzn
 */
@Data
public class ProductImageVO {
    private List<ProductEntity> products;
    private Set<ProductEntity> set;

    private Integer cid;

    public ProductImageVO() {
    }

    public ProductImageVO(Set<ProductEntity> set, Integer cid) {
        this.set = set;
        this.cid = cid;
    }
}
