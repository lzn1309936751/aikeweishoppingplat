package com.service.be;

import com.dao.be.AdminDao;
import com.entity.be.AdminEntity;
import com.entity.be.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public boolean addUser(AdminEntity admin){
        return adminDao.addUser(admin);
    }

    public AdminEntity findUser(String id){
        return adminDao.findUser(id);
    }

    public List<AdminEntity> getAllUser(){
        return adminDao.getAll();
    }

    public RoleEntity getUserRoles(String userId){
        return adminDao.getRoles(userId);
    }

    public AdminEntity findUserByUsernameAndPassword(String userName,String password){
        return adminDao.findUserByUsernameAndPassword(userName,password);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUserRole(AdminEntity admin, String roleId){
        adminDao.deleteRolesByUserId(admin.getAdmin_id());
        adminDao.insertUserRole(admin.getAdmin_id(),roleId);
    }

}
