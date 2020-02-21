package com.service.be;

import com.dao.be.MenuDao;
import com.entity.be.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public MenuEntity findMenuById(String id){
        return menuDao.findMenuById(id);
    }

    public List<MenuEntity> getAllMenus(){
        return menuDao.getAllMenus();
    }
}
