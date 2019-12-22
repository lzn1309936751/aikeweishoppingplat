package com.service;

import com.dao.AddressDao;
import com.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;
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

    public List<AddressEntity> getProvince(String parent_id){
        return addressDao.getProvince(parent_id);
    }

    public List<AddressEntity> getCity(String parentId){
        return addressDao.getCity(parentId);
    }

    public List<AddressEntity> getCount(String parentId){
        return addressDao.getCount(parentId);
    }

    public AddressEntity getAddressName(String address_id){
        return addressDao.getAddressName(address_id);
    }
}
