package com.service.fe;

import com.dao.fe.AppriseDao;
import com.entity.fe.AppriseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzn
 */
@Service
public class AppriseService {
    @Autowired
    private AppriseDao appriseDao;

    public void insert(AppriseEntity appriseEntity){
        appriseDao.insert(appriseEntity);
    }

}
