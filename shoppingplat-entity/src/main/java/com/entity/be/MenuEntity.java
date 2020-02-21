package com.entity.be;

import lombok.Data;

/**
 * @author lzn
 */
@Data
public class MenuEntity {
	private String id;
	private String name;
	private String uri;
	private Boolean parent;
	private Integer pid;
}
