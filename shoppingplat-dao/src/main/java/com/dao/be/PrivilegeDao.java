package com.dao.be;

import com.entity.be.MenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface PrivilegeDao {
    void deleteRolePrivilege(String roleId);

    void insertRolePrivilege(@Param("roleId") String roleId,
                             @Param("privileges") List<MenuEntity> privileges);

}
