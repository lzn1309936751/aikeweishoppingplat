package com.entity.fe;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author lzn
 */
@Data
public class CartEntity {
    Integer cart_id;
    Date cart_time;
    Integer cart_num;
    BigDecimal cart_subTotal;
    Integer pro_id;
    Integer user_id;

    String pro_name;
    Double pro_discount;
    BigDecimal pro_iPrice;
    String pro_Desc;

    String img_path;

    public Double getCompute(){
        Double price=pro_iPrice.doubleValue();
        Double result=pro_discount*price;
        BigDecimal bg=new BigDecimal(result);
        double result1=bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return result1;
    }

    public Double getSave(){
        Double price=pro_iPrice.doubleValue();
        Double result=(1-pro_discount)*price;
        BigDecimal bg=new BigDecimal(result);
        double result2=bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return result2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CartEntity)) {
            return false;
        }
        CartEntity that = (CartEntity) o;
        return cart_id.equals(that.cart_id) &&
                cart_time.equals(that.cart_time) &&
                cart_num.equals(that.cart_num) &&
                cart_subTotal.equals(that.cart_subTotal) &&
                pro_id.equals(that.pro_id) &&
                user_id.equals(that.user_id) &&
                pro_name.equals(that.pro_name) &&
                pro_discount.equals(that.pro_discount) &&
                pro_iPrice.equals(that.pro_iPrice) &&
                pro_Desc.equals(that.pro_Desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_id, cart_time, cart_num, cart_subTotal,
                pro_id, user_id, pro_name, pro_discount, pro_iPrice, pro_Desc);
    }
}
