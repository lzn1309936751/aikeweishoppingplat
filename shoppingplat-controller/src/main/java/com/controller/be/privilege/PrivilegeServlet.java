package com.controller.be.privilege;

import com.entity.be.MenuEntity;
import com.entity.be.RoleEntity;
import com.service.be.AdminService;
import com.service.be.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class PrivilegeServlet {
    @Autowired
    private AdminService userService;
    @Autowired
    private RoleService roleService;

	@RequestMapping("/privileges/query")
    @ResponseBody
	protected List<MenuEntity> service(String id) throws ServletException, IOException {

		RoleEntity roles = userService.getUserRoles(id);
		List<MenuEntity> list = roleService.getMenusByRoleId(roles.getId());
		
		return list;
	}

	@RequestMapping("/unauthorized")
    public String unAuthorized(){
        return "be/unauthorized";
    }
}
