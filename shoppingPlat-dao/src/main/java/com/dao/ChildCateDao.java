package com.dao;

import com.entity.ChildCateEntity;

import java.util.List;

/**
 * @author lzn
 */
public interface ChildCateDao {
    List<ChildCateEntity> getById(int father_id);
}
