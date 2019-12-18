package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lzn
 */
@Data
public class AppriseEntity {
    Integer apprise_id;
    String apprise_context;
    String apprise_grade;
    Integer apprise_num;
    Date apprise_time;
    Integer pro_id;
    Integer user_id;
}
