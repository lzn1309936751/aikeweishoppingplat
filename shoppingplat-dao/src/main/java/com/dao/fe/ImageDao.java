package com.dao.fe;

import com.entity.fe.ImageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author lzn
 */
public interface ImageDao {
    List<ImageEntity> getById(int pro_id);

    List<ImageEntity> getAll(@Param("pageNum") Integer pageNum,
                             @Param("pageSize") Integer pageSize);

    void insertImg(ImageEntity imageEntity);
}
