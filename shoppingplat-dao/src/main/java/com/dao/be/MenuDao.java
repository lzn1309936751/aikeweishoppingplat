package com.dao.be;

import com.entity.be.MenuEntity;

import java.util.List;

/**
 * @author lzn
 */
public interface MenuDao {
    MenuEntity findMenuById(String id);

    List<MenuEntity> getAllMenus();
}
