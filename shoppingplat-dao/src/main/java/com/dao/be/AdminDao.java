package com.dao.be;

import com.entity.be.AdminEntity;
import com.entity.be.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface AdminDao {
    boolean addUser(AdminEntity admin);

    AdminEntity findUser(String id);

    List<AdminEntity> getAll();

    RoleEntity getRoles(String adminId);

    AdminEntity findUserByUsernameAndPassword
            (@Param("username") String userName, @Param("password") String password);

    /**
     * 修改用户角色（通过先删除用户角色，然后再添加）
     * @param adminId
     */
    void deleteRolesByUserId(String adminId);

    void insertUserRole(@Param("adminId") String adminId, @Param("roleId") String roleId);
}
