package com.entity;

import com.custom.NotRegister;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author lzn
 */
@Data
public class UserEntity {
    Integer user_id;
    String user_name;
    @Size(min = 6,max = 18,message = "密码长度在6-18之间")
    String user_pwd;
    /**0表示男，1表示女*/
    Integer user_sex;
    @NotRegister(message = "电话号码只能由11位数字组成")
    String user_phone;
    /**外键,省份*/
    String province_id;
    /**外键,城市*/
    String city_id;
    /**外键,县区*/
    String county_id;
    /**头像*/
    String user_face;
    /**注册时间*/
    @FutureOrPresent
    Date user_regTime;
}
