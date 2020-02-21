package com.dao.fe;

import com.entity.fe.ProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface ProductDao {
    List<ProductEntity> getAll(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    /**获得子类型中的所有商品*/
    List<ProductEntity> getByCateId(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("child_id") int id);

    /**获得单个商品的所有信息*/
    ProductEntity getByMyId(int pro_id);

    /**获得最高的月销售量的商品信息*/
    ProductEntity getMonthSale();

    /**根据订单使累计销量加一*/
    ProductEntity updateSaleNum(int saleNum,int id);

    ProductEntity insert(ProductEntity products);
}
