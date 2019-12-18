package com.dao;

import com.entity.AddressEntity;

import java.util.List;

/**
 * @author lzn
 */
public interface AddressDao {
    List<AddressEntity> getAll();
}
