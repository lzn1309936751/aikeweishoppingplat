package com.dao.fe;

import com.entity.fe.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface UserDao {
    List<UserEntity> getAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    UserEntity getByName(String username);

    void insert(UserEntity users);

    void update(UserEntity users);

    UserEntity getUserId(String username);

}
