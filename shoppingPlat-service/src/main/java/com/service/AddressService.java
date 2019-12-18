package com.service;

import com.dao.AddressDao;
import com.entity.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    public List<AddressEntity> getAddress(){
        return addressDao.getAll();
    }
}
