package com.entity.fe;

import lombok.Data;

/**
 * @author lzn
 */
@Data
public class ReceiptEntity {
    Integer receipt_id;
    String receipt_name;
    String receipt_phone;
    String province_id;
    String city_id;
    String county_id;
    String receipt_detail;
    Integer receipt_bit;
    Integer user_id;
}
