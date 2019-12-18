package com.service;

import com.dao.CartDao;
import com.dao.ImageDao;
import com.dao.ProductDao;
import com.entity.CartEntity;
import com.entity.ImageEntity;
import com.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class ProductService{
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ImageDao imageDao;


    public List<ProductEntity> getAll(int pageNum, int pageSize) {
        return productDao.getAll(pageNum,pageSize);
    }

    public List<ProductEntity> getByCateId(int pageNum,int pageSize,int id) {
        return productDao.getByCateId(pageNum,pageSize,id);
    }

    public ProductEntity getByMyId(int pro_id){
        return productDao.getByMyId(pro_id);
    }

    public List<ImageEntity> getByImg(int pro_id){
        return imageDao.getById(pro_id);
    }


}
