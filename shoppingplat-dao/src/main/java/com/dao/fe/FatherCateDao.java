package com.dao.fe;

import com.entity.fe.FatherCateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface FatherCateDao {
    List<FatherCateEntity> getAll();

    void insert(String name);

    void update(@Param("name") String name,@Param("id") Integer id);

    Integer getChildCateCount(Integer cateId);
    void delete(Integer cateId);
}
