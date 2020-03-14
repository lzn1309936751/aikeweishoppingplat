package com.entity.fe;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lzn
 */
@Data
public class ProductEntity {
    Integer pro_id;
    String pro_name;
    /**商品货号*/
    String pro_code;
    Integer pro_num;
    /**折扣*/
    Double pro_discount;
    /**网站价*/
    BigDecimal pro_iPrice;
    String pro_Desc;
    /**累计销售量*/
    Integer pro_allSaleNum;
    Integer child_id;
    Integer deleted;

    String child_name;

    String img_path;

    public InformationEntity information;


    public Double getCompute(){
        Double price=pro_iPrice.doubleValue();
        Double result=pro_discount*price;
        return result;
    }

    public Double getSave(){
        Double price=pro_iPrice.doubleValue();
        Double result=(1-pro_discount)*price;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductEntity)) {
            return false;
        }
        ProductEntity that = (ProductEntity) o;
        return pro_id.equals(that.pro_id) &&
                pro_name.equals(that.pro_name) &&
                pro_code.equals(that.pro_code) &&
                pro_num.equals(that.pro_num) &&
                pro_discount.equals(that.pro_discount) &&
                pro_iPrice.equals(that.pro_iPrice) &&
                pro_Desc.equals(that.pro_Desc) &&
                pro_allSaleNum.equals(that.pro_allSaleNum) &&
                child_id.equals(that.child_id) &&
                deleted.equals(that.deleted) &&
                child_name.equals(that.child_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pro_id, pro_name, pro_code, pro_num, pro_discount,
                pro_iPrice, pro_Desc, pro_allSaleNum, child_id,deleted, child_name);
    }
}
