package com.service.be;

import com.dao.fe.InformationDao;
import com.entity.fe.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class InformationService{

    @Autowired
    private InformationDao informationDao;

    public List<InformationEntity> getAll(Integer pageNum, Integer pageSize) {
        return informationDao.getAll(pageNum, pageSize);
    }

    public InformationEntity update(InformationEntity informationEntity, Integer id) {
        return informationDao.update(informationEntity,id);
    }
}
