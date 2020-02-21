package com.entity.fe;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author lzn
 */
@Data
public class OrderEntity {
    Integer order_id;
    Date order_time;
    Integer order_amount;
    Double order_money;
    String order_status;
    Integer apprise_status;
    Integer pro_id;
    Integer user_id;

    String pro_name;
    Double pro_discount;
    BigDecimal pro_iPrice;

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
        if (!(o instanceof OrderEntity)) {
            return false;
        }
        OrderEntity that = (OrderEntity) o;
        return order_id.equals(that.order_id) &&
                order_time.equals(that.order_time) &&
                order_amount.equals(that.order_amount) &&
                order_money.equals(that.order_money) &&
                order_status.equals(that.order_status) &&
                apprise_status.equals(that.apprise_status) &&
                pro_id.equals(that.pro_id) &&
                user_id.equals(that.user_id) &&
                pro_name.equals(that.pro_name) &&
                pro_discount.equals(that.pro_discount) &&
                pro_iPrice.equals(that.pro_iPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, order_time, order_amount,
                order_money, order_status,apprise_status, pro_id, user_id, pro_name,
                pro_discount, pro_iPrice);
    }
}
