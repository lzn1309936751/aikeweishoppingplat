package com.entity.fe;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author lzn
 */
@Data
public class CollectEntity {
    Integer collect_id;
    Date collect_time;
    Integer pro_id;
    Integer user_id;
    Integer deleted;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CollectEntity)) {
            return false;
        }
        CollectEntity that = (CollectEntity) o;
        return collect_id.equals(that.collect_id) &&
                collect_time.equals(that.collect_time) &&
                pro_id.equals(that.pro_id) &&
                user_id.equals(that.user_id) &&
                deleted.equals(that.deleted) &&
                pro_name.equals(that.pro_name) &&
                pro_discount.equals(that.pro_discount) &&
                pro_iPrice.equals(that.pro_iPrice) &&
                pro_Desc.equals(that.pro_Desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collect_id, collect_time,pro_id, user_id,deleted,
                pro_name, pro_discount, pro_iPrice, pro_Desc);
    }
}
