package com.dao.be;

import com.entity.be.MenuEntity;
import com.entity.be.RoleEntity;

import java.util.List;

/**
 * @author lzn
 */
public interface RoleDao {
    boolean addRole(RoleEntity role);

    RoleEntity findRole(String id);

    List<RoleEntity> getAll();

    List<MenuEntity> getMenusByRoleId(String roleId);
}
