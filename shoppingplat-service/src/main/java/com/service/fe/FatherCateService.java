package com.service.fe;

import com.dao.fe.FatherCateDao;
import com.entity.fe.FatherCateEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class FatherCateService  {
    @Autowired
    private FatherCateDao dao;

    public List<FatherCateEntity> getAll() {
        return dao.getAll();
    }

    public void insert(String name){
        dao.insert(name);
    }

    public void update(@Param("name") String name, @Param("id") Integer id){
        dao.update(name, id);
    }

    public void delete(Integer cateId){
        Integer count = dao.getChildCateCount(cateId);
        if (count==0){
            dao.delete(cateId);
        }
    }

}
