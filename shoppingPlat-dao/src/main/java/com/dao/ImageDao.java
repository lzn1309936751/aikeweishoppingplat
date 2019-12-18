package com.dao;

import com.entity.ImageEntity;

import java.util.List;


/**
 * @author lzn
 */
public interface ImageDao {
    List<ImageEntity> getById(int pro_id);
}
