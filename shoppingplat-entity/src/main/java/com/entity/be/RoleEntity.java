package com.entity.be;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lzn
 */
@Data
@AllArgsConstructor
public class RoleEntity {
	private String id;
	private String name;
	private String description;
	public RoleEntity() {}

	
}
