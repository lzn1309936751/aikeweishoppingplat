package com.service.be;

import com.dao.be.PrivilegeDao;
import com.entity.be.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class PrivilegeService {
    @Autowired
    private PrivilegeDao privilegeDao;

    @Transactional(rollbackFor = RuntimeException.class)
    public void updateRolePrivilege(String roleId, List<MenuEntity> privileges){
        privilegeDao.deleteRolePrivilege(roleId);
        privilegeDao.insertRolePrivilege(roleId, privileges);
    }
}
