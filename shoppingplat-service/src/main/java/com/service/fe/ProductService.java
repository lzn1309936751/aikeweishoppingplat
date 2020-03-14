package com.service.fe;

import com.dao.fe.ImageDao;
import com.dao.fe.ProductDao;
import com.entity.fe.ImageEntity;
import com.entity.fe.ProductEntity;
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

    public ProductEntity insert(ProductEntity productEntity){
        return productDao.insert(productEntity);
    }

    public ProductEntity update(ProductEntity productEntity,Integer pid){
        return productDao.update(productEntity,pid);
    }

}
