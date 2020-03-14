package com.dao.fe;

import com.entity.fe.InformationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface InformationDao {
    InformationEntity getById(int pro_id);

    List<InformationEntity> getAll(@Param("pageNum") Integer pageNum,
                                   @Param("pageSize") Integer pageSize);

    InformationEntity update(InformationEntity informationEntity,Integer id);

    InformationEntity insert(InformationEntity entity);

}
