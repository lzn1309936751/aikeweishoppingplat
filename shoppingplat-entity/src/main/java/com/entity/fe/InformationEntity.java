package com.entity.fe;

import lombok.Data;

import java.util.Date;

/**
 * @author lzn
 */
@Data
public class InformationEntity {
    Integer info_id;
    /**生产许可证编号SC12444034200297*/
    String info_code;
    /**厂名: 深圳市幸福西饼食品有限公司*/
    String factory_name;
    /**厂址*/
    String factory_address;
    /**厂家联系方式: 400-999-6666*/
    String factory_phone;
    /**生产日期*/
    Date product_time;
    /**保质期*/
    Date keep_time;
    /**配送全国*/
    String delivery_address;

    Integer pro_id;

    String pro_name;

    Integer deleted;
}
