package com.controller.be.role;

import com.entity.be.MenuEntity;
import com.entity.be.RoleEntity;
import com.service.be.MenuService;
import com.service.be.PrivilegeService;
import com.service.be.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class RolePrivilegeInsertServlet {

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

	@RequestMapping("/admin/role-privilege/insert")
    @ResponseBody
	protected Object service(String[] privilege_id,String role_id) {

		RoleEntity role = roleService.findRole(role_id);

		List<MenuEntity> list = new ArrayList<MenuEntity>();
		for(String pid:privilege_id) {
			MenuEntity privilege = menuService.findMenuById(pid);
			list.add(privilege);
		}

        privilegeService.updateRolePrivilege(role.getId(),list);
		return true;
		
	}
}
