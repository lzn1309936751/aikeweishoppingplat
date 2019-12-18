package com.service;

import com.dao.UserDao;
import com.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public List<UserEntity> getAll(int pageNum, int pageSize) {
        return dao.getAll(pageNum,pageSize);
    }

    public UserEntity getByName(String username) {
        return dao.getByName(username);
    }

    public void insert(UserEntity users) {
        dao.insert(users);
    }

    public void update(UserEntity users) {
        dao.update(users);
    }

    public UserEntity getUserId(String username){
        return dao.getUserId(username);
    }
}
