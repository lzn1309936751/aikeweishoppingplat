package com.dao.fe;

import com.entity.fe.ImageEntity;

import java.util.List;


/**
 * @author lzn
 */
public interface ImageDao {
    List<ImageEntity> getById(int pro_id);
}
