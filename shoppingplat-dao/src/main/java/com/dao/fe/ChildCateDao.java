package com.dao.fe;

import com.entity.fe.ChildCateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface ChildCateDao {
    List<ChildCateEntity> getById(int father_id);

    List<ChildCateEntity> getAll();

    void insert(String name,Integer cateId);

    void update(@Param("name") String name,@Param("id") Integer id);

    Integer getProductCount(Integer cateId);
    void delete(Integer cateId);
}
