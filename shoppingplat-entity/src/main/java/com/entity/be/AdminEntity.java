package com.entity.be;

import lombok.Data;

/**
 * @author lzn
 */
@Data
public class AdminEntity {
	private String admin_id;
	private String admin_name;
	private String admin_pwd;
	private Integer admin_sex;
	private String admin_idCard;
	private String admin_address;
	private String admin_phone;
	private Integer admin_salary;
	private String admin_email;
	private String name; //TODO: 删除
}
