package com.entity.fe;

import lombok.Data;

/**
 * @author lzn
 */
@Data
public class ChildCateEntity {
    Integer child_id;
    String child_name;
    Integer father_id;
    Integer deleted;
}
