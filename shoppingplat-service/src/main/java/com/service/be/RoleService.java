package com.service.be;

import com.dao.be.RoleDao;
import com.entity.be.MenuEntity;
import com.entity.be.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public boolean addRole(RoleEntity role){
        return roleDao.addRole(role);
    }

    public RoleEntity findRole(String id){
        return roleDao.findRole(id);
    }

    public List<RoleEntity> getAll(){
        return roleDao.getAll();
    }

    public List<MenuEntity> getMenusByRoleId(String roleId){
        return roleDao.getMenusByRoleId(roleId);
    }
}
