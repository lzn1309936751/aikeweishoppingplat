package com.dao.fe;

import com.entity.fe.ChildCateEntity;

import java.util.List;

/**
 * @author lzn
 */
public interface ChildCateDao {
    List<ChildCateEntity> getById(int father_id);

    List<ChildCateEntity> getAll();
}
