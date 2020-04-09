package com.service.be;

import com.dao.fe.ImageDao;
import com.entity.fe.ImageEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class ImageService {
    @Autowired
    private ImageDao imageDao;

    public List<ImageEntity> getAll(Integer pageNum,Integer pageSize){
        return imageDao.getAll(pageNum, pageSize);
    }

    public void insertImg(ImageEntity imageEntity){
        imageDao.insertImg(imageEntity);
    }
}
